package com.ralationship.ralationship.mapper;

import com.ralationship.ralationship.dto.FeedbackDTO;
import com.ralationship.ralationship.model.Feedback;

public class FeedbackMapper {
    public static FeedbackDTO toDto(Feedback feedback){
        FeedbackDTO dto = new FeedbackDTO();
        dto.setId(feedback.getId());
        dto.setComments(feedback.getComments());
        dto.setDecision(feedback.getDecision());
        dto.setSuggestion_id(feedback.getSuggestion() != null ? feedback.getSuggestion().getId() : feedback.getSuggestion().getId());
        dto.setAdmin_id(feedback.getAdmin() != null ? feedback.getAdmin().getId() : null);
        return dto;
    }
    public static Feedback toEntity(FeedbackDTO feedbackDTO){
        Feedback dto = new Feedback();
        dto.setId(feedbackDTO.getId());
        dto.setComments(feedbackDTO.getComments());
        dto.setDecision(feedbackDTO.getDecision());
        return dto;
    }
}
