package com.softserve.workoutmanager.service;


import com.softserve.workoutmanager.dao.UserDao;
import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;
import com.softserve.workoutmanager.service.validator.Validator;


public class UserService {
    UserDao userDao = new UserDao();

    public void registerUser(User user, String passwordRepeat) throws IllegalArgumentException {
        Validator.checkEmail(user.getEmail());
        Validator.checkName(user.getName());
        Validator.checkPassword(user.getPassword(), passwordRepeat);
        Validator.checkPhone(user.getPhone());
        user.setUserRole(UserRole.USER);

        userDao.create(user);
    }
}

