package com.israelivancoc.Main;

import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] args) {
        // Load the .env file from the root directory
        Dotenv dotenv = Dotenv.load();

        // Try to get your token
        String token = dotenv.get("BANXICO_TOKEN");

        if (token == null || token.isEmpty()) {
            System.out.println(" ERROR: Could not find BANXICO_TOKEN in your .env file.");
        } else {
            System.out.println(" SUCCESS! Your .env file is connected.");
            // Security first: only show the start of the token
            System.out.println("Token starts with: " + token.substring(0, 5) + "...");
        }
    }
}