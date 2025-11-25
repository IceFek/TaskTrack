package com.icefek.models.entity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icefek.models.notentity.ElementIsntExistException;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.List;
import java.util.Optional;

public abstract class RestClientHanlder {
    private static final String Base_URL = "https://my-json-server.typicode.com/IceFek/TaskManagerREST/todos";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();


    protected static Optional<List<Todo>> getRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<Todo> list = mapper.readValue(response.body(), new TypeReference<List<Todo>>() {});
        return Optional.of(list);
    }

}
