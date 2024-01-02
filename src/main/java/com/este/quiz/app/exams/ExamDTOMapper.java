package com.este.quiz.app.exams;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ExamDTOMapper implements Function<Exam, ExamDTO> {
    @Override
    public ExamDTO apply(Exam exam) {
        return new ExamDTO(
                exam.getId(),
                exam.getName(),
                exam.getDescription()
        );
    }
}
