package com.kovalchuk.tasktracker.db.impl;

import com.kovalchuk.tasktracker.db.dao.UserDao;
import com.kovalchuk.tasktracker.db.models.User;
import com.kovalchuk.tasktracker.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final String USER_ID = "USER_ID";
    private static String USERNAME = "USERNAME";
    private static String FIRST_NAME = "FIRST_NAME";
    private static String LAST_NAME = "LAST_NAME";
    private static String EMAIL = "EMAIL";
    private static String PASSWORD = "PASSWORD";
    private static String REGISTRATION_DATE = "REGISTRATION_DATE";

    private static final String SELECT_ALL_USERS = String.format("SELECT * FROM TRACKER.USERS");
    private static final String INSERT_USER_SQL = String.format("INSERT INTO TRACKER.USERS (%s, %s, %s, %s, %s, %s) VALUES (?,?,?,?,?,?);", USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, REGISTRATION_DATE);
    private static final String SELECT_USER_BY_USERNAME = String.format("SELECT * FROM TRACKER.USERS WHERE %s = ?", USERNAME);
    private static final String UPDATE_USER_SQL = String.format("UPDATE TRACKER.USERS SET %s = (?), %s = (?), %s = (?), %s = (?), %s = (?) WHERE %s = (?);", USERNAME, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, USER_ID);
    private static final String DELETE_USER_SQL = String.format("DELETE FROM TRACKER.USERS WHERE %s = (?);", USER_ID);
    private static final String GET_USER_BY_ID_SQL = String.format("SELECT * FROM TRACKER.USERS WHERE %s=(?);", USER_ID);


    private JdbcTemplate jdbcTemplate;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDaoImpl(PasswordEncoder passwordEncoder, JdbcTemplate jdbcTemplate) {
        this.passwordEncoder = passwordEncoder;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(SignupRequest user) {
        return jdbcTemplate.update(INSERT_USER_SQL, user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), passwordEncoder.encode(user.getPassword()),
                Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public int updateUser(SignupRequest user) {
        return jdbcTemplate.update(UPDATE_USER_SQL, user.getUsername(), user.getFirstName(), user.getLastName(), user.getEmail(), passwordEncoder.encode(user.getPassword()), user.getUserId());
    }

    @Override
    public int deleteUser(long userId) {
        return jdbcTemplate.update(DELETE_USER_SQL, userId);
    }

    @Override
    public User getUser(long userId) {
        User user = jdbcTemplate.queryForObject(GET_USER_BY_ID_SQL, new Object[]{userId}, (rs, rowNum) ->
                new User(rs.getLong(USER_ID)
                        , rs.getString(USERNAME)
                        , rs.getString(FIRST_NAME)
                        , rs.getString(LAST_NAME)
                        , rs.getString(EMAIL)
                        , rs.getTimestamp(REGISTRATION_DATE).toLocalDateTime()));
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        return (User) jdbcTemplate.queryForObject(SELECT_USER_BY_USERNAME, new Object[]{username}, new BeanPropertyRowMapper(User.class));
    }

    @Override
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SELECT_ALL_USERS, (rs, rowNum) ->
                new User(rs.getLong(USER_ID)
                        , rs.getString(USERNAME)
                        , rs.getString(FIRST_NAME)
                        , rs.getString(LAST_NAME)
                        , rs.getString(EMAIL)
                        , rs.getTimestamp(REGISTRATION_DATE).toLocalDateTime()));
    }
}
