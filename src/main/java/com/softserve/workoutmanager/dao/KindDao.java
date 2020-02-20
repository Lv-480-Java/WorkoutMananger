package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.Kind;
import com.softserve.workoutmanager.tool.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class KindDao implements IGeneralDao<Kind> {

    private static Logger logger = Logger.getLogger(KindDao.class.getName());

    @Override
    public void create(Kind kind) {
        String sql = "INSERT INTO KIND (NAME, scheduleId) VALUES (? ,?)";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, kind.getName());
            preparedStatement.setLong(2, kind.getScheduleId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Kind> getAll() {
        List<Kind> kindList = new ArrayList<>();
        String sql = "SELECT * FROM KIND";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Kind kind = new Kind();
                kind.setId(resultSet.getLong(1));
                kind.setName(resultSet.getString(2));
                kind.setScheduleId(resultSet.getLong(3));

                kindList.add(kind);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kindList;
    }

    @Override
    public Kind getById(long id) {
        String sql = "SELECT * FROM KIND WHERE ID=?";
        Kind kind = new Kind();
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            kind.setId(resultSet.getLong(1));
            kind.setName(resultSet.getString(2));
            kind.setScheduleId(resultSet.getLong(3));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kind;
    }

    @Override
    public void update(Kind kind) {
        String sql = "UPDATE KIND SET NAME=?, scheduleId=? WHERE ID=?";

        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, kind.getName());
            preparedStatement.setLong(2, kind.getScheduleId());
            preparedStatement.setLong(3, kind.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM KIND WHERE ID=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
