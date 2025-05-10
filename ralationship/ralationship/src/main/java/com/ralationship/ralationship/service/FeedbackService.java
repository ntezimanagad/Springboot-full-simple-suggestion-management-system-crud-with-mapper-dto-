package com.ralationship.ralationship.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ralationship.ralationship.dto.FeedbackDTO;
import com.ralationship.ralationship.mapper.FeedbackMapper;
import com.ralationship.ralationship.model.Admin;
import com.ralationship.ralationship.model.Feedback;
import com.ralationship.ralationship.model.Suggestion;
import com.ralationship.ralationship.repository.AdminRepository;
import com.ralationship.ralationship.repository.FeedbackRepository;
import com.ralationship.ralationship.repository.SuggestionRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private SuggestionRepository suggestionRepository;
    @Autowired
    private AdminRepository adminRepository;
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO){
        Feedback feedback = FeedbackMapper.toEntity(feedbackDTO);
        if (feedbackDTO.getSuggestion_id() != null) {
            Suggestion suggestion = suggestionRepository.findById(feedbackDTO.getAdmin_id())
                .orElseThrow(()-> new RuntimeException("Suggestion not found not found"));
            feedback.setSuggestion(suggestion);
        }
        if (feedbackDTO.getAdmin_id() != null) {
            Admin admin = adminRepository.findById(feedbackDTO.getAdmin_id())
                .orElseThrow(()-> new RuntimeException("Admin not found"));
            feedback.setAdmin(admin);
        }
        Optional<Suggestion> s = suggestionRepository.findById(feedbackDTO.getSuggestion_id());
        if (s.isPresent()) {
            Suggestion ss = s.get();
            ss.setStatus(feedbackDTO.getDecision());
            suggestionRepository.save(ss);
        }
        
        Feedback save = feedbackRepository.save(feedback);
        return FeedbackMapper.toDto(save); 
    }
}
