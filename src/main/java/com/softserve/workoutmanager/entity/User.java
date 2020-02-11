package com.softserve.workoutmanager.entity;

import java.util.List;
import java.util.Objects;

public class User {
    private long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private UserRole userRole;
    private List<UserData> dataList;
    private List<Schedule> scheduleList;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public List<UserData> getDataList() {
        return dataList;
    }

    public void setDataList(List<UserData> dataList) {
        this.dataList = dataList;
    }

    public List<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                userRole == user.userRole &&
                Objects.equals(dataList, user.dataList) &&
                Objects.equals(scheduleList, user.scheduleList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, password, email, phone, userRole, dataList, scheduleList);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", userRole=" + userRole +
                ", dataList=" + dataList +
                ", scheduleList=" + scheduleList +
                '}';
    }
}