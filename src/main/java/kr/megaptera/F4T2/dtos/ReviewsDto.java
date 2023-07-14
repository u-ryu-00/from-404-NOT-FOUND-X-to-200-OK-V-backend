package kr.megaptera.F4T2.dtos;

import java.util.List;

public class ReviewsDto {
    private final List<ReviewDto> reviews;
    private int totalPages;

    public ReviewsDto(List<ReviewDto> reviews) {
        this.reviews = reviews;
    }

    public ReviewsDto(List<ReviewDto> reviews, int totalPages) {
        this.reviews = reviews;
        this.totalPages = totalPages;
    }

    public List<ReviewDto> getReviews() {
        return reviews;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
