package com.kovalchuk.tasktracker.contoller;

import com.kovalchuk.tasktracker.db.impl.UserDaoImpl;
import com.kovalchuk.tasktracker.request.SignupRequest;
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
    public ResponseEntity registerUser(@Valid @RequestBody SignupRequest signUpRequest){
        int insertedRowsCount = userDaoImpl.addUser(signUpRequest);
        if(insertedRowsCount == 0){
            return ResponseEntity.badRequest().body(new MessageResponse("Something wrong"));
        }else
        return ResponseEntity.ok().body(new MessageResponse("User is registered"));
    }

    @PutMapping("/updateUser")
    public ResponseEntity updateUser(@Valid @RequestBody SignupRequest signUpRequest){
        int updatedRows = userDaoImpl.updateUser(signUpRequest);
        if(updatedRows == 0){
            return ResponseEntity.badRequest().body(new MessageResponse("Something wrong"));
        }else
            return ResponseEntity.ok().body(new MessageResponse("User is updated"));
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity deleteUser(@RequestBody SignupRequest signUpRequest){
        if (signUpRequest.getUserId() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("userId can't be null"));
        }
        int updatedRows = userDaoImpl.deleteUser(signUpRequest.getUserId());
        if(updatedRows == 0){
            return ResponseEntity.badRequest().body(new MessageResponse("User is already deleted"));
        }else
            return ResponseEntity.ok().body(new MessageResponse("User is deleted"));
    }

    @PostMapping("/getUser")
    public ResponseEntity getUserById(@RequestBody SignupRequest signUpRequest){
        if (signUpRequest.getUserId() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("userId can't be null"));
        }
        return ResponseEntity.ok(userDaoImpl.getUser(signUpRequest.getUserId()));
    }

    @PostMapping("/getUsers")
    public ResponseEntity getUsers(@RequestBody SignupRequest signUpRequest){
        if (signUpRequest.getUserId() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("userId can't be null"));
        }
        return ResponseEntity.ok(userDaoImpl.getAllUsers());
    }
}
