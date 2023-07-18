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

    private String reviewImage;

    public Review() {
    }

    public Review(UserId userId, Long reviewId, Long productId, String name, String title, Integer rating, String content, String reviewImage) {
        this.userId = userId;
        this.reviewId = reviewId;
        this.productId = productId;
        this.name = name;
        this.title = title;
        this.rating = rating;
        this.content = content;
        this.reviewImage = reviewImage;
    }

    public static Review fake() {
        return new Review(new UserId("a111"), 1L, 1L, "소음이 적은 레이저 기계식 키보드", "만족!", 4, "알록달록해서 마음에 드네요.", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80");
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

    public String getReviewImage() {
        return reviewImage;
    }

    public RegisterReviewResultDto toRegisterReviewResultdto() {
        return new RegisterReviewResultDto(reviewId, productId);
    }

    public ReviewDto toDto() {
        return new ReviewDto(userId.value(), reviewId, productId, name, title, rating, content, reviewImage);
    }

    public void update(String title, Integer rating, String content) {
        this.title = title;
        this.rating = rating;
        this.content = content;
    }
}
