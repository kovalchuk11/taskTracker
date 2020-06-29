package com.kovalchuk.tasktracker.db.dao;

public interface TaskUserDao {

    int addTaskToUser(long taskId, long userId);
}
