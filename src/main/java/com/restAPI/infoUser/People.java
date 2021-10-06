package com.restAPI.infoUser;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public abstract class People {
    private final int id;
    private final String firstName;
    private final String lastName;
    @Setter
    private LocalDateTime lastVisit;
    private final String role;

    @Override
    public String toString(){
        return firstName;
    }

    public abstract String getWelcomeMessage();

}
