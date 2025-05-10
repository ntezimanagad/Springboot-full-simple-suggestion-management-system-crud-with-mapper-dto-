package com.ralationship.ralationship.model;

import jakarta.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comments")
    private String comments;
    @Column(name = "decision")
    private String decision;

    @ManyToOne
    @JoinColumn(name = "suggestion_id")
    private Suggestion suggestion;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    

    public Feedback() {
    }

    public Feedback(String comments, String decision, Suggestion suggestion, Admin admin) {
        this.comments = comments;
        this.decision = decision;
        this.suggestion = suggestion;
        this.admin = admin;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    
}
