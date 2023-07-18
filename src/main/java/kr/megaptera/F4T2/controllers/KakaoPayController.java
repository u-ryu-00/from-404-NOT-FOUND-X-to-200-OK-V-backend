package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.KakaoApproveResponseDto;
import kr.megaptera.F4T2.dtos.KakaoReadyResponseDto;
import kr.megaptera.F4T2.dtos.PayDto;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.KakaoPayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orders")
public class KakaoPayController {
    private final KakaoPayService kakaoPayService;

    public KakaoPayController(KakaoPayService kakaoPayService) {
        this.kakaoPayService = kakaoPayService;
    }

    // 결제 요청
    @PostMapping("ready")
    public KakaoReadyResponseDto readyToKakaoPay(
            @RequestAttribute("userId") UserId userId,
            @Valid @RequestBody PayDto payDto
    ) {
        return kakaoPayService.kakaoPayReady();
    }

    // 결제 성공
    @GetMapping("/success")
    public ResponseEntity afterPayRequest(@RequestParam("pg_token") String pgToken) {
        KakaoApproveResponseDto kakaoApprove = kakaoPayService.approveResponse(pgToken);

        System.out.println("!!!!!!!!!!!!!");
        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
    }


    // 결제 진행 중 취소
//    @GetMapping("/cancel")
//    public void cancel() {
//        throw new BusinessLogicException(ExceptionCode.PAY_CANCEL);
//    }

    // 결제 실패
//    @GetMapping("/fail")
//    public void fail() {
//        throw new BusinessLogicException(ExceptionCode.PAY_FAILED);
//    }
}
