package com.startwithjava.crosscutting.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = IntegrationTest.TestController.class, secure = false)
public class IntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInfo_GivenTestController_LogInfoMessage() throws Exception{
        mockMvc.perform(get("/hello/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    @Controller
    static class TestController{
        CentralLogger centralLogger = CentralLoggerFactory.getLogger();
        @GetMapping("/hello")
        public String hello(){
            centralLogger.info("hello");
            return "hello";
        }
    }
}
