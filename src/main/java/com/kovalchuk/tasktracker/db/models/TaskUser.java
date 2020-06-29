package com.kovalchuk.tasktracker.db.models;

public class TaskUser {
    private Long id;
    private Long userId;
    private String status;
    private String description;
    private String title;
    private String username;

    public TaskUser(Long id, Long userId, String status, String description, String title, String username) {
        this.id = id;
        this.userId = userId;
        this.status = status;
        this.description = description;
        this.title = title;
        this.username = username;
    }

    public TaskUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
