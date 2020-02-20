package com.softserve.workoutmanager.service;

import com.softserve.workoutmanager.dao.UserDataDao;
import com.softserve.workoutmanager.entity.User;
import com.softserve.workoutmanager.entity.UserData;

import java.util.List;

public class UserDataService {
    UserDataDao userDataDao=new UserDataDao();

    public void addData(UserData userData){
        userDataDao.create(userData);
    }

    public List<UserData> getUserData(long id){
        return userDataDao.getAllUserDataById(id);
    }

    public void deleteData(Long id){
        userDataDao.remove(id);
    }

    public void updateUserData(UserData userData, Long id){
        userDataDao.update(userData,id);
    }

    public UserData getUserDataById(Long id){
        return userDataDao.getById(id);
    }
}
