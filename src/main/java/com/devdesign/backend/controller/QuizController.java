package com.devdesign.backend.controller;


import com.devdesign.backend.dto.QuestionsWrapper;
import com.devdesign.backend.dto.QuizResponse;
import com.devdesign.backend.entities.Question;
import com.devdesign.backend.services.QuizService;
import com.devdesign.backend.services.UserService;
import com.devdesign.backend.services.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="/")
public class QuizController {
    @Autowired
    private QuizService quizService;
    @Autowired
    private ValidationService validation;
    @Autowired
    private UserService userService;

    @PostMapping(path="/addall")
    public ResponseEntity<String> addNewQuestions(@RequestBody QuestionsWrapper questionsWrapper){
        List<Question> questions = questionsWrapper.getQuestions();
        return ResponseEntity.ok(quizService.addNewQuestions(questions));
    }
    @PostMapping(path="/add")
    public ResponseEntity<String> addNewQuestion(@RequestBody Question question){
        return ResponseEntity.ok(quizService.addNewQuestion(question));
    }

    @GetMapping(path="/validate/{token}")
    public ResponseEntity<String> getQuestion(@PathVariable("token") String token){
        if (validation.validate(token)){
            String status = userService.quizStatus(token);
            return ResponseEntity.ok(status);

        }else {
            return ResponseEntity.ok("Invalid Token");
        }

    }
    @GetMapping(path="/get/{token}")
    public ResponseEntity<QuizResponse> getQuestions(@PathVariable("token") String token){
        if (validation.validate(token)){
            if(userService.addUser(token)) {
                return ResponseEntity.ok(quizService.getQuestions());
            }else {
                return ResponseEntity.ok(null);
            }
        }else {
            return ResponseEntity.ok(null);
        }
    }

    @PutMapping(path="/submit/{token}")
    public ResponseEntity<String> submitQuiz(@PathVariable("token") String token){
        if (validation.validate(token)){
            if(userService.submitQuiz(token)) {
                return ResponseEntity.ok("Quiz Submitted");
            }else {
                return ResponseEntity.ok("Failed to submit quiz");
            }
        }else {
            return ResponseEntity.ok("Invalid Token");
        }
    }

}
