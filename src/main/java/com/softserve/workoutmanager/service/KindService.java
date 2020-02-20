package com.softserve.workoutmanager.service;

import com.softserve.workoutmanager.dao.KindDao;
import com.softserve.workoutmanager.entity.Kind;

public class KindService {
    KindDao kindDao=new KindDao();

    public void addKind(Kind kind){
        kindDao.create(kind);
    }


}
