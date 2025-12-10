package com.icefek.models.entity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.icefek.models.notentity.ElementIsntExistException;

import java.io.IOException;
import java.net.URI;
import java.net.http.*;
import java.util.List;
import java.util.Optional;

public abstract class RestClientHanlder {
    private static final String Base_URL = "https://6934a12f4090fe3bf020662d.mockapi.io/icefek/todos/db";
    private static final HttpClient client = HttpClient.newHttpClient();
    private static final ObjectMapper mapper = new ObjectMapper();

    protected static boolean postRequest(Todo todo){
        String todoString = null;
        HttpResponse<String> response;
        try{
            todoString = mapper.writeValueAsString(todo);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        if(todoString == null){
            return false;
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(todoString))
                .build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    protected static Optional<List<Todo>> getRequest() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        List<Todo> list = mapper.readValue(response.body(), new TypeReference<List<Todo>>() {});
        return Optional.of(list);
    }
    protected static boolean deleteRequest(String id){
        HttpRequest deleteRequest = HttpRequest.newBuilder()
                .uri(URI.create(Base_URL+"/"+id))
                .DELETE()
                .build();
        try {
            HttpResponse<String> deleteResponse = client.send(deleteRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | RuntimeException | InterruptedException e) {
            return false;
        }
        return true;
    }

}
