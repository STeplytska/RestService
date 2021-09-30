package test.restAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@RestController
public class ResourceController {

    private final AtomicInteger idUser = new AtomicInteger();

    @Autowired
    private final Model model;

    @GetMapping("/resource")
    public ResourceRepresentation resource(@RequestParam(value = "userId", defaultValue = "0") int userId) {
        try {
            return new ResourceRepresentation(idUser.incrementAndGet(), model.welcomeMessage(userId));
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error", ex);
        }
    }
}
