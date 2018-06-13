package com.codecool.server.Post;

public class Post {

    public String message;
    public String name;
    public String email;
    public String date;

    Post(String message, String name, String email, String date) {
        this.message = message;
        this.name = name;
        this.email = email;
        this.date = date;
    }
}
