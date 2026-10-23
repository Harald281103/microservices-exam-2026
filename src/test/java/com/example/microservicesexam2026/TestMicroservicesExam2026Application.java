package com.example.microservicesexam2026;

import org.springframework.boot.SpringApplication;

public class TestMicroservicesExam2026Application {

	public static void main(String[] args) {
		SpringApplication.from(MicroservicesExam2026Application::main).with(TestcontainersConfiguration.class).run(args);
	}

}
