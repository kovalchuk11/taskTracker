package com.kovalchuk.tasktracker.db.impl;

import com.kovalchuk.tasktracker.db.dao.TaskDao;
import com.kovalchuk.tasktracker.db.models.Task;
import com.kovalchuk.tasktracker.request.ChangeTaskStatusRequest;
import com.kovalchuk.tasktracker.request.TaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class TaskDaoImpl implements TaskDao {

    private static final String ID = "ID";
    private static final String STATUS = "STATUS";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String TITLE = "TITLE";

    private static final String UPDATE_TASK_SQL = String.format("UPDATE TRACKER.TASKS SET %s = (?), %s = (?), %s = (?) WHERE %s = (?);", STATUS, DESCRIPTION, TITLE, ID);
    private static final String DELETE_TASK_SQL = String.format("DELETE FROM TRACKER.TASKS WHERE %s = (?);", ID);
    private static final String INSERT_TASK_SQL = String.format("INSERT INTO TRACKER.TASKS (%s, %s, %s) VALUES (?,?,?);", STATUS, DESCRIPTION, TITLE);

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addTask(TaskRequest taskRequest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement statement = connection
                    .prepareStatement(INSERT_TASK_SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, taskRequest.getStatus());
            statement.setString(2, taskRequest.getDescription());
            statement.setString(3, taskRequest.getTitle());
            return statement;
        }, keyHolder);
        return (int) keyHolder.getKeys().get("id");
    }

    @Override
    public int updateTask(TaskRequest taskRequest) {
        return jdbcTemplate.update(UPDATE_TASK_SQL, taskRequest.getStatus(), taskRequest.getDescription(), taskRequest.getTitle(), taskRequest.getId());
    }

    @Override
    public int changeStatus(ChangeTaskStatusRequest TaskStatusRequest) {
        return 0;
    }

    @Override
    public int deleteTask(long taskId) {
        return jdbcTemplate.update(DELETE_TASK_SQL, taskId);
    }

    @Override
    public Task getTask(long taskId) {
        return null;
    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }
}
