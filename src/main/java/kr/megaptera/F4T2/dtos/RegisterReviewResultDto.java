package kr.megaptera.F4T2.dtos;

public class RegisterReviewResultDto {
    private Long id;

    private Long productId;

    public RegisterReviewResultDto() {
    }

    public RegisterReviewResultDto(Long id, Long productId) {
        this.id = id;
        this.productId = productId;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }
}
