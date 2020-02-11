package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.Kind;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.workoutmanager.tool.connection.DatabaseConnection.getConnection;

public class KindDao implements IGeneralDao<Kind> {

    private static Logger logger = Logger.getLogger(KindDao.class.getName());

    @Override
    public void create(Kind kind) {
        String sql = "INSERT INTO KIND (ID, NAME, CATEGORYID) VALUES (? ,? ,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, kind.getId());
            preparedStatement.setString(2, kind.getName());
            preparedStatement.setLong(3, kind.getCategoryId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Kind> getAll() {
        List<Kind> kindList = new ArrayList<>();
        String sql = "SELECT ID,NAME,CATEGORYID FROM KIND";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Kind kind = new Kind();
                kind.setId(resultSet.getLong(1));
                kind.setName(resultSet.getString(2));
                kind.setCategoryId(resultSet.getLong(3));

                kindList.add(kind);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kindList;
    }

    @Override
    public Kind getById(long id) {
        String sql = "SELECT ID,NAME,CATEGORYID FROM KIND WHERE ID=?";
        Kind kind = new Kind();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            kind.setId(resultSet.getLong(1));
            kind.setName(resultSet.getString(2));
            kind.setCategoryId(resultSet.getLong(3));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kind;
    }

    @Override
    public void update(Kind kind) {
        String sql = "UPDATE KIND SET ID=?, NAME=?, CATEGORYID=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, kind.getId());
            preparedStatement.setString(2, kind.getName());
            preparedStatement.setLong(3, kind.getCategoryId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Kind kind) {
        String sql = "DELETE FROM KIND WHERE ID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, kind.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
