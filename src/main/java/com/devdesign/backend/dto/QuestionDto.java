package com.devdesign.backend.dto;


import java.util.List;

public class QuestionDto {

    private String question;

    private List<String> choices;
    private String type;
    private String correctAnswer;
    private String generalFeedback;

    private List<String> specificFeedback;


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getGeneralFeedback() {
        return generalFeedback;
    }

    public void setGeneralFeedback(String generalFeedback) {
        this.generalFeedback = generalFeedback;
    }

    public List<String> getSpecificFeedback() {
        return specificFeedback;
    }

    public void setSpecificFeedback(List<String> specificFeedback) {
        this.specificFeedback = specificFeedback;
    }
}
