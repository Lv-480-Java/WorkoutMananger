package com.softserve.workoutmanager.dao;

import com.softserve.workoutmanager.entity.Schedule;
import com.softserve.workoutmanager.tool.connection.DatabaseConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ScheduleDao implements IGeneralDao<Schedule> {

    private static Logger logger = Logger.getLogger(ScheduleDao.class.getName());

    @Override
    public void create(Schedule schedule) {
        String sql = "INSERT INTO SCHEDULE (DATE, COMMENT, USERID) VALUES (? ,? ,?)";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, schedule.getDate());
            preparedStatement.setString(2, schedule.getComment());
            preparedStatement.setLong(3, schedule.getUserId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Schedule> getAll() {
        List<Schedule> schedulesList = new ArrayList<>();
        String sql = "SELECT * FROM SCHEDULE";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong(1));
                schedule.setDate(resultSet.getString(2));
                schedule.setComment(resultSet.getString(3));
                schedule.setUserId(resultSet.getLong(4));

                schedulesList.add(schedule);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedulesList;
    }
    public List<Schedule> getAllScheduleByUserId(Long id) {
        List<Schedule> schedulesList = new ArrayList<>();
        String sql = "SELECT * FROM SCHEDULE WHERE userId=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(resultSet.getLong(1));
                schedule.setDate(resultSet.getString(2));
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
        String sql = "SELECT * FROM SCHEDULE WHERE ID=?";
        Schedule schedule = new Schedule();
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            schedule.setId(resultSet.getLong(1));
            schedule.setDate(resultSet.getString(2));
            schedule.setComment(resultSet.getString(3));
            schedule.setUserId(resultSet.getLong(4));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    public Schedule getByDate(String date) {
        String sql = "SELECT * FROM SCHEDULE WHERE date=?";
        Schedule schedule = null;
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, date);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                schedule=new Schedule();
            schedule.setId(resultSet.getLong(1));
            schedule.setDate(resultSet.getString(2));
            schedule.setComment(resultSet.getString(3));
            schedule.setUserId(resultSet.getLong(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    @Override
    public void update(Schedule schedule) {
        String sql = "UPDATE SCHEDULE SET DATE=?, COMMENT=?, USERID=? WHERE ID=?";

        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {


            preparedStatement.setString(1, schedule.getDate());
            preparedStatement.setString(2, schedule.getComment());
            preparedStatement.setLong(3, schedule.getUserId());
            preparedStatement.setLong(4, schedule.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Long id) {
        String sql = "DELETE FROM SCHEDULE WHERE ID=?";
        try (Connection connection= DatabaseConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
