package kr.megaptera.F4T2.dtos;

public class ReviewDto {
    private String userId;

    private Long reviewId;

    private Long productId;

    private String name;

    private String title;

    private Integer rating;

    private String content;

    private String reviewImage;

    public ReviewDto() {
    }

    public ReviewDto(String userId, Long reviewId, Long productId, String name, String title, Integer rating, String content, String reviewImage) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.productId = productId;
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.content = content;
        this.reviewImage = reviewImage;
    }

    public String getUserId() {
        return userId;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    public String getContent() {
        return content;
    }

    public String getReviewImage() {
        return reviewImage;
    }
}
