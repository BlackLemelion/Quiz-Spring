package com.este.quiz.app.exams;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;


public interface ExamRepository  extends MongoRepository<Exam, String> {

}
