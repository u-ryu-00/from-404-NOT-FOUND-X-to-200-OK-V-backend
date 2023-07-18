package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.KakaoApproveResponseDto;
import kr.megaptera.F4T2.dtos.KakaoReadyResponseDto;
import kr.megaptera.F4T2.models.KakaoReadyResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class KakaoPayService {
    @Value("${ADMIN_KEY}")
    private String admin_Key;

    static final String cid = "TC0ONETIME"; // 가맹점 테스트 코드
    private KakaoReadyResponse kakaoReadyResponse;

    public KakaoPayService() {
    }

    public KakaoReadyResponseDto kakaoPayReady() {
        // 카카오 페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("partner_order_id", "가맹점 주문번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("item_name", "상품명");
        parameters.add("quantity", String.valueOf(3));
        parameters.add("total_amount", String.valueOf(3));
        parameters.add("tax_free_amount", String.valueOf(3));
        parameters.add("approval_url", "http://localhost:8080/orders"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:8080/order/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:8080/order/fail"); // 실패 시 redirect url

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        kakaoReadyResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/ready",
                requestEntity,
                KakaoReadyResponse.class);

        return new KakaoReadyResponseDto(
                kakaoReadyResponse.getTid(),
                kakaoReadyResponse.getNext_redirect_mobile_url(),
                kakaoReadyResponse.getNext_redirect_pc_url(),
                kakaoReadyResponse.getPartner_order_id());
    }

    public KakaoApproveResponseDto approveResponse(String pgToken) {
        // 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReadyResponse.getTid());
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        KakaoApproveResponseDto approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoApproveResponseDto.class);

        return approveResponse;
    }

    // 카카오 요구 헤더값
    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        System.out.println("어드민 키" + admin_Key);

        httpHeaders.add("Authorization", auth);
        httpHeaders.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }
}
