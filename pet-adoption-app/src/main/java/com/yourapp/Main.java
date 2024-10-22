package com.yourapp;

import com.yourapp.config.DatabaseConfig;

public class Main {
    public static void main(String[] args) {
        // Initialize the database connection
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.connect();
        
        // Example output
        System.out.println("Connected to the database successfully!");
    }
}
