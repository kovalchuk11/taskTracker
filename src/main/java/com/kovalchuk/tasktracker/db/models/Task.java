package com.kovalchuk.tasktracker.db.models;

public class Task {
    private Long id;
    private String status;
    private String description;
    private String title;

    public Task() {
    }

    public Task(Long id, String status, String description, String title) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.title = title;
    }

    public Task(String status, String description, String title) {
        this.status = status;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
