package test.restAPI;

import org.springframework.stereotype.Component;
import test.restAPI.infoUser.Guest;
import test.restAPI.infoUser.People;
import test.restAPI.infoUser.RegularUser;

import java.time.LocalDateTime;
import java.util.*;

@Component
public class Model {

    private final List<People> peopleFromStorage = Arrays.asList(
            new Guest(4, "Tom", "Ryan"),
            new RegularUser(20, "Carla", "Darcy", LocalDateTime.of(2017, 2, 25, 22, 20, 5)),
            new Guest(56, "Jones", "Williams"),
            new RegularUser(65, "Roberts", "Miller", LocalDateTime.of(2021, 2, 12, 12, 10, 30)),
            new RegularUser(32, "Clark", "Morris", LocalDateTime.of(2021, 4, 3, 16, 14, 3)),
            new RegularUser(45, "Garry", "Potter", LocalDateTime.of(2020, 2, 16, 14, 20, 0)),
            new Guest(34, "Adas", "Scott"),
            new RegularUser(120, "Mary", "Ryan", LocalDateTime.of(2019, 12, 5, 7, 17, 15)));

    private final HashMap<Integer, Integer> visits = new HashMap<>();

    public String welcomeMessage(final int idUser) {
        markVisit(idUser);
        return peopleFromStorage
                .stream()
                .filter(f -> idUser == (f.getId()))
                .findFirst()
                .map(f -> {
                    f.setLastVisit(LocalDateTime.now());
                    return f.getWelcomeMessage();
                })
                .orElseThrow(() -> new IllegalStateException("Authorize before using the service"));
    }

    public Set<Integer> visitorsId() {
        return visits.keySet();
    }

    public Integer countOfVisits(Integer visitorsId) {
        if (visits.containsKey(visitorsId)) {
            return visits.get(visitorsId);
        } else {
            throw new IllegalStateException("Visitor not found");
        }
    }

    public String firstNameOfVisitor(Integer visitorsId) {
        return peopleFromStorage
                .stream()
                .filter(f -> visitorsId == (f.getId()))
                .findFirst()
                .map(People::getFirstName)
                .orElseThrow(() -> new IllegalStateException("Visitor not found"));
    }

    public String lastNameOfVisitor(Integer visitorsId) {
        return peopleFromStorage
                .stream()
                .filter(f -> visitorsId == (f.getId()))
                .findFirst()
                .map(People::getLastName)
                .orElseThrow(() -> new IllegalStateException("Visitor not found"));
    }

    public LocalDateTime lastVisitOfVisitor(Integer visitorsId) {
        return peopleFromStorage
                .stream()
                .filter(f -> visitorsId == (f.getId()))
                .findFirst()
                .map(People::getLastVisit)
                .orElseThrow(() -> new IllegalStateException("Visitor not found"));
    }

    private void markVisit(final int idUser) {
        int count = visits.getOrDefault(idUser, 0);
        visits.put(idUser, ++count);
    }
}
