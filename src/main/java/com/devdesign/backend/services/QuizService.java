package com.devdesign.backend.services;


import com.devdesign.backend.dto.QuestionDto;
import com.devdesign.backend.dto.QuestionsWrapper;
import com.devdesign.backend.dto.QuizResponse;
import com.devdesign.backend.entities.Question;
import com.devdesign.backend.repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepo quizRepo;

    public String addNewQuestions(List<Question> questions){
        try {
            quizRepo.saveAll(questions);
            return "Questions added successfully";
        }catch (Exception e){
            return "Failed to add questions";
        }
    }
    public String addNewQuestion(Question question){
        try {
            quizRepo.save(question);
            return "Question added successfully";
        }catch (Exception e){
            return "Failed to add question";
        }
    }
    public QuizResponse getQuestions(){
        QuizResponse quizResponse = new QuizResponse();
        List<Question> questions = quizRepo.findAll();
        List<QuestionDto> questionDtos = questions.stream()
                .map(this::convertToDto) // Convert each Question to QuestionDto
                .collect(Collectors.toList());
        quizResponse.setQuestions(questionDtos);
        return quizResponse;

    }

    private QuestionDto convertToDto(Question question) {
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion(question.getQuestion());
        questionDto.setChoices(question.getChoices());
        questionDto.setType(question.getType());
        questionDto.setCorrectAnswer(question.getCorrectAnswer());
        questionDto.setGeneralFeedback(question.getGeneralFeedback());
        questionDto.setSpecificFeedback(question.getSpecificFeedback());
        return questionDto;
    }


}
