package com.abreu.socket.controller;

import com.abreu.socket.entities.User;
import com.abreu.socket.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @MessageMapping("/user.addUser")
    @SendTo("/user/topic")
    public ResponseEntity<User> addUser(@Payload User user) {
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @MessageMapping("/user.disconnectedUser")
    @SendTo("/user/topic")
    public ResponseEntity<User> disconnectUser(@Payload User user) {
        userService.disconnectUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> findConnectedUsers() {
        return ResponseEntity.ok(userService.findConnectedUsers());
    }
}
