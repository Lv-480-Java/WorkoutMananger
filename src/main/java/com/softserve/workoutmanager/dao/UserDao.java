package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;
import com.softserve.workoutmanager.tool.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class UserDao {

    private static Logger logger = Logger.getLogger(UserDao.class.getName());

    public void create(User user) {
        String sql = "INSERT INTO USERS (NAME, PASSWORD, EMAIL, PHONE, USERROLE) VALUES (? ,? ,? ,? ,?)";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setToStatement(user, preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM USERS";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setPassword(resultSet.getString(3));
                user.setEmail(resultSet.getString(4));
                user.setPhone(resultSet.getString(5));

                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public User getUserByName(String name) {
        String sql = "SELECT * FROM USERS WHERE NAME=?";
        User user = null;
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
               user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT * FROM USERS WHERE EMAIL=?";
        User user = null;
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public User getById(long id) {
        String sql = "SELECT * FROM USERS WHERE ID=?";
        User user = null;
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }


    public void update(User user, Long id) {
        String sql = "UPDATE USERS SET NAME=?, PASSWORD=?, EMAIL=?, PHONE=? WHERE ID=?";

        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPhone());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void remove(Long id) {
        String sql = "DELETE FROM USERS WHERE ID=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void setToStatement(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPhone());
        preparedStatement.setString(5, user.getUserRole().name());
    }

    private User setUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getLong(1));
        user.setName(resultSet.getString(2));
        user.setPassword(resultSet.getString(3));
        user.setEmail(resultSet.getString(4));
        user.setPhone(resultSet.getString(5));
        user.setUserRole(UserRole.valueOf(resultSet.getString(6)));
        return user;
    }

}
