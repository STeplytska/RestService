package com.restAPI.visits;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class VisitRepresentation {
    private final int userId;
    private final int count;
    private final String firstName;
    private final String lastName;
    private final LocalDateTime lastVisit;
}
