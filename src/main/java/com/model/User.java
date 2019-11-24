package com.model;

import lombok.Data;

@Data
public class User {

    int id;
    String name;
    String requestText;
    String replyText;
    String userName;
}