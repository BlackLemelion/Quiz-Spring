package com.este.quiz.app.questions;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionDaoImp {
    private final QuestionRepository questionRepository;

    public Optional<Question> findById(String id) {
        return this.questionRepository.findById(id);
    }

    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }

    public void deleteOneById(String id) {
        this.questionRepository.deleteById(id);
    }

    public void createQuestion(@NonNull QuestionRequest questionRequest) {
        Question question = Question.builder()
                .name(questionRequest.getName())
                .description(questionRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        this.questionRepository.save(question);
    }

}
