package com.abreu.socket.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "chat_notifications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatNotification {

    @Id
    private String id;
    private String senderId;
    private String recipientId;
    private String content;

}
