package com.este.quiz.app.majors;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorDaoImp {
    private final MajorRepository majorRepository;

    public Optional<Major> findById(String id) {
        return this.majorRepository.findById(id);
    }

    public List<Major> findAll() {
        return this.majorRepository.findAll();
    }

    public void deleteOneById(String id) {
        this.majorRepository.deleteById(id);
    }

    public void createMajor(@NonNull MajorRequest majorRequest) {
        Major major = Major.builder()
                .name(majorRequest.getName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        this.majorRepository.save(major);
    }
}
