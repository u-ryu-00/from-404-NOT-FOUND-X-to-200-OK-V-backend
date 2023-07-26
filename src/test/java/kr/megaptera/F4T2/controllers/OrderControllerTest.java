package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.OrderService;
import kr.megaptera.F4T2.services.PayService;
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

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderController.class)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PayService payService;

    @MockBean
    private OrderService orderService;

    @SpyBean
    private JwtUtil jwtUtil;

    @Test
    void list() throws Exception {
        String token = jwtUtil.encode(new UserId("a111"));

        UserId userId = new UserId("a111");

        given(orderService.list(userId, 1))
                .willReturn(Page.empty());

        mockMvc.perform(MockMvcRequestBuilders.get("/orders")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"orders\":[")));
    }

    @Test
    void pay() throws Exception {
        String token = jwtUtil.encode(new UserId("a111"));

        LocalDateTime createdAt = LocalDateTime.now();

        given(payService.pay(new UserId("a111"), 1L, "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", 49000L, 2, 1, "받는 사람", "주소", "12345", "010-1234-5678", "배송메시지", createdAt, 49000L))
                .willReturn(Order.fake());

        String createdAtString = createdAt.toString();

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                        .header("Authorization", "Bearer " + token)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"orderId\":\"1\"," +
                                "\"userId\":\"a111\"," +
                                "\"productId\":\"1\"," +
                                "\"name\":\"소음이 적은 레이저 기계식 키보드\"," +
                                "\"description\":\"저소음 적축 레이저 기계식 키보드입니다.\"," +
                                "\"image\":\"https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80\"," +
                                "\"price\":\"49000\"," +
                                "\"inventory\":\"2\"," +
                                "\"quantity\":\"1\"," +
                                "\"totalPrice\":\"49000\"," +
                                "\"receiver\":\"받는 사람\"," +
                                "\"address\":\"주소\"," +
                                "\"zonecode\":\"12345\"," +
                                "\"phoneNumber\":\"010-1234-5678\"," +
                                "\"deliveryMessage\":\"배송메시지\"," +
                                "\"createdAt\":\"" + createdAtString + "\"" +
                                "}"))
                .andExpect(status().isCreated());
    }

    @Test
    void product() throws Exception {
        given(orderService.detail(any())).willReturn(Order.fake());

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                "\"orderId\":1,\"productId\":1,"
                        )));
    }
}
