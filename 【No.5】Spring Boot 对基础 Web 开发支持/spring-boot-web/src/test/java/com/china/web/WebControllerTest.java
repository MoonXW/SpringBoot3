package com.china.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
public class WebControllerTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"));
        //处理中文乱码
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        //获取响应结果
        String responseString = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void getUsers() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/getUsers"));
        //获取响应对象
        MockHttpServletResponse response = resultActions.andReturn().getResponse();
        //处理中文乱码
        response.setCharacterEncoding("UTF-8");
        //获取响应结果
        String responseString = response.getContentAsString();
        System.out.println("result : "+responseString);
    }

    @Test
    public void saveUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name","")
                .param("age","666")
                .param("pass","test")
        );
    }

    @Test
    public void saveRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/saveRole")
                .param("openTime","2023-04-01")
                .param("closeTime","2023-03-29")
        );
    }


}
