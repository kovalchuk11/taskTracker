package com.kovalchuk.tasktracker.db.dao;

import com.kovalchuk.tasktracker.db.models.User;
import com.kovalchuk.tasktracker.request.SignupRequest;

import java.util.List;

public interface UserDao {
    int addUser(SignupRequest signupRequest);

    int updateUser(SignupRequest user);

    int deleteUser(long userId);

    User getUser(long userId);

    List<User> getAllUsers();

    User getUserByUsername(String username);
}
