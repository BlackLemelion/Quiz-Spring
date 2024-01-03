package com.este.quiz.app.majors;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Annotation;


public interface MajorRepository  extends MongoRepository<Major, String>{

}
