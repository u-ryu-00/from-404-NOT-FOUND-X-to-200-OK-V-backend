package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RegisterReviewServiceTest {
    private RegisterReviewService registerReviewService;

    private ReviewRepository reviewRepository;

    @BeforeEach
    void setUp() {
        reviewRepository = mock(ReviewRepository.class);

        registerReviewService = new RegisterReviewService(reviewRepository);
    }

    @Test
    void register() {
        UserId userId = new UserId("a111");
        Long productId = 1L;
        String name = "소음이 적은 레이저 기계식 키보드";
        String title = "만족!";
        int rating = 4;
        String content = "알록달록해서 마음에 드네요.";
        String reviewImage = "http://res.cloudinary.com/dk5ffebyd/image/upload/v1690262634/hft1nfyh8g6aqlj9tnwl.png";

        registerReviewService.register(userId, productId, name, title, rating, content, reviewImage);

        verify(reviewRepository).save(any());
    }

}
