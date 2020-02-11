package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.Category;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.workoutmanager.tool.connection.DatabaseConnection.getConnection;

public class CategoryDao implements IGeneralDao<Category> {
    private static Logger logger = Logger.getLogger(CategoryDao.class.getName());

    @Override
    public void create(Category category) {
        String sql = "INSERT INTO CATEGORY (ID, NAME) VALUES (? ,? ,? ,? ,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, category.getId());
            preparedStatement.setString(2, category.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoriesList = new ArrayList<>();
        String sql = "SELECT ID,NAME FROM CATEGORY";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Category category = new Category();
                category.setId(resultSet.getLong(1));
                category.setName(resultSet.getString(2));


                categoriesList.add(category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoriesList;
    }

    @Override
    public Category getById(long id) {
        String sql = "SELECT ID,NAME FROM CATEGORY WHERE ID=?";
        Category category = new Category();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            category.setId(resultSet.getLong(1));
            category.setName(resultSet.getString(2));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE CATEGORY SET ID=?, NAME=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, category.getId());
            preparedStatement.setString(2, category.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Category category) {
        String sql = "DELETE FROM CATEGORY WHERE ID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, category.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
