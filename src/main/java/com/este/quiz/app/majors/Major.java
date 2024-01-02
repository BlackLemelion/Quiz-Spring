package com.este.quiz.app.majors;

import com.este.quiz.app.exams.Exam;
import com.este.quiz.app.users.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "majors")
public class Major {
    @Id
    private String id;
    private String name;
    private List<User> users;
    private List<Exam> exams;
}
