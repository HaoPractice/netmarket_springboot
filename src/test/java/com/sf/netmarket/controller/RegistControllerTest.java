package com.sf.netmarket.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistControllerTest {
  
  @Autowired
  private MockMvc mockMvc;

  @Test
  public final void testStatus() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userinfo/18");
    mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.status().isOk());
  }
  @Test
  public final void testContent() throws Exception {
    RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/userinfo/18");
    mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.content().json("{  \"username\":\"daaaa\",\"securityId\":\"18\"}"));
  }

}
