package com.example;

import com.example.models.User;

public class Main {
    public static void main(String[] args) {

        User user = User.builder()
                .id("e468e704-4f54-4bf0-8f8d-8cccec440577")
                .email("email@email.com")
                .password("password****")
                .build();

        System.out.println(user.toString());
    }

}