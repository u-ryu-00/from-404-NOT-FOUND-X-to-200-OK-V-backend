package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.models.Review;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.RegisterReviewService;
import kr.megaptera.F4T2.services.ReviewService;
import kr.megaptera.F4T2.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
class ReviewControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService reviewService;

    @MockBean
    private RegisterReviewService registerReviewService;

    @SpyBean
    private JwtUtil jwtUtil;

    @Test
    void list() throws Exception {
        given(reviewService.list(1))
                .willReturn(Page.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/reviews"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"reviews\":[")));
    }

    @Test
    void register() throws Exception {
        String token = jwtUtil.encode(new UserId("a111"));

        given(registerReviewService.register(new UserId("a111"), 1L, "소음이 적은 레이저 기계식 키보드", "만족!", 4, "알록달록해서 마음에 드네요."))
                .willReturn(Review.fake());

        mockMvc.perform(MockMvcRequestBuilders.post("/reviews")
                        .header("Authorization", "Bearer " + token)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"productId\":\"1\"," +
                                "\"name\":\"소음이 적은 레이저 기계식 키보드\"," +
                                "\"title\":\"만족!\"," +
                                "\"rating\":4," +
                                "\"content\":\"알록달록해서 마음에 드네요.\"" +
                                "}"))
                .andExpect(status().isCreated());
    }

    @Test
    void review() throws Exception {
        given(reviewService.detail(any())).willReturn(Review.fake());

        mockMvc.perform(MockMvcRequestBuilders.get("/reviews/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                "\"userId\":\"a111\",\"reviewId\":1,"
                        )));
    }
}
