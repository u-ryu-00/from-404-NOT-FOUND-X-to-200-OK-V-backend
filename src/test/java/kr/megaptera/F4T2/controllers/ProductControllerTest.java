package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.dtos.UpdateProductDto;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
@ActiveProfiles("test")
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void list() throws Exception {
        given(productService.list(1))
                .willReturn(new PageImpl<>(List.of(Product.fake())));

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                "\"products\":[{\"id\":1,\"name\":\"소음이 적은 레이저 기계식 키보드"
                        )));
    }

    @Test
    void page() throws Exception {
        List<Product> productList = List.of(Product.fake());

        Page<Product> page = new PageImpl<>(productList);

        given(productService.list(2))
                .willReturn(page);

        mockMvc.perform(MockMvcRequestBuilders.get("/products")
                        .param("page", "2"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                "\"products\":[{\"id\":1,\"name\":\"소음이 적은 레이저 기계식 키보드"
                        )));
    }

    @Test
    void product() throws Exception {
        given(productService.detail(any())).willReturn(Product.fake());

        mockMvc.perform(MockMvcRequestBuilders.get("/products/1"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString(
                                "\"id\":1,\"name\":\"소음이 적은 레이저 기계식 키보드\""
                        )));
    }
}
