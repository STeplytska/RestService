package test.restAPI.visits;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import test.restAPI.Model;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@AllArgsConstructor
@Getter
@RestController
public class VisitsController {

    private final AtomicInteger idUser = new AtomicInteger();

    @Autowired
    private final Model model;

    @GetMapping("/visits")
    public List<VisitRepresentation> visits() {
        return model.visitorsId()
                .stream()
                .map(id -> new VisitRepresentation(
                        id,
                        model.countOfVisits(id),
                        model.firstNameOfVisitor(id),
                        model.lastNameOfVisitor(id),
                        model.lastVisitOfVisitor(id)))
                .collect(Collectors.toList());
    }
}
