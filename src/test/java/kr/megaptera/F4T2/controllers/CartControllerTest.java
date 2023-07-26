package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.AddService;
import kr.megaptera.F4T2.services.CartService;
import kr.megaptera.F4T2.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartController.class)
class CartControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartService cartService;

    @MockBean
    private AddService addService;

    @SpyBean
    private JwtUtil jwtUtil;

    @Test
    void list() throws Exception {
        String token = jwtUtil.encode(new UserId("a111"));

        UserId userId = new UserId("a111");

        given(cartService.list(userId))
                .willReturn(List.of(Cart.fake()));

        mockMvc.perform(MockMvcRequestBuilders.get("/cart")
                        .header("Authorization", "Bearer " + token))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("\"carts\":[")));
    }

    @Test
    void add() throws Exception {
        String token = jwtUtil.encode(new UserId("a111"));

        given(addService.add(new UserId("a111"), 1L, "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", 49000L, 49000L, 2, 1))
                .willReturn(Cart.fake());

        mockMvc.perform(MockMvcRequestBuilders.post("/cart")
                        .header("Authorization", "Bearer " + token)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"cartId\":\"1\"," +
                                "\"userId\":\"a111\"," +
                                "\"productId\":\"1\"," +
                                "\"image\":\"https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80\"," +
                                "\"name\":\"소음이 적은 레이저 기계식 키보드\"," +
                                "\"description\":\"저소음 적축 레이저 기계식 키보드입니다.\"," +
                                "\"price\":\"49000\"," +
                                "\"totalPrice\":\"49000\"," +
                                "\"inventory\":\"2\"," +
                                "\"quantity\":\"1\"" +
                                "}"))
                .andExpect(status().isCreated());
    }

}
