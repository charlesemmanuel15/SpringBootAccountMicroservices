package com.codewithemma;

import com.codewithemma.controllers.AccountControllerTest;
import com.codewithemma.services.AccountServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;
@RunWith(Suite.class)
@Suite.SuiteClasses({
		AccountControllerTest.class,
		AccountServiceTest.class
})
@SpringBootTest
public class SpringBootAccountMicroservicesApplicationTests {

	@Test
	void contextLoads() {
	}

}
