package com.kovalchuk.tasktracker.db.dao;

import com.kovalchuk.tasktracker.db.models.Task;
import com.kovalchuk.tasktracker.db.models.User;
import com.kovalchuk.tasktracker.request.ChangeTaskStatusRequest;
import com.kovalchuk.tasktracker.request.SignupRequest;
import com.kovalchuk.tasktracker.request.TaskRequest;

import java.util.List;

public interface TaskDao {
    int addTask(TaskRequest taskRequest);

    int updateTask(TaskRequest taskRequest);

    int changeStatus(ChangeTaskStatusRequest TaskStatusRequest);

    int deleteTask(long taskId);

    Task getTask(long taskId);

    List<Task> getAllTasks();
}
