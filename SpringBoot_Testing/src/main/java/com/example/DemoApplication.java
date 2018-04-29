package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.ToDo;
import com.example.repository.ToDoRepository;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);
	
	@Bean
	public CommandLineRunner setup(ToDoRepository todoRepository){
		return (args) -> {
			todoRepository.save(new ToDo("Remove unused imports", true));
			todoRepository.save(new ToDo("Clean the code", true));
			todoRepository.save(new ToDo("Build the artifacts", true));
			todoRepository.save(new ToDo("Deploy the jar file", true));
			LOGGER.info("The sample data has been generated");
		};
	}	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}