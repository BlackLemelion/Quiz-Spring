package com.este.quiz.app.majors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/majors")
public class MajorController {

    private final MajorDaoImp majorDaoImp;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Major>> getAll() {
        return ResponseEntity.ok(majorDaoImp.findAll());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody MajorRequest majorRequest) {
        majorDaoImp.createMajor(majorRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Major>> getOne(@PathVariable String id) {
        var major = majorDaoImp.findById(id);
        if (major.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(major);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteOne(@PathVariable String id) {
        var major = majorDaoImp.findById(id);
        if (major.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        majorDaoImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

}

















