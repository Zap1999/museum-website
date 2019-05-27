package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.ExhibitDao;

import java.util.ArrayList;

public class TechniqueService {
    private static final ExhibitDao EXHIBIT_DAO = new ExhibitDao();

    public ArrayList<String> getAll(){
        ArrayList<String> techniques = EXHIBIT_DAO.getAllTechnique();
        if(techniques != null){
            return techniques;
        } else {
            throw new NullPointerException("exhibitDao.getAllTechnique() returned null");
        }
    }
}