package com.example.shop.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
public class CommentBean {
    public int id;
    public int pid;
    public int uid;
    public String comment;
    public LocalDateTime ctime;
}
