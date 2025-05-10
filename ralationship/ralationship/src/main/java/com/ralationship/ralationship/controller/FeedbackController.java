package com.ralationship.ralationship.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ralationship.ralationship.dto.FeedbackDTO;
import com.ralationship.ralationship.service.FeedbackService;

@RestController
@RequestMapping(value = "/api/feedback")
@CrossOrigin("*")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody FeedbackDTO feedbackDTO){
        feedbackService.createFeedback(feedbackDTO);
        return ResponseEntity.ok("created");
    }
}
