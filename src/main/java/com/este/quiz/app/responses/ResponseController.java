package com.este.quiz.app.responses;

import com.este.quiz.app.questions.QuestionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/responses")
public class ResponseController {

    private final ResponseDaoImp responseDaoImp;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Response>> getAll() {
        return ResponseEntity.ok(responseDaoImp.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ResponseRequest responseRequest) {
        responseDaoImp.createResponse(responseRequest);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Response>> getOne(@PathVariable String id) {
        var response = responseDaoImp.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteOne(@PathVariable String id) {
        var response = responseDaoImp.findById(id);
        if (response.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        responseDaoImp.deleteOneById(id);
        return ResponseEntity.ok().build();
    }

}
