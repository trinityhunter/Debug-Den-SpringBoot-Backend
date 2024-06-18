package com.example.DebugDen.services;

import com.example.DebugDen.entities.Answer;
import com.example.DebugDen.entities.Question;
import com.example.DebugDen.repository.AnswerRepository;
import com.example.DebugDen.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;
    
    @Autowired
    private QuestionRepository questionRepository;

    public Answer postAnswer(Long questionId, Answer answer) {
        if (questionId != null && answer != null) {
            Question question = questionRepository.findById(questionId).orElse(null);
            if (question != null) {
                answer.setQuestionId(questionId);
                answer.setAnsweredOn(new Date());
                question.setNoOfAnswers(question.getNoOfAnswers() + 1);
                return answerRepository.save(answer);
            }
        }
        return null;
    }

    public Answer getAnswerById(Long id) {
        return answerRepository.findById(id).orElse(null);
    }

    public List<Answer> getAnswersByQuestionId(Long questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
    
    public boolean deleteAnswer(Long id) {
        Optional<Answer> optionalAnswer = answerRepository.findById(id);
        if (optionalAnswer.isPresent()) {
            answerRepository.deleteById(id);
            return true;
        }
        return false;
    }

}