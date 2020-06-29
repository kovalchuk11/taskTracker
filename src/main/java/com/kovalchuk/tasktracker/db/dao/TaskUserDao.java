package com.kovalchuk.tasktracker.db.dao;

import com.kovalchuk.tasktracker.db.models.Task;
import com.kovalchuk.tasktracker.db.models.TaskUser;
import com.kovalchuk.tasktracker.request.GetTaskRequest;

import java.util.List;

public interface TaskUserDao {

    int addTaskToUser(long taskId, long userId);

    List<TaskUser> getTasks(GetTaskRequest taskRequest);
}
