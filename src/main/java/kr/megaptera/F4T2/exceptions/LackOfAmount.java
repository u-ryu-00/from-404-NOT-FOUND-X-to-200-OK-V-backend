package kr.megaptera.F4T2.exceptions;

public class LackOfAmount extends RuntimeException {
    public LackOfAmount() {
        super("❌잔액이 부족하여 상품 구매가 불가합니다❌");
    }
}
