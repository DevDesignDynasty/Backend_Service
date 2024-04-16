package com.devdesign.backend.dto;

import com.devdesign.backend.entities.Question;

import java.util.List;

public class QuestionsWrapper {
    private List<Question> questions;

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
