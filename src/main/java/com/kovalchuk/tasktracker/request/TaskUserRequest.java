package com.kovalchuk.tasktracker.request;

import javax.validation.constraints.NotNull;

public class TaskUserRequest {
    @NotNull
    private Long taskId;
    @NotNull
    private Long userId;

    public TaskUserRequest() {
    }

    public TaskUserRequest(Long taskId, Long userId) {
        this.taskId = taskId;
        this.userId = userId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
