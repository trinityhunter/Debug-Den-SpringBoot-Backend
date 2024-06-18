package com.example.DebugDen.controller;

import com.example.DebugDen.entities.Question;
import com.example.DebugDen.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.getAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(question);
    }

    @PostMapping("/")
    public ResponseEntity<Question> createQuestion(@jakarta.validation.Valid @RequestBody Question question) {
        Question savedQuestion = questionService.saveQuestion(question);
        return ResponseEntity.ok(savedQuestion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("/{id}/upvote")
    public ResponseEntity<String> upvoteQuestion(@PathVariable Long id, @RequestBody String userId) {
        boolean success = questionService.upvoteQuestion(id, userId);
        if (success) {
            return ResponseEntity.ok("Question upvoted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upvote question.");
        }
    }

    @PostMapping("/{id}/downvote")
    public ResponseEntity<String> downvoteQuestion(@PathVariable Long id, @RequestBody String userId) {
        boolean success = questionService.downvoteQuestion(id, userId);
        if (success) {
            return ResponseEntity.ok("Question downvoted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to downvote question.");
        }
    }
    
}
