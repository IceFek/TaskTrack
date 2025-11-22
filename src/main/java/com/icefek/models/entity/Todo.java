package com.icefek.models.entity;

import com.icefek.models.notentity.*;

import java.io.Serializable;

public record Todo(int id, String description, String status,String createdAt,String updatedAt) implements Serializable,Resource {
    @Override
    public void show(){
        System.out.printf("\n\nTo do: %d\nDescription: %s\nStatus: %s\nCreated at: %s\nUpdated at: %s",id,description,status,createdAt,updatedAt);
    }
}
