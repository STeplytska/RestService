package test.restAPI.infoUser;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public abstract class People {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final LocalDate lastVisit;
    private final String role;

    @Override
    public String toString(){
        return firstName;
    }

    public abstract String getWelcomeMessage();

}
