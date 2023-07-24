package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.KakaoApproveResponseDto;
import kr.megaptera.F4T2.dtos.KakaoReadyResponseDto;
import kr.megaptera.F4T2.dtos.PayDto;
import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.KakaoPayService;
import kr.megaptera.F4T2.services.PayService;
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
    private final PayService payService;

    public KakaoPayController(KakaoPayService kakaoPayService, PayService payService) {
        this.kakaoPayService = kakaoPayService;
        this.payService = payService;
    }

    // 결제 요청
    @PostMapping("ready")
    public KakaoReadyResponseDto readyToKakaoPay(
            @RequestAttribute("userId") UserId userId,
            @Valid @RequestBody PayDto payDto
    ) {
        Order order = payService.pay(
                userId, payDto.getProductId(),
                payDto.getName(),
                payDto.getDescription(),
                payDto.getImage(),
                payDto.getPrice(),
                payDto.getInventory(),
                payDto.getQuantity(),
                payDto.getReceiver(),
                payDto.getAddress(),
                payDto.getZonecode(),
                payDto.getPhoneNumber(),
                payDto.getDeliveryMessage(),
                payDto.getCreatedAt(),
                payDto.getTotalPrice()
        );
        return kakaoPayService.kakaoPayReady(userId, payDto);
    }

    // 결제 성공
    @GetMapping("success")
    public ResponseEntity afterPayRequest(@RequestParam("pgToken") String pgToken) {
        KakaoApproveResponseDto kakaoApprove = kakaoPayService.approveResponse(pgToken);

        return new ResponseEntity<>(kakaoApprove, HttpStatus.OK);
    }
}
