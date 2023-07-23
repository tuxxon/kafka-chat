package com.touchizen.chatsvr.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "chatting")
@Getter @ToString
@Setter
@AllArgsConstructor @Builder
@NoArgsConstructor
// MongoDB Chatting 모델
public class Chatting {

    @Id
    private String id;
    private Integer chatRoomNo;
    private Integer senderNo;
    private String senderName;
    private String contentType;
    private String content;
    private LocalDateTime sendDate;
    private long readCount;

}