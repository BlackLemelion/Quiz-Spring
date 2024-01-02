package com.este.quiz.app.exams;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExamConfig {

    @Bean
    CommandLineRunner runner(ExamRepository examRepository) {
        return args -> {
/*
            Exam exam = Exam.builder()
                    .name("exam 1")
                    .description("exam 1 description")
                    .build();
            examRepository.save(exam);
*/

        };

    }


}
