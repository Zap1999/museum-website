package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.ExhibitDao;
import com.softserve.academy.museum.entities.Exhibit;

import java.util.ArrayList;

public class ExhibitService {
    private static final ExhibitDao EXHIBIT_DAO = new ExhibitDao();

    public ArrayList<Exhibit> getAll(){
        ArrayList<Exhibit> exhibits = EXHIBIT_DAO.getAll();
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("exhibitDao.getAll() returned null");
        }
    }

    public ArrayList<Exhibit> getByAuthorId(int authorId) {
        ArrayList<Exhibit> exhibits = EXHIBIT_DAO.getByAuthorId(authorId);
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("exhibitDao.getByAuthorId(int authorId) returned null");
        }
    }

    public ArrayList<Exhibit> getByHallId(int hallId){
        ArrayList<Exhibit> exhibits = EXHIBIT_DAO.getByHallId(hallId);
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("exhibitDao.getByAuthorId(int hallId) returned null");
        }
    }

    public ArrayList<Exhibit> getByMaterial(String material){
        ArrayList<Exhibit> exhibits = EXHIBIT_DAO.getByMaterial(material);
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("exhibitDao.getByMaterial(String material) returned null");
        }
    }
}
