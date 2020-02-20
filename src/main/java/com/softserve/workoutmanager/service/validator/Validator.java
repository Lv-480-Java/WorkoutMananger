package com.softserve.workoutmanager.service.validator;

import com.softserve.workoutmanager.dao.UserDao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    static UserDao userDao = new UserDao();

    public static void checkEmail(String email) throws IllegalArgumentException {
        String emailcheck = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern patternemail = Pattern.compile(emailcheck);
        Matcher matcheremail = patternemail.matcher(email);
        if (!(matcheremail.matches()&&userDao.getUserByEmail(email) == null)) {
            throw new IllegalArgumentException("Such email already exists");
        }
    }
    public static void checkName(String name) throws IllegalArgumentException {
        if (userDao.getUserByName(name) != null) {
            throw new IllegalArgumentException("Such name " + name + " already exists");
        }
    }

    public static void checkPassword(String password, String passwordRepeat) throws IllegalArgumentException {
        if (!(password.equals(passwordRepeat) && password.length() >= 6)) {
            throw new IllegalArgumentException("Passwords don't match");
        }
    }
    public static void checkPhone(String phone) throws IllegalArgumentException {
        String phonecheck = "^\\+\\d{12}$";
        Pattern patternphone = Pattern.compile(phonecheck);
        Matcher matcherephone = patternphone.matcher(phone);
        if (!matcherephone.matches()) {
            throw new IllegalArgumentException("Phone number is not correct (example +123456789012");
        }
    }


}
