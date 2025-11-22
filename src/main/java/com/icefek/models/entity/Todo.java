package com.icefek.models.entity;

import com.icefek.models.notentity.*;

import java.io.Serializable;

public record Todo(long id, String description, Status status,String createdAt,String updatedAt) implements Serializable,Resource {
    @Override
    public void show(){
        System.out.printf("\n\nTo do: %d\nDescription: %s\nStatus: %s\nCreated at: %s\nUpdated at: %s",id,description,status.get(),createdAt,updatedAt);
    }
}
