package com.kovalchuk.tasktracker.db.impl;

import com.kovalchuk.tasktracker.db.dao.TaskUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskUserDaoImpl implements TaskUserDao {
    private static String USER_TASK_ID = "USER_TASK_ID";
    private static String TASK_ID = "TASK_ID";
    private static String USER_ID = "USER_ID";

    private static final String INSERT_USERS_TASKS_SQL = String.format("INSERT INTO TRACKER.USERS_TASKS (%s, %s) VALUES (?,?);", TASK_ID, USER_ID);

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public TaskUserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addTaskToUser(long taskId, long userId) {
        return jdbcTemplate.update(INSERT_USERS_TASKS_SQL, taskId, userId);
    }
}
