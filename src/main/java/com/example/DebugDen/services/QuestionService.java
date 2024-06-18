package com.example.DebugDen.services;

import com.example.DebugDen.entities.Question;
import com.example.DebugDen.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {
        return (List<Question>) questionRepository.findAll();
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public Question saveQuestion(Question question) {
    	question.setAskedOn(new Date());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }
    
    public boolean upvoteQuestion(Long id, String userId) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            if (!question.getUpVote().contains(userId)) {
                question.getUpVote().add(userId);
                questionRepository.save(question);
                return true;
            }
            else {
            	question.getUpVote().remove(userId);
            	questionRepository.save(question);
            	return true;
            }
        }
        return false;
    }

    public boolean downvoteQuestion(Long id, String userId) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            if (!question.getDownVote().contains(userId)) {
                question.getDownVote().add(userId);
                questionRepository.save(question);
                return true;
            }
            else {
            	question.getDownVote().remove(userId);
            	questionRepository.save(question);
            	return true;
            }
        }
        return false;
    }
    
}