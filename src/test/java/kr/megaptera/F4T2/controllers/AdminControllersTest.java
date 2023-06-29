package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.services.RegisterProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
class AdminControllersTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegisterProductService registerProductService;

    @Test
    void registerProduct() throws Exception {
        given(registerProductService.register(1L, "저소음 적축 레이저 기계식 키보드", "소음이 적은 레이저 기계식 키보드", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", 49000L, 2))
                .willReturn(Product.fake());

        mockMvc.perform(MockMvcRequestBuilders.post("/admin/products")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{" +
                                "\"productId\":\"1\"," +
                                "\"name\":\"저소음 적축 레이저 기계식 키보드\"," +
                                "\"description\":\"소음이 적은 레이저 기계식 키보드\"," +
                                "\"image\":\"https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80\"," +
                                "\"price\":\"49000\"," +
                                "\"option\":[\"흰색\", \"빨간색\"]," +
                                "\"inventory\":\"2\"" +
                                "}")

                )
                .andExpect(status().isCreated());
    }
}
