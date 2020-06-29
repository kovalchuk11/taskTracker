package com.kovalchuk.tasktracker.contoller;

import com.kovalchuk.tasktracker.db.models.ValuesFilter;

public class RequestVerifier {

    public static boolean isTaskStatusExist(String status){
        return ValuesFilter.statuses.contains(status);
    }

    public static boolean isOrderTypeExist(String orderType){
        return ValuesFilter.orderType.contains(orderType);
    }
}
