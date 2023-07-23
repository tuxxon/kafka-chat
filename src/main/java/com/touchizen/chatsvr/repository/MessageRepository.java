package com.touchizen.chatsvr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.touchizen.chatsvr.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {
    
}