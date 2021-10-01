package test.restAPI.infoUser;

import java.time.LocalDateTime;

public class Guest extends People{
    public Guest(int Id, String firstName, String lastName) {
        super(Id, firstName, lastName, LocalDateTime.now(), "Guest");
    }

    @Override
    public String getWelcomeMessage() {
        return String.format("Welcome, %s, %s!", getFirstName(), getLastName());
    }
}
