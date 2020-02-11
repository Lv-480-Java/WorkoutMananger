package com.softserve.workoutmanager.service;


import com.softserve.workoutmanager.dao.UserDao;
import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserRole;
import com.softserve.workoutmanager.service.validator.EmailValidator;
import com.softserve.workoutmanager.service.validator.NameValidator;
import com.softserve.workoutmanager.service.validator.PasswordValidator;
import com.softserve.workoutmanager.service.validator.PhoneValidator;

public class UserService {
    UserDao userDao = new UserDao();
    private EmailValidator emailValidator = new EmailValidator();
    private NameValidator nameValidator = new NameValidator();
    private PhoneValidator phoneValidator = new PhoneValidator();
    private PasswordValidator passwordValidator = new PasswordValidator();

    public void registerUser(User user, String passwordRepeat) throws IllegalArgumentException {

        nameValidator.checkName(user.getName());

        emailValidator.checkEmail(user.getEmail());

        phoneValidator.checkPhone(user.getPhone());

        passwordValidator.checkPassword(user.getPassword(), passwordRepeat);

        user.setUserRole(UserRole.USER);

        userDao.create(user);
    }
}

