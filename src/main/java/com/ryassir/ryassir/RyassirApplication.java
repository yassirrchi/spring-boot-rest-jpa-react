package com.ryassir.ryassir;

import com.ryassir.ryassir.student.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@SpringBootApplication

public class RyassirApplication {

	public static void main(String[] args) {
		SpringApplication.run(RyassirApplication.class, args);
	}


}
