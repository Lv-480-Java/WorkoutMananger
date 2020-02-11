package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.workoutmanager.tool.connection.DatabaseConnection.getConnection;

public class UserDao implements IGeneralDao<User> {

    private static Logger logger = Logger.getLogger(UserDao.class.getName());

    @Override
    public void create(User user) {
        if (user.getUserRole() == null) {
            user.setUserRole(UserRole.USER);
        }
        String sql = "INSERT INTO USERS (NAME, PASSWORD, EMAIL, PHONE, USERROLE) VALUES (? ,? ,? ,? ,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setToStatement(user, preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT ID,NAME,PASSWORD,EMAIL,PHONE,USERROLE FROM USERS";
        try (Connection connection = getConnection();
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
        String sql = "SELECT ID,NAME,PASSWORD,EMAIL,PHONE,USERROLE FROM USERS WHERE NAME=?";
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserByEmail(String email) {
        String sql = "SELECT ID,NAME,PASSWORD,EMAIL,PHONE,USERROLE FROM USERS WHERE EMAIL=?";
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getById(long id) {
        String sql = "SELECT ID,NAME,PASSWORD,EMAIL,PHONE,USERROLE FROM USERS WHERE ID=?";
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User();
                user = setUser(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void update(User user) {
        if (user.getUserRole() == null) {
            user.setUserRole(UserRole.USER);
        }
        String sql = "UPDATE USERS SET ID=?, NAME=?, PASSWORD=?, EMAIL=?, PHONE=?,USERROLE=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            setToStatement(user, preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(User user) {
        String sql = "DELETE FROM USERS WHERE ID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, user.getId());
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
