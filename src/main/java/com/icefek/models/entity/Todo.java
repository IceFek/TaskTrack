package com.icefek.models.entity;

import com.icefek.models.notentity.Status;

import java.io.Serializable;

public record Todo(long id, String description, Status status,String createdAt,String updatedAt) implements Serializable {

}
