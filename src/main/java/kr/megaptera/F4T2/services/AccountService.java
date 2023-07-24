package kr.megaptera.F4T2.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.exceptions.InvalidNameLength;
import kr.megaptera.F4T2.exceptions.PasswordDoNotMatch;
import kr.megaptera.F4T2.exceptions.UserIdAlreadyExist;
import kr.megaptera.F4T2.exceptions.WrongPasswordFormat;
import kr.megaptera.F4T2.exceptions.WrongUserIdFormat;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.KakaoProfile;
import kr.megaptera.F4T2.models.OauthToken;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@Transactional
public class AccountService {
    @Value("${kakao.clientId}")
    String client_id;

    @Value("${FRONT_URL}")
    String FRONT_URL;

    @Value("${fakePassword}")
    String fakePassword;

    @Value("${jwt.secret}")
    String secret;

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final JwtUtil jwtUtil;

    public AccountService(PasswordEncoder passwordEncoder,
                          AccountRepository accountRepository,
                          JwtUtil jwtUtil
    ) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
        this.jwtUtil = jwtUtil;
    }

    public Account create(AccountDto accountDto) {
        String userIdString = accountDto.getUserId();

        UserId userId = new UserId(userIdString);

        Account account = new Account(userId, accountDto.getName(), accountDto.getAmount());

        String nameRegex = "^[가-힣]{3,7}$";
        if (!accountDto.getName().matches(nameRegex)) {
            throw new InvalidNameLength();
        }

        String userIdRegex = "^[a-z0-9]{4,16}$";
        if (!accountDto.getUserId().matches(userIdRegex)) {
            throw new WrongUserIdFormat();
        }

        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
        if (!accountDto.getPassword().matches(passwordRegex)) {
            throw new WrongPasswordFormat();
        }

        if (!accountDto.getPassword().equals(accountDto.getConfirmPassword())) {
            throw new PasswordDoNotMatch();
        }

        Optional<Account> existedAccount = accountRepository.findByUserId(userId);
        existedAccount.ifPresent(account1 -> {
            throw new UserIdAlreadyExist();
        });

        account.changePassword(accountDto.getPassword(), passwordEncoder);
        account.changePassword(accountDto.getConfirmPassword(), passwordEncoder);

        accountRepository.save(account);

        return account;
    }

    public Account detail(UserId userId) {
        return accountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(userId));
    }

    public OauthToken getAccessToken(String code) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", client_id);
        params.add("redirect_uri", FRONT_URL + "/redirect");
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthToken oauthToken = null;

        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthToken.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return oauthToken;
    }

    public KakaoProfile findProfile(String token) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest
                = new HttpEntity<>(headers);

        ResponseEntity<String> kakaoProfileResponse = restTemplate.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try {
            kakaoProfile = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfile.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return kakaoProfile;
    }

    public String saveAccountAndGetToken(String token) {
        KakaoProfile profile = findProfile(token);

        UserId userId = new UserId(profile.getKakao_account().getEmail());

        Account account = accountRepository.findByName(profile.getKakao_account().getProfile().getNickname());

        if (account == null) {
            account = new Account(profile.getId(), userId, fakePassword,
                    profile.getKakao_account().getProfile().getNickname(), 500000L);

            accountRepository.save(account);
        }

        return jwtUtil.encode(userId);
    }
}
