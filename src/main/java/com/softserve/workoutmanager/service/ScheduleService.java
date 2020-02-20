package com.softserve.workoutmanager.service;

import com.softserve.workoutmanager.dao.ScheduleDao;
import com.softserve.workoutmanager.entity.Schedule;

import java.util.List;

public class ScheduleService {
    ScheduleDao scheduleDao=new ScheduleDao();

    public void addSchedule(Schedule schedule){
        scheduleDao.create(schedule);
    }

    public Schedule getSchedulebyDate(String date){
        return scheduleDao.getByDate(date);

    }

    public List<Schedule> getallUserSchedule(Long id){
       return scheduleDao.getAllScheduleByUserId(id);
    }

    public void deleteSchedule(Long id){
        scheduleDao.remove(id);
    }
}
