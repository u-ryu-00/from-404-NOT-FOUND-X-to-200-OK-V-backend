package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.exceptions.LoginFailed;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.LoginService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SessionController.class)
class SessionControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        UserId userId = new UserId("a111");

        given(loginService.login(userId, "Aa1!!!!!"))
                .willReturn(Account.fake(userId));

        given(loginService.login(userId, "xxx"))
                .willThrow(new LoginFailed());
    }

    @Test
    void loginSuccess() throws Exception {
        mockMvc.perform(
                        MockMvcRequestBuilders.post("/session")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{" +
                                        "\"userId\":\"a111\"," +
                                        "\"password\":\"Aa1!!!!!\"" +
                                        "}")
                )
                .andExpect(status().isCreated())
                .andExpect(content().string(
                        containsString("\"amount\":")
                ));
    }


}
