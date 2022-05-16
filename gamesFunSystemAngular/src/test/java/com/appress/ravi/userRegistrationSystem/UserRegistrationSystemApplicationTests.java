package com.appress.ravi.userRegistrationSystem;

import com.appress.ravi.userRegistrationSystem.client.SimpleCalculator;
import com.appress.ravi.userRegistrationSystem.repository.UserJpaRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserRegistrationSystemApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserJpaRepository userJpaRepository;

	@Test
	void count(){
		Assert.assertEquals(4,userJpaRepository.count());
	}









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
