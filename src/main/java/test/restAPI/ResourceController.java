package test.restAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
@Getter
@RestController
public class ResourceController {

    public static final String response = "Welcome, %s!";
    private final AtomicInteger idUser = new AtomicInteger();

    @GetMapping("/resource")
    public ResourceRepresentation resource(@RequestParam(value = "userName", defaultValue = "Guest") String userName) {
        return new ResourceRepresentation(idUser.incrementAndGet(), String.format(response, userName));
    }
}
