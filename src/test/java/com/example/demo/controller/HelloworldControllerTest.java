package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
// SpringBootTest 다는것을 알려줌..
@SpringBootTest
class HelloworldControllerTest {
    @Autowired //Spring Controller에서 bin을 주입하겠다는 의미
    private HelloworldController helloworldController;

    private MockMvc mockMvc;

    @Test
    void helloworld(){
 //       System.out.println("Test");
        System.out.println(helloworldController.helloWorrld());

        assertThat(helloworldController.helloWorrld()).isEqualTo("HelloWorld");
    }

    @Test
    void mockMvcTest() throws Exception{
            mockMvc = MockMvcBuilders.standaloneSetup(helloworldController).build();

        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/helloWorld")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect((ResultMatcher) MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
        // 예측한다 status가 OK인지..
        // 내용이 helloWorld인지 체크한다.
    }
}