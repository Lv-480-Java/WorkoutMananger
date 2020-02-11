package com.softserve.workoutmanager.service.validator;

import com.softserve.workoutmanager.dao.UserDao;

public class NameValidator {
    UserDao userDao = new UserDao();

    public void checkName(String name) throws IllegalArgumentException {
        if (userDao.getUserByName(name) != null) {
            throw new IllegalArgumentException("The " + name + " exists");
        }
    }

}
