package com.kovalchuk.tasktracker.db.impl;

import com.kovalchuk.tasktracker.db.dao.TaskUserDao;
import com.kovalchuk.tasktracker.db.models.TaskUser;
import com.kovalchuk.tasktracker.request.GetTaskRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskUserDaoImpl implements TaskUserDao {
    private static String USER_TASK_ID = "USER_TASK_ID";
    private static String TASK_ID = "TASK_ID";
    private static String USER_ID = "USER_ID";

    private static final String INSERT_USERS_TASKS_SQL = String.format("INSERT INTO TRACKER.USERS_TASKS (%s, %s) VALUES (?,?);", TASK_ID, USER_ID);
    private static final String SELECT_TASKS_BY_STATUS_SQL = "SELECT TRACKER.TASKS.ID, TRACKER.USERS.USER_ID, TRACKER.TASKS.STATUS, TRACKER.TASKS.DESCRIPTION, TRACKER.TASKS.TITLE,\n" +
            "       TRACKER.USERS.USERNAME\n" +
            "FROM TRACKER.TASKS\n" +
            "INNER JOIN TRACKER.USERS_TASKS\n" +
            "ON TASKS.ID = USERS_TASKS.TASK_ID\n" +
            "INNER JOIN TRACKER.USERS\n" +
            "ON USERS_TASKS.USER_ID = USERS.USER_ID\n" +
            "WHERE TASKS.STATUS = ?\n" +
            "ORDER BY USERS.REGISTRATION_DATE " + "%s";

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addTaskToUser(long taskId, long userId) {
        return jdbcTemplate.update(INSERT_USERS_TASKS_SQL, taskId, userId);
    }

    @Override
    public List<TaskUser> getTasks(GetTaskRequest taskRequest) {

        return jdbcTemplate.query(String.format(SELECT_TASKS_BY_STATUS_SQL, taskRequest.getOrderType()), new Object[]{taskRequest.getStatus()},
                new BeanPropertyRowMapper<>(TaskUser.class));
    }
}
