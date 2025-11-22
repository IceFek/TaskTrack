package com.icefek.models.notentity;

public enum Status {
    DONE("Done"),
    IN_PROGRESS("In Progress"),
    UN_DONE("Undone");
    private final String get;
    Status(String get){
        this.get = get;
    }
    public String get(){
        return this.get;
    }
}
