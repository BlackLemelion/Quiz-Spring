package com.este.quiz.app.responses;

import com.este.quiz.app.questions.Question;
import com.este.quiz.app.questions.QuestionRepository;
import com.este.quiz.app.questions.QuestionRequest;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResponseDaoImp {
    private final ResponseRepository responseRepository;

    public Optional<Response> findById(String id) {
        return this.responseRepository.findById(id);
    }

    public List<Response> findAll() {
        return this.responseRepository.findAll();
    }

    public void deleteOneById(String id) {
        this.responseRepository.deleteById(id);
    }

    public void createResponse(@NonNull ResponseRequest responseRequest) {
        Response response = Response.builder()
                .name(responseRequest.getName())
                .description(responseRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        this.responseRepository.save(response);
    }
}
