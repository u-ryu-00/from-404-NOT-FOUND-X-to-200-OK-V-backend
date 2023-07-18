package kr.megaptera.F4T2.models;

public class KakaoReadyResponse {
    private String tid; // 결제 고유 번호
    private String next_redirect_mobile_url; // 요청한 클라이언트가 모바일 웹
    private String next_redirect_pc_url; // 요청한 클라이언트가 PC 웹
    private String partner_order_id; // 가맹점 주문번호

    public KakaoReadyResponse() {
    }

    public KakaoReadyResponse(
            String tid,
            String next_redirect_mobile_url,
            String next_redirect_pc_url,
            String partner_order_id) {
        this.tid = tid;
        this.next_redirect_mobile_url = next_redirect_mobile_url;
        this.next_redirect_pc_url = next_redirect_pc_url;
        this.partner_order_id = partner_order_id;
    }

    public String getTid() {
        return tid;
    }

    public String getNext_redirect_mobile_url() {
        return next_redirect_mobile_url;
    }

    public String getNext_redirect_pc_url() {
        return next_redirect_pc_url;
    }

    public String getPartner_order_id() {
        return partner_order_id;
    }
}
