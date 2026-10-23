package com.example.microservicesexam2026;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class MicroservicesExam2026ApplicationTests {

	@Test
	void contextLoads() {
	}

}
