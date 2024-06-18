package com.example.DebugDen.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTitle;
    private String questionBody;

    @ElementCollection
    private List<String> questionTags;

    private int noOfAnswers;

    @ElementCollection
    private List<String> upVote;

    @ElementCollection
    private List<String> downVote;

    private String userPosted;

    private String userEmail;

    private Date askedOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "question_id")
    private List<Answer> answers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionBody() {
        return questionBody;
    }

    public void setQuestionBody(String questionBody) {
        this.questionBody = questionBody;
    }

    public List<String> getQuestionTags() {
        return questionTags;
    }

    public void setQuestionTags(List<String> questionTags) {
        this.questionTags = questionTags;
    }

    public int getNoOfAnswers() {
        return noOfAnswers;
    }

    public void setNoOfAnswers(int noOfAnswers) {
        this.noOfAnswers = noOfAnswers;
    }

    public List<String> getUpVote() {
        return upVote;
    }

    public void setUpVote(List<String> upVote) {
        this.upVote = upVote;
    }

    public List<String> getDownVote() {
        return downVote;
    }

    public void setDownVote(List<String> downVote) {
        this.downVote = downVote;
    }

    public String getUserPosted() {
        return userPosted;
    }

    public void setUserPosted(String userPosted) {
        this.userPosted = userPosted;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getAskedOn() {
        return askedOn;
    }

    public void setAskedOn(Date askedOn) {
        this.askedOn = askedOn;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
