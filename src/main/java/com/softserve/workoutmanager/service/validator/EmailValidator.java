package com.softserve.workoutmanager.service.validator;

import com.softserve.workoutmanager.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    UserDao userDao = new UserDao();

    public void checkEmail(String email) throws IllegalArgumentException {
        String emailcheck = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern patternemail = Pattern.compile(emailcheck);
        Matcher matcheremail = patternemail.matcher(email);
        if (!(matcheremail.matches() && userDao.getUserByEmail(email) == null)) {
            throw new IllegalArgumentException(" The email exists");
        }
    }
}
