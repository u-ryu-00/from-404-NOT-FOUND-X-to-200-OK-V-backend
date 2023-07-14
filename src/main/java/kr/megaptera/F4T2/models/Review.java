package kr.megaptera.F4T2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.megaptera.F4T2.dtos.RegisterReviewResultDto;
import kr.megaptera.F4T2.dtos.ReviewDto;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long reviewId;

    private UserId userId;

    private Long productId;

    private String name;

    private String title;

    private Integer rating;

    private String content;

    public Review() {
    }

    public Review(UserId userId, Long reviewId, Long productId, String name, String title, Integer rating, String content) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.productId = productId;
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.content = content;
    }

    public static Review fake() {
        return new Review(new UserId("a111"), 1L, 1L, "소음이 적은 레이저 기계식 키보드", "만족!", 4, "알록달록해서 마음에 드네요.");
    }

    public UserId getUserId() {
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

    public RegisterReviewResultDto toRegisterReviewResultdto() {
        return new RegisterReviewResultDto(reviewId, productId);
    }

    public ReviewDto toDto() {
        return new ReviewDto(userId.value(), reviewId, productId, name, title, rating, content);
    }

    public void update(String title, Integer rating, String content) {
        this.title = title;
        this.rating = rating;
        this.content = content;
    }
}
