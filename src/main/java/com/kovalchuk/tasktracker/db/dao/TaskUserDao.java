package com.kovalchuk.tasktracker.db.dao;

import com.kovalchuk.tasktracker.db.models.Task;
import com.kovalchuk.tasktracker.db.models.TaskUser;
import com.kovalchuk.tasktracker.request.GetTaskRequest;
import com.kovalchuk.tasktracker.request.TaskUserRequest;

import java.util.List;

public interface TaskUserDao {

    int addTaskToUser(long taskId, long userId);

    int changeTaskResponsible(TaskUserRequest taskUserRequest);

    List<TaskUser> getTasks(GetTaskRequest taskRequest);
}
