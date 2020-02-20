package com.softserve.workoutmanager.entity;

import java.sql.Timestamp;
import java.util.Objects;

public class UserData {
    private long id;
    private double weigh;
    private double height;
    private double percentOfFat;
    private double percentOfMuscle;
    private Timestamp createData;
    private long User_id;

    public UserData() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPercentOfFat() {
        return percentOfFat;
    }

    public void setPercentOfFat(double percentOfFat) {
        this.percentOfFat = percentOfFat;
    }

    public double getPercentOfMuscle() {
        return percentOfMuscle;
    }

    public void setPercentOfMuscle(double percentOfMuscle) {
        this.percentOfMuscle = percentOfMuscle;
    }

    public Timestamp getCreateData() {
        return createData;
    }

    public void setCreateData(Timestamp createData) {
        this.createData = createData;
    }

    public long getUser_id() {
        return User_id;
    }

    public void setUser_id(long user_id) {
        User_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData userData = (UserData) o;
        return id == userData.id &&
                Double.compare(userData.weigh, weigh) == 0 &&
                Double.compare(userData.height, height) == 0 &&
                Double.compare(userData.percentOfFat, percentOfFat) == 0 &&
                Double.compare(userData.percentOfMuscle, percentOfMuscle) == 0 &&
                User_id == userData.User_id &&
                Objects.equals(createData, userData.createData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, weigh, height, percentOfFat, percentOfMuscle, createData, User_id);
    }

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", weigh=" + weigh +
                ", height=" + height +
                ", percentOfFat=" + percentOfFat +
                ", percentOfMuscle=" + percentOfMuscle +
                ", createData=" + createData +
                ", User_id=" + User_id +
                '}';
    }
}
