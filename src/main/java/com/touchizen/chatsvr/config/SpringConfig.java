package com.touchizen.chatsvr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.touchizen.chatsvr.repository.MessageRepository;
import com.touchizen.chatsvr.service.MessageService;

@Configuration
public class SpringConfig {

    private final MessageRepository messageRepository;

    public SpringConfig(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(messageRepository);
    }
}