package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.RegisterReviewDto;
import kr.megaptera.F4T2.dtos.RegisterReviewResultDto;
import kr.megaptera.F4T2.dtos.ReviewDto;
import kr.megaptera.F4T2.dtos.ReviewsDto;
import kr.megaptera.F4T2.dtos.UpdateReviewDto;
import kr.megaptera.F4T2.models.Review;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.RegisterReviewService;
import kr.megaptera.F4T2.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("reviews")
public class ReviewController {
    private RegisterReviewService registerReviewService;
    private ReviewService reviewService;

    public ReviewController(RegisterReviewService registerReviewService, ReviewService reviewService) {
        this.registerReviewService = registerReviewService;
        this.reviewService = reviewService;
    }

    @GetMapping
    public ReviewsDto list(
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<ReviewDto> reviewDtos =
                reviewService.list(page)
                        .stream()
                        .map(review -> review.toDto())
                        .collect(Collectors.toList());

        int totalPages = reviewService.pages();

        return new ReviewsDto(reviewDtos, totalPages);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterReviewResultDto registerReviewResultDto(
            @RequestAttribute("userId") UserId userId,
            @Valid @RequestBody RegisterReviewDto registerReviewDto
    ) {
        Review review = registerReviewService.register(
                userId,
                registerReviewDto.getProductId(),
                registerReviewDto.getName(),
                registerReviewDto.getTitle(),
                registerReviewDto.getRating(),
                registerReviewDto.getContent()
        );
        return review.toRegisterReviewResultdto();
    }

    @PatchMapping("/{id}")
    public Long update(
            @PathVariable Long id, @RequestBody UpdateReviewDto updateReviewDto
    ) {
        return reviewService.update(id, updateReviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @GetMapping("/{id}")
    public ReviewDto review(
            @PathVariable("id") Long id
    ) {
        Review review = reviewService.detail(id);

        return review.toDto();
    }
}
