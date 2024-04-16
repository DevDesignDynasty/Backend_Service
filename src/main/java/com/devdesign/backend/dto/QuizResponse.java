package com.devdesign.backend.dto;

import com.devdesign.backend.entities.Question;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.boot.jackson.JsonComponent;

import java.util.List;

public class QuizResponse {
    private List<QuestionDto> questions;
    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }
}
