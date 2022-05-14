package com.appress.ravi.userRegistrationSystem.repository;

import com.appress.ravi.userRegistrationSystem.UserRegistrationSystemApplication;
import com.appress.ravi.userRegistrationSystem.client.SimpleCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = UserRegistrationSystemApplication.class)
public class SimpleCalculatorTests {
    private SimpleCalculator simpleCalculator;

    @Before
    public void setup() {
        simpleCalculator = new SimpleCalculator();
    }

    @Test
    public void verifyAdd() {
        long sum = simpleCalculator.addOperation(2, 1);
        Assertions.assertEquals(3, sum);
    }

    @After
    public void teardown() {
        simpleCalculator = null;
    }
}
