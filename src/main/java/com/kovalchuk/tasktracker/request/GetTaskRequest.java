package com.kovalchuk.tasktracker.request;

import javax.validation.constraints.NotBlank;

public class GetTaskRequest {
    @NotBlank
    private String status;
    @NotBlank
    private String orderType;

    public GetTaskRequest(String status, String orderType) {
        this.status = status;
        this.orderType = orderType;
    }

    public GetTaskRequest() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
