package com.este.quiz.app.questions;

import com.este.quiz.app.exams.Exam;
import com.este.quiz.app.exams.ExamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {

    private final QuestionDaoImp questionDaoImp;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Question>> getAll() {
        return ResponseEntity.ok(questionDaoImp.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody QuestionRequest questionRequest) {
        questionDaoImp.createQuestion(questionRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Question>> getOne(@PathVariable String id) {
        var question = questionDaoImp.findById(id);
        if (question.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteOne(@PathVariable String id) {
        var question = questionDaoImp.findById(id);
        if (question.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        questionDaoImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

}
