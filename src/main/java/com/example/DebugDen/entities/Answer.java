package com.example.DebugDen.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.util.Date;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answerBody;
    private String userAnswered;
    private Date answeredOn;

    @Column(name = "question_id")
    private Long questionId; // Store the question ID as a basic attribute

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerBody() {
        return answerBody;
    }

    public void setAnswerBody(String answerBody) {
        this.answerBody = answerBody;
    }

    public String getUserAnswered() {
        return userAnswered;
    }

    public void setUserAnswered(String userAnswered) {
        this.userAnswered = userAnswered;
    }

    public Date getAnsweredOn() {
        return answeredOn;
    }

    public void setAnsweredOn(Date answeredOn) {
        this.answeredOn = answeredOn;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

}
