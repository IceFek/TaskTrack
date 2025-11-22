package com.icefek.models.entity;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RestClientHanlder {
    private static final String Base_URL = "https://my-json-server.typicode.com/IceFek/TaskManagerREST/todos";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    protected static Optional<Todo> get(int id){
        Todo todo;
        try {
            Optional<List<Todo>> op = getTodo();
            List<Todo> arrayList = op.get();
            todo = arrayList.get(id);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return Optional.of(todo);
    }


    private static Optional<List<Todo>> getTodo() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<Todo> list = mapper.readValue(response.body(), new TypeReference<List<Todo>>() {});
        return Optional.of(list);
    }

}
