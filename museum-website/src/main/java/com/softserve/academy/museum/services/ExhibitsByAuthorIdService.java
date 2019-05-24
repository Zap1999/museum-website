package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.ExhibitDao;
import com.softserve.academy.museum.entities.Exhibit;

import java.util.ArrayList;

public class ExhibitsByAuthorIdService {
    public static ExhibitDao exhibitDao = new ExhibitDao();

    public ArrayList<Exhibit> getByAuthorId(int authorId) {
        ArrayList<Exhibit> exhibits = exhibitDao.getByAuthorId(authorId);
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("exhibitDao.getByAuthorId(int authorId) returned null");
        }
    }
}
