package com.softserve.workoutmanager.tool.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/workout_manager?useUnicode=true&serverTimezone=UTC";
    private static final String DB_NAME = "root";
    private static final String DB_PASSWORD = "Wiqkkio8s8wnum9i7";
    private static Connection connection;

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_NAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            Logger.getGlobal().info("Connected Error");
        }
        return connection;
    }
}
