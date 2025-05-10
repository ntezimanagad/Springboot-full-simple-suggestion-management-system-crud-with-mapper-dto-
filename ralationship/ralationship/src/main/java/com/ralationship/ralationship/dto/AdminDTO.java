package com.ralationship.ralationship.dto;

import java.util.List;

public class AdminDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private List<FeedbackDTO> feedbackDTO;
    public AdminDTO() {
    }
    public AdminDTO(String name, String email, String password, List<FeedbackDTO> feedbackDTO) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.feedbackDTO = feedbackDTO;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public List<FeedbackDTO> getFeedbackDTO() {
        return feedbackDTO;
    }
    public void setFeedbackDTO(List<FeedbackDTO> feedbackDTO) {
        this.feedbackDTO = feedbackDTO;
    }

    
}
