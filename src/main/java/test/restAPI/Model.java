package test.restAPI;

import org.springframework.stereotype.Component;
import test.restAPI.infoUser.Guest;
import test.restAPI.infoUser.People;
import test.restAPI.infoUser.RegularUser;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class Model {

    private final List<People> peopleFromStorage = Arrays.asList(
            new Guest(4, "Tom", "Ryan"),
            new RegularUser(20, "Carla", "Darcy", LocalDate.of(2017,2,25)),
            new Guest(56, "Jones", "Williams"),
            new RegularUser(65, "Roberts", "Miller", LocalDate.of(2021,2,12)),
            new RegularUser(32, "Clark", "Morris", LocalDate.of(2021,4,3)),
            new RegularUser(45, "Garry", "Potter", LocalDate.of(2020,2,16)),
            new Guest(34, "Adas", "Scott"),
            new RegularUser(120, "Mary", "Ryan", LocalDate.of(2019,12,5)));


    public String welcomeMessage(final int idUser) {
        return peopleFromStorage
                .stream()
                .filter(f -> idUser == (f.getId()))
                .findFirst()
                .map(People::getWelcomeMessage)
                .orElseThrow(() -> new IllegalStateException("Authorize before using the service"));
    }


}
