package com.kovalchuk.tasktracker.contoller;

import com.kovalchuk.tasktracker.db.impl.UserDaoImpl;
import com.kovalchuk.tasktracker.request.UserRequest;
import com.kovalchuk.tasktracker.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserDaoImpl userDaoImpl;

    public UserController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @PostMapping("/signup")
    public ResponseEntity registerUser(@Valid @RequestBody UserRequest userRequest) {
        int insertedRowsCount = userDaoImpl.addUser(userRequest);
        if (insertedRowsCount == 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("Something wrong"));
        } else
            return ResponseEntity.ok().body(new MessageResponse("User is registered"));
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@Valid @RequestBody UserRequest userRequest) {
        int updatedRows = userDaoImpl.updateUser(userRequest);
        if (updatedRows == 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("Something wrong"));
        } else
            return ResponseEntity.ok().body(new MessageResponse("User is updated"));
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody UserRequest userRequest) {
        if (userRequest.getUserId() == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("userId can't be null"));
        }
        int updatedRows = userDaoImpl.deleteUser(userRequest.getUserId());
        if (updatedRows == 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("User is already deleted"));
        } else
            return ResponseEntity.ok().body(new MessageResponse("User is deleted"));
    }

    @PostMapping("/getUser")
    public ResponseEntity getUserById(@RequestBody UserRequest userRequest) {
        if (userRequest.getUserId() == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("userId can't be null"));
        }
        return ResponseEntity.ok(userDaoImpl.getUser(userRequest.getUserId()));
    }

    @PostMapping("/getUsers")
    public ResponseEntity getUsers(@RequestBody UserRequest userRequest) {
        if (userRequest.getPage() <= 0) {
            return ResponseEntity.badRequest().body(new MessageResponse("Enter the correct page"));
        }

        return ResponseEntity.ok(userDaoImpl.getAllUsers(userRequest.getPage()));
    }
}
