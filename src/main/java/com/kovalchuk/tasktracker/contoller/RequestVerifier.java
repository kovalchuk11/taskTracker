package com.kovalchuk.tasktracker.contoller;

import com.kovalchuk.tasktracker.db.models.Status;

public class RequestVerifier {

    public static boolean isTaskStatusExist(String status){
        return Status.statuses.contains(status);
    }
}
