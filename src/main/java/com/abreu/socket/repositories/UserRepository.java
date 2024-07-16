package com.abreu.socket.repositories;

import com.abreu.socket.entities.User;
import com.abreu.socket.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findAllByStatus(Status status);
}
