package com.devdesign.backend.entities;


import jakarta.persistence.*;

import java.util.List;


@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String question;
    @ElementCollection
    @CollectionTable(name = "question_choices", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "choice")
    private List<String> choices;
    private String type;
    private String correctAnswer;
    private String generalFeedback;
    @ElementCollection
    @CollectionTable(name = "question_specific_feedback", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "specific_feedback")
    private List<String> specificFeedback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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


