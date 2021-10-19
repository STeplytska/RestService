package com.restAPI.cucumberTests;

import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HttpClient {

    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/resource";
    private final String THINGS_VISIT_ENDPOINT = "/visits";

    private final RestTemplate restTemplate = new RestTemplate();

    private String resourceEndpoint() {
        return SERVER_URL + ":" + "8080" + THINGS_ENDPOINT;
    }

    private String visitsEndpoint() {
        return SERVER_URL + ":" + "8080" + THINGS_VISIT_ENDPOINT;
    }

    public String resourceToUser(String idUser) {
        return restTemplate.getForObject(resourceEndpoint() + "?userId=" + idUser, String.class);
    }

    public String resource() {
        System.out.println(restTemplate.getForObject(resourceEndpoint() + "?userId=0", String.class));
        return null;
    }

    public String visits() {
        System.out.println(restTemplate.getForObject(resourceEndpoint() + "?userId=0", String.class));
        return null;
    }

    public ResponseEntity<String> testJs() {
        return restTemplate.getForEntity(visitsEndpoint(), String.class);
    }

    public HttpStatus statusServerError() throws HttpServerErrorException {
        try {
            return restTemplate.getForEntity(resourceEndpoint(), String.class).getStatusCode();
        } catch (HttpServerErrorException e) {
            return e.getStatusCode();
        }
    }
}
