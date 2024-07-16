package com.abreu.socket.service;

import com.abreu.socket.entities.User;
import com.abreu.socket.entities.enums.Status;
import com.abreu.socket.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        user.setStatus(Status.ONLINE);
        userRepository.save(user);
    }

    public void disconnectUser(User user) {
        userRepository.findById(user.getNickName()).ifPresent(storedUser -> {
            storedUser.setStatus(Status.OFFLINE);
            userRepository.save(storedUser);
        });

    }

    public List<User> findConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }

}
