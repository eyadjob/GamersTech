package com.appress.ravi.userRegistrationSystem.repository;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.appress.ravi.userRegistrationSystem.UserRegistrationSystemApplication;
import com.appress.ravi.userRegistrationSystem.client.SimpleCalculator;
import com.appress.ravi.userRegistrationSystem.dto.UserDTO;
import com.appress.ravi.userRegistrationSystem.rest.UserRegistrationRestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

@SpringBootTest
@WebMvcTest(controllers = UserRegistrationRestController.class)
@ContextConfiguration(classes = UserRegistrationSystemApplication.class)
public class SimpleRestTest {

    @Autowired
    private MockMvc mockMvc;

    private SimpleCalculator simpleCalculator;

    @MockBean
    private UserJpaRepository userJpaRepositoryMock;

    private MediaType contentType;
    private UserDTO user;

    @Before
    public void setup() {
        contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
                MediaType.APPLICATION_JSON.getSubtype(),
                Charset.forName("utf8"));

        user = new UserDTO();
        user.setName("Ravi Kant Soni");
        user.setAddress("JP Nagar; Bangalore; India");
        user.setEmail("ravikantsoni.author@gmail.com");
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void shouldReturnSuccessMessage() throws Exception {

        Mockito.when(this.userJpaRepositoryMock.findById(1L)).thenReturn(java.util.Optional.ofNullable(user));

        this.mockMvc.perform(get("/api/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("'.name", is("Ravi Kant Soni")))
                .andExpect(jsonPath("'.address",
                        is("JP Nagar; Bangalore; India")))
                .andExpect(jsonPath("'.email",
                        is("ravikantsoni.author@gmail.com")))
                .andDo(print());
    }

    @Test
    public void verifyAdd() {
        long sum = simpleCalculator.addOperation(2, 1);
        Assertions.assertEquals(3, sum);
    }
}
