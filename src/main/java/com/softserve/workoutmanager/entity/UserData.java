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
    private long userId;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
                userId == userData.userId &&
                Objects.equals(createData, userData.createData);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, weigh, height, percentOfFat, percentOfMuscle, createData, userId);
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
                ", userId=" + userId +
                '}';
    }
}
