package com.njwtframework.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = WebApplication.class)
@WebMvcTest
public class WebApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Autowired  
    private MockMvc mvc;  
  
    @Test  
    public void testIndex() throws Exception {  
  
        String expectedResult = "Hello";  
        String uri = "/";  
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))  
                .andReturn();  
        int status = mvcResult.getResponse().getStatus();  
        String content = mvcResult.getResponse().getContentAsString();  
        assertEquals(200, status);  
        assertEquals(expectedResult, content);  
    } 

}
