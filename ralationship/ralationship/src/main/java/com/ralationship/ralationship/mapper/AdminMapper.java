package com.ralationship.ralationship.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ralationship.ralationship.dto.AdminDTO;
import com.ralationship.ralationship.dto.FeedbackDTO;
import com.ralationship.ralationship.model.Admin;
import com.ralationship.ralationship.model.Feedback;

public class AdminMapper {
    public static AdminDTO toDto(Admin admin){
        AdminDTO dto = new AdminDTO();
        dto.setId(admin.getId());
        dto.setName(admin.getName());
        dto.setEmail(admin.getEmail());
        dto.setPassword(admin.getPassword());

        List<FeedbackDTO> feedbackDTOs = admin.getFeedbacks() != null
            ? admin.getFeedbacks().stream()
                .map(FeedbackMapper::toDto)
                .collect(Collectors.toList())
            : new ArrayList<>();
        dto.setFeedbackDTO(feedbackDTOs);
        return dto;
    }
    public static Admin toEntity(AdminDTO adminDTO){
        Admin dto = new Admin();
        dto.setId(adminDTO.getId());
        dto.setName(adminDTO.getName());
        dto.setEmail(adminDTO.getEmail());
        dto.setPassword(adminDTO.getPassword());

        List<FeedbackDTO> feedbackDTOs = adminDTO.getFeedbackDTO() != null
            ? adminDTO.getFeedbackDTO()
            : new ArrayList<>();

        List<Feedback> feedbacks = feedbackDTOs.stream()
            .map(AdminMapper::toMapFeedback)
            .collect(Collectors.toList());
        dto.setFeedbacks(feedbacks);
        return dto;
    }
    public static Feedback toMapFeedback(FeedbackDTO feedbackDTO){
        Feedback feedback = new Feedback();
        feedback.setId(feedbackDTO.getId());
        feedback.setComments(feedbackDTO.getComments());
        feedback.setDecision(feedback.getDecision());
        return feedback;
    }
}
