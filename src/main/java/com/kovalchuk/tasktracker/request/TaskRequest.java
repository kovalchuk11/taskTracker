package com.kovalchuk.tasktracker.request;

import javax.validation.constraints.NotBlank;

public class TaskRequest {
    private Long id;

    @NotBlank
    private String status;

    private String description;

    @NotBlank
    private String title;

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

    @Override
    public String toString() {
        return "TaskRequest{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
