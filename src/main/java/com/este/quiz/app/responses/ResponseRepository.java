package com.este.quiz.app.responses;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository extends MongoRepository<Response, String> {
}
