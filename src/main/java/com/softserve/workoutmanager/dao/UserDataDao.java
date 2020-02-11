package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.UserData;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.workoutmanager.tool.connection.DatabaseConnection.getConnection;

public class UserDataDao implements IGeneralDao<UserData> {

    private static Logger logger = Logger.getLogger(UserDataDao.class.getName());

    @Override
    public void create(UserData userData) {
        String sql = "INSERT INTO USERDATA (ID, USERID, WEIGHT, HEIGHT, PERCENTOFFAT, PERCENTOFMUSCLE, CREATEDATA) VALUES (? ,? ,? ,? ,? ,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userData.getId());
            preparedStatement.setLong(2, userData.getUserId());
            preparedStatement.setDouble(3, userData.getWeigh());
            preparedStatement.setDouble(4, userData.getHeight());
            preparedStatement.setDouble(5, userData.getPercentOfFat());
            preparedStatement.setDouble(6, userData.getPercentOfMuscle());
            preparedStatement.setTimestamp(7, userData.getCreateData());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<UserData> getAll() {
        List<UserData> userDataList = new ArrayList<>();
        String sql = "SELECT ID, USERID,WEIGHT,HEIGHT,PERCENTOFFAT,PERCENTOFMUSCLE,CREATEDATA FROM USERDATA";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UserData userData = new UserData();
                userData.setId(resultSet.getLong(1));
                userData.setUserId(resultSet.getLong(2));
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

    @Override
    public UserData getById(long id) {
        String sql = "SELECT ID, USERID,WEIGHT,HEIGHT,PERCENTOFFAT,PERCENTOFMUSCLE,CREATEDATA FROM USERDATA WHERE ID=?";
        UserData userData = new UserData();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            userData.setId(resultSet.getLong(1));
            userData.setUserId(resultSet.getLong(2));
            userData.setWeigh(resultSet.getDouble(3));
            userData.setHeight(resultSet.getDouble(4));
            userData.setPercentOfFat(resultSet.getDouble(5));
            userData.setPercentOfMuscle(resultSet.getDouble(6));
            userData.setCreateData(resultSet.getTimestamp(7));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userData;
    }

    @Override
    public void update(UserData userData) {
        String sql = "UPDATE USERDATA SET ID=?, USERID=?, WEIGHT=?, HEIGHT=?, PERCENTOFFAT=?, PERCENTOFMUSCLE=?, CREATEDATA=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, userData.getId());
            preparedStatement.setLong(2, userData.getUserId());
            preparedStatement.setDouble(3, userData.getWeigh());
            preparedStatement.setDouble(4, userData.getHeight());
            preparedStatement.setDouble(5, userData.getPercentOfFat());
            preparedStatement.setDouble(6, userData.getPercentOfMuscle());
            preparedStatement.setTimestamp(7, userData.getCreateData());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(UserData userData) {
        String sql = "DELETE FROM USERDATA WHERE ID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, userData.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
