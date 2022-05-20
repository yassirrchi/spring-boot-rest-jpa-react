package com.ryassir.ryassir.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepo studentRepo){
        return args -> {
            Student yassir=new Student(
                    "Yassir",

                    "yassirrchi@gmail.com",
                    LocalDate.of(2000, Month.OCTOBER,29)
            );
            Student hasbulla=new Student(
                    "Habulla",

                    "hasbi@gmail.com",
                    LocalDate.of(2002, Month.OCTOBER,11)
            );
            Student bobby=new Student(
                    "bobby",

                    "bobby@gmail.com",
                    LocalDate.of(2002, Month.OCTOBER,11)
            );
            studentRepo.saveAll(List.of(yassir, hasbulla,bobby));

        };
    }
}
