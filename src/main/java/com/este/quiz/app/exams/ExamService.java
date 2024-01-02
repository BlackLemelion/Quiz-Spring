package com.este.quiz.app.exams;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;
    // private final ExamDTOMapper examDTOMapper;

    public Optional<Exam> findById(String id) {
        //return this.examRepository.findById(id).map(examDTOMapper);
        return this.examRepository.findById(id);
    }

    public List<Exam> findAll() {
        //return this.examRepository.findAll().stream().map(examDTOMapper).collect(Collectors.toList());
        return this.examRepository.findAll();
    }

    public void deleteOneById(String id) {
        this.examRepository.deleteById(id);
    }

    public void createExam(@NonNull ExamRequest examRequest) {
        Exam exam = Exam.builder()
                .name(examRequest.getName())
                .description(examRequest.getDescription())
                .build();
        this.examRepository.save(exam);
    }
}
