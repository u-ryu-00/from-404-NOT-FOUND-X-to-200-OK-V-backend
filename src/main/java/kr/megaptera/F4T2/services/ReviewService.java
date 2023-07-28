package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.UpdateReviewDto;
import kr.megaptera.F4T2.models.Review;
import kr.megaptera.F4T2.repositories.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private Pageable pageable;

    public ReviewService(ReviewRepository reviewRepository, Pageable pageable) {
        this.reviewRepository = reviewRepository;
        this.pageable = pageable;
    }

    public Page<Review> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 6);

        return reviewRepository.findAll(pageable);
    }

    public Review detail(Long id) {
        return reviewRepository.findById(id).get();
    }

    public int pages() {
        Page<Review> reviewPage = reviewRepository.findAll(pageable);

        return reviewPage.getTotalPages();
    }

    public void delete(Long id) {
        Review review = reviewRepository.getById(id);
        reviewRepository.delete(review);
    }

    public Long update(Long id, UpdateReviewDto updateReviewDto) {
        Review review = reviewRepository.getById(id);

        review.update(updateReviewDto.getTitle(), updateReviewDto.getRating(), updateReviewDto.getContent());

        return reviewRepository.save(review).getReviewId();
    }
}
