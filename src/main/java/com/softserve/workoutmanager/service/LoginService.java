package com.softserve.workoutmanager.service;

import com.softserve.workoutmanager.dao.UserDao;
import com.softserve.workoutmanager.entity.User;

public class LoginService {
    UserDao userDao = new UserDao();

    public User isUserExists(String name, String password) throws IllegalArgumentException {

        User user = userDao.getUserByName(name);

        if (user == null) {
            throw new IllegalArgumentException("The user "+name+" doesn't exist");
        }

        boolean correctPassword = (user.getPassword().equals(password));
        if (!correctPassword) {
            throw new IllegalArgumentException("Password is not correct");
        }

        return user;
    }
}
