package com.kovalchuk.tasktracker.request;

import javax.validation.constraints.NotBlank;

public class ChangeTaskStatusRequest {
    @NotBlank
    private Long id;

    @NotBlank
    private String status;

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
}
