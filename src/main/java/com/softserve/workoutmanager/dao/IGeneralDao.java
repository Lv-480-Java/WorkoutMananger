package com.softserve.workoutmanager.dao;

import java.util.List;

public interface IGeneralDao<T> {
    //create
    void create(T t);

    //read
    List<T> getAll();

    T getById(long id);

    //update
    void update(T t);

    //delete
    void remove(T t);
}
