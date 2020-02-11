package com.softserve.workoutmanager.service.validator;

public class PasswordValidator {
    public void checkPassword(String password, String passwordRepeat) throws IllegalArgumentException {
        if (!(password.equals(passwordRepeat) && password.length() >= 6)) {
            throw new IllegalArgumentException("Password is not matches");
        }
    }

}
