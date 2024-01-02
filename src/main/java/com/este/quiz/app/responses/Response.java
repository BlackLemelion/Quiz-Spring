package com.este.quiz.app.responses;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "responses")
public class Response {
    @Id
    private String id;
}
