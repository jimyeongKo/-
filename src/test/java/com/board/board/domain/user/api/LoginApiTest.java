package com.board.board.domain.user.api;

import com.board.board.domain.user.dto.LoginRequest;
import com.board.board.domain.user.dto.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.http11.upgrade.UpgradeServletOutputStream;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginApiTest {

    @Rule
    public final JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void testLogin() throws Exception {

        LoginRequest request = new LoginRequest("유저", "1234");

        String content = objectMapper.writeValueAsString(request);

        this.mockMvc.perform(post("/login")
        .content(content)
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(document("auth_login",
                        requestFields(
                                fieldWithPath("userId").description("아이디"),
                                fieldWithPath("password").description("비밀 번호")
                        ),
                        responseFields(
                                fieldWithPath("status").description("응답 코드"),
                                fieldWithPath("data.token").description("유저 토큰"),
                                fieldWithPath("data.user.id").description("유저  PK"),
                                fieldWithPath("data.user.userId").description("유저 아이디"),
                                fieldWithPath("data.user.password").description("비밀번호"),
                                fieldWithPath("data.user.userName").description("유저 이름"),
                                fieldWithPath("data.user.teamName").description("팀 이름"),
                                fieldWithPath("data.user.userInfo").description("유저 소개"),
                                fieldWithPath("data.user.age").description("유저 나이"),
                                fieldWithPath("data.user.phoneNum").description("휴대 전화")
                        )));
    }
}