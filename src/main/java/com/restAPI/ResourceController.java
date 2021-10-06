package com.restAPI;

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

    private final AtomicInteger startPoint = new AtomicInteger(0);

    @Autowired
    private final UserService userService;

    @GetMapping("/resource")
    public String resource(@RequestParam(value = "userId", defaultValue = "0") int userId) {
        try {
            return String.format("{%d (id=%s) %s}", startPoint.incrementAndGet(), userId, userService.welcomeMessage(userId));
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error", ex);
        }
    }
}
