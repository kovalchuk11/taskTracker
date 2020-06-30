package com.kovalchuk.tasktracker.db.dao;

import com.kovalchuk.tasktracker.db.models.User;
import com.kovalchuk.tasktracker.request.UserRequest;

import java.util.List;

public interface UserDao {
    int addUser(UserRequest userRequest);

    int updateUser(UserRequest user);

    int deleteUser(long userId);

    User getUser(long userId);

    List<User> getAllUsers(int page);

    User getUserByUsername(String username);
}
