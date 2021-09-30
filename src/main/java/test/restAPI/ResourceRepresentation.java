package test.restAPI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceRepresentation {

    private final long id;
    private final String content;
}
