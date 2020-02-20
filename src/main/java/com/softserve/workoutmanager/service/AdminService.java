package com.softserve.workoutmanager.service;

import com.softserve.workoutmanager.dao.UserDao;
import com.softserve.workoutmanager.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    UserDao userDao=new UserDao();

    public List<User> getAllUser() {
        return userDao.getAll();
    }

    public void update(User user,Long id){
        userDao.update(user,id);
    }

    public void removeUser(Long id){
        userDao.remove(id);
    }

    public User readByid(Long id){
        return userDao.getById(id);
    }
}
