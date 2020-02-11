package com.softserve.workoutmanager.service.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator {
    public void checkPhone(String phone) throws IllegalArgumentException {
        String phonecheck = "^\\+\\d{12}$";
        Pattern patternphone = Pattern.compile(phonecheck);
        Matcher matcherephone = patternphone.matcher(phone);
        if (matcherephone.matches() == true) {
        } else {
            throw new IllegalArgumentException("Phone is not correct");
        }
    }
}
