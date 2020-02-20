package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserData;
import com.softserve.workoutmanager.tool.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDataDao {

    private static Logger logger = Logger.getLogger(UserDataDao.class.getName());

    public void create(UserData userData) {
        String sql = "INSERT INTO USERDATA (USERID, WEIGHT, HEIGHT, PERCENTOFFAT, PERCENTOFMUSCLE, CREATEDATA) VALUES (? ,? ,? ,? ,?,CURRENT_TIMESTAMP)";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1,userData.getUser_id());
            preparedStatement.setDouble(2, userData.getWeigh());
            preparedStatement.setDouble(3, userData.getHeight());
            preparedStatement.setDouble(4, userData.getPercentOfFat());
            preparedStatement.setDouble(5, userData.getPercentOfMuscle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<UserData> getAllUserDataById(Long id) {
        List<UserData> userDataList = new ArrayList<>();
        String sql = "SELECT * FROM USERDATA where userId=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserData userData = new UserData();

                userData.setId(resultSet.getLong(1));
                userData.setUser_id(resultSet.getLong(2));
                userData.setWeigh(resultSet.getDouble(3));
                userData.setHeight(resultSet.getDouble(4));
                userData.setPercentOfFat(resultSet.getDouble(5));
                userData.setPercentOfMuscle(resultSet.getDouble(6));
                userData.setCreateData(resultSet.getTimestamp(7));

                userDataList.add(userData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDataList;
    }
    public List<UserData> getAll() {
        List<UserData> userDataList = new ArrayList<>();
        String sql = "SELECT * FROM USERDATA";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UserData userData = new UserData();

                userData.setId(resultSet.getLong(1));
                userData.setUser_id(resultSet.getLong(2));
                userData.setWeigh(resultSet.getDouble(3));
                userData.setHeight(resultSet.getDouble(4));
                userData.setPercentOfFat(resultSet.getDouble(5));
                userData.setPercentOfMuscle(resultSet.getDouble(6));
                userData.setCreateData(resultSet.getTimestamp(7));

                userDataList.add(userData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userDataList;
    }


    public UserData getById(long id) {
        String sql = "SELECT * FROM USERDATA WHERE ID=?";
        UserData userData = new UserData();
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userData.setId(resultSet.getLong(1));
                userData.setUser_id(resultSet.getLong(2));
                userData.setWeigh(resultSet.getDouble(3));
                userData.setHeight(resultSet.getDouble(4));
                userData.setPercentOfFat(resultSet.getDouble(5));
                userData.setPercentOfMuscle(resultSet.getDouble(6));
                userData.setCreateData(resultSet.getTimestamp(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    public void update(UserData userData, Long id) {
        String sql = "UPDATE USERDATA SET USERID=?, WEIGHT=?, HEIGHT=?, PERCENTOFFAT=?, PERCENTOFMUSCLE=?, CREATEDATA=? WHERE ID=?";

        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, userData.getUser_id());
            preparedStatement.setDouble(2, userData.getWeigh());
            preparedStatement.setDouble(3, userData.getHeight());
            preparedStatement.setDouble(4, userData.getPercentOfFat());
            preparedStatement.setDouble(5, userData.getPercentOfMuscle());
            preparedStatement.setTimestamp(6, userData.getCreateData());
            preparedStatement.setLong(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void remove(Long id) {
        String sql = "DELETE FROM USERDATA WHERE ID=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
