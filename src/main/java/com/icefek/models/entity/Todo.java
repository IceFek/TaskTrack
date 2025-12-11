package com.icefek.models.entity;

import com.icefek.models.notentity.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.io.Serializable;

public class Todo implements Serializable,Resource {
    private final int id;
    private final String createdAt;
    private String description;
    private String status;
    private String updatedAt;
    public Todo(){
        id = -1;
        createdAt = getTime();
    }
    public Todo(int id, String description, String status) {
        this.id = id;
        this.createdAt = getTime();
        this.description = description;
        this.status = status;
        this.updatedAt = createdAt;
    }
    @Override
    public void show(){
        System.out.printf("\n\nTo do: %d\nDescription: %s\nStatus: %s\nCreated at: %s\nUpdated at: %s",id,description,status,createdAt,updatedAt);
    }
    private String getTime(){
        LocalTime localTime = LocalTime.now();
        LocalDate localDate = LocalDate.now();
        return localDate.getYear()+"-"+localDate.getMonthValue()+"-"+localDate.getDayOfMonth() + "\n" +localTime.getHour()+":"+localTime.getMinute();
    }

    public void setDescription(String description){
        this.description = description;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public void setUpdatedAt(){
        this.updatedAt = getTime();
    }
    public String getDescription() {
        return description;
    }
    public Status getStatus() {
        return switch (status) {
            case "Done" -> Status.DONE;
            case "Undone" -> Status.UN_DONE;
            case "In Progress" -> Status.IN_PROGRESS;
            default -> Status.UN_DONE;
        };
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public String getUpdatedAt() {
        return updatedAt;
    }
    public int getId() {
        return id;
    }
}
