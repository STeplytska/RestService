package test.restAPI.infoUser;

import java.time.LocalDateTime;

public class RegularUser extends People{
    public RegularUser(int Id, String firstName, String LastName, LocalDateTime lastVisit) {
        super(Id, firstName, LastName, lastVisit, "regularUser");
    }

    @Override
    public String getWelcomeMessage() {
        return String.format("Welcome, %s, %s,! \nYour last visit is %s", getFirstName(), getLastName(), getLastVisit());
    }
}
