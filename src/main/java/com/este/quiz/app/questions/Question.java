package com.este.quiz.app.questions;

import com.este.quiz.app.responses.Response;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String name;
    private String description;
    private List<Response> responses;

    public Question(String name, String description, List<Response> responses) {
        this.name = name;
        this.description = description;
        this.responses = responses;
    }

    public Question() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Response> getResponses() {
        return responses;
    }

    public void setResponses(List<Response> responses) {
        this.responses = responses;
    }
}
