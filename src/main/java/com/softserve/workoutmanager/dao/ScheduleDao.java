package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.Schedule;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.softserve.workoutmanager.tool.connection.DatabaseConnection.getConnection;

public class ScheduleDao implements IGeneralDao<Schedule> {

    private static Logger logger = Logger.getLogger(ScheduleDao.class.getName());

    @Override
    public void create(Schedule schedule) {
        String sql = "INSERT INTO SCHEDULE (ID, DATE, COMMENT, USERID) VALUES (? ,? ,? ,?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, schedule.getId());
            preparedStatement.setTimestamp(2, schedule.getDate());
            preparedStatement.setString(3, schedule.getComment());
            preparedStatement.setLong(4, schedule.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> schedulesList = new ArrayList<>();
        String sql = "SELECT ID, DATE, COMMENT, USERID FROM SCHEDULE";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong(1));
                schedule.setDate(resultSet.getTimestamp(2));
                schedule.setComment(resultSet.getString(3));
                schedule.setUserId(resultSet.getLong(4));

                schedulesList.add(schedule);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedulesList;
    }

    @Override
    public Schedule getById(long id) {
        String sql = "SELECT ID, DATE, COMMENT, USERID FROM SCHEDULE WHERE ID=?";
        Schedule schedule = new Schedule();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            schedule.setId(resultSet.getLong(1));
            schedule.setDate(resultSet.getTimestamp(2));
            schedule.setComment(resultSet.getString(3));
            schedule.setUserId(resultSet.getLong(4));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public void update(Schedule schedule) {
        String sql = "UPDATE SCHEDULE SET ID=?, DATE=?, COMMENT=?, USERID=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, schedule.getId());
            preparedStatement.setTimestamp(2, schedule.getDate());
            preparedStatement.setString(3, schedule.getComment());
            preparedStatement.setLong(4, schedule.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Schedule schedule) {
        String sql = "DELETE FROM SCHEDULE WHERE ID=?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, schedule.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
