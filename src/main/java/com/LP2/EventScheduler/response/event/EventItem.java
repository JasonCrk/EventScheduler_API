package com.LP2.EventScheduler.response.event;

import com.LP2.EventScheduler.response.category.CategoryResponse;
import com.LP2.EventScheduler.response.user.SimpleUserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventItem {
    private UUID id;
    private SimpleUserResponse coordinator;
    private String name;
    private String description;
    private String visibility;
    private String status;
    private String realizationDate;
    private CategoryResponse category;
    private int numberParticipants;
    private String createdAt;
}
