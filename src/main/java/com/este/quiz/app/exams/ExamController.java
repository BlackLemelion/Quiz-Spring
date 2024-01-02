package com.este.quiz.app.exams;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/exams")
public class ExamController {

   private final ExamService examService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Exam>> getAll() {
        return ResponseEntity.ok(examService.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ExamRequest examRequest) {
        examService.createExam(examRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Exam>> getOne(@PathVariable String id) {
        var exam = examService.findById(id);
        if (exam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(exam);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteOne(@PathVariable String id) {
        var exam = examService.findById(id);
        if (exam.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        examService.deleteOneById(id);
        return ResponseEntity.ok().build();
    }
}
