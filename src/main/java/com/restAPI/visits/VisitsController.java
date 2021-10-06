package com.restAPI.visits;

import com.restAPI.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@RestController
public class VisitsController {

    private final AtomicInteger idUser = new AtomicInteger();

    @Autowired
    private final UserService userService;

    @GetMapping("/visits")
    public List<VisitRepresentation> visits() {
        return userService.visitorsId()
                .stream()
                .map(id -> new VisitRepresentation(
                        id,
                        userService.countOfVisits(id),
                        userService.firstNameOfVisitor(id),
                        userService.lastNameOfVisitor(id),
                        userService.lastVisitOfVisitor(id)))
                .collect(Collectors.toList());
    }
}
