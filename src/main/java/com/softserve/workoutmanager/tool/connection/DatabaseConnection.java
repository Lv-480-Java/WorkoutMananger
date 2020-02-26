package com.softserve.workoutmanager.tool.connection;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
    //private static Logger logger = Logger.getLogger(DatabaseConnection.class.getName());

    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/workout_manager?useUnicode=true&serverTimezone=UTC";
    private static final String NAME = "root";
    private static final String PASSWORD = "";
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
            //logger.info("Connected to database  is successfully");
        } catch (SQLException | ClassNotFoundException e) {
            //logger.error("Problem with connection to database");
            //logger.error(e.getMessage());
        }
    }

    public static DatabaseConnection getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new DatabaseConnection();
            }
        } catch (SQLException e) {
            //logger.error(e.getMessage());
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
