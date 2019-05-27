package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.HallDao;
import com.softserve.academy.museum.entities.Hall;

import java.util.ArrayList;

public class HallService {
    private static final HallDao HALL_DAO = new HallDao();

    public ArrayList<Hall> getAll(){
        ArrayList<Hall> halls = HALL_DAO.getAll();
        if(halls != null){
            return halls;
        } else {
            throw new NullPointerException("hallDao.getAll() returned null");
        }
    }
}
