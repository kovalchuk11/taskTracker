package com.kovalchuk.tasktracker.contoller;

import com.kovalchuk.tasktracker.db.impl.TaskDaoImpl;
import com.kovalchuk.tasktracker.db.impl.TaskUserDaoImpl;
import com.kovalchuk.tasktracker.db.impl.UserDaoImpl;
import com.kovalchuk.tasktracker.jwt.JwtConfig;
import com.kovalchuk.tasktracker.jwt.JwtTokenVerifier;
import com.kovalchuk.tasktracker.request.TaskRequest;
import com.kovalchuk.tasktracker.response.MessageResponse;
import io.jsonwebtoken.Claims;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import javax.validation.Valid;

@RestController()
@RequestMapping("/api/task")
public class TaskController {
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    private final TaskDaoImpl taskDaoImpl;
    private final UserDaoImpl userDaoImpl;
    private final TaskUserDaoImpl taskUserDaoImpl;

    public TaskController(SecretKey secretKey, JwtConfig jwtConfig, TaskDaoImpl taskDaoImpl, UserDaoImpl userDaoImpl, TaskUserDaoImpl taskUserDaoImpl) {
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
        this.taskDaoImpl = taskDaoImpl;
        this.userDaoImpl = userDaoImpl;
        this.taskUserDaoImpl = taskUserDaoImpl;
    }

    @PutMapping("/add")
    public ResponseEntity createTask(@Valid @RequestBody TaskRequest taskRequest, @RequestHeader("Authorization") String authorization){
        if(!RequestVerifier.isTaskStatusExist(taskRequest.getStatus())){
            return ResponseEntity.badRequest().body(new MessageResponse("That status is not exist: " + taskRequest.getStatus()));
        }

        JwtTokenVerifier jwtTokenVerifier = new JwtTokenVerifier(secretKey, jwtConfig);
        String token = jwtTokenVerifier.getToken(authorization);
        Claims body = jwtTokenVerifier.getClaims(token).getBody();

        String username = jwtTokenVerifier.getUsernameFromClaims(body);
        long taskId = taskDaoImpl.addTask(taskRequest);
        long userId = userDaoImpl.getUserByUsername(username).getUserId();

        taskUserDaoImpl.addTaskToUser(taskId, userId);

        return ResponseEntity.ok(new MessageResponse(taskRequest.toString() + " assigned to "  + username));
    }


    @PutMapping("/updateTask")
    public ResponseEntity updateUser(@Valid @RequestBody TaskRequest taskRequest){
        if(taskRequest.getId() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Task Id cant be 0"));
        }
        if(!RequestVerifier.isTaskStatusExist(taskRequest.getStatus())){
            return ResponseEntity.badRequest().body(new MessageResponse("That status is not exist: " + taskRequest.getStatus()));
        }
         taskDaoImpl.updateTask(taskRequest);

        return ResponseEntity.ok(new MessageResponse("Task updated"));
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity deleteUser(@RequestBody TaskRequest taskRequest){
        if(taskRequest.getId() == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Task Id cant be 0"));
        }
        taskDaoImpl.deleteTask(taskRequest.getId());
        return ResponseEntity.ok(new MessageResponse("Task deleted"));
    }
//
//    @PostMapping("/getUser")
//    public ResponseEntity getUserById(@PathVariable(name = "id") Long id){
//        return null;
//    }
//
//    @PostMapping("/getUser")
//    public ResponseEntity getUsers(@PathVariable(name = "pagination") int pagination){
//        return null;
//    }


}
