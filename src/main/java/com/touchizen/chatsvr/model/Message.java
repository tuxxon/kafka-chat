package com.touchizen.chatsvr.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "messages")
public class Message {
    @Id @Getter @Setter
    private String id;
    @Getter @Setter
    private String time;
    @Getter @Setter
    private String message;

    @Override
    public String toString() {
        return "[" + this.time + "] " + this.message;
    }
}