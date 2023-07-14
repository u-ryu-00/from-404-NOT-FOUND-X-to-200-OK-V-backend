package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.models.Review;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterReviewService {
    private ReviewRepository reviewRepository;

    public RegisterReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review register(UserId userId, Long productId, String name, String title, Integer rating, String content) {
        Review review = new Review(userId, null, productId, name, title, rating, content);

        reviewRepository.save(review);

        return review;
    }
}
