package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.ExhibitDao;

import java.util.ArrayList;

public class MaterialService {
    private static final ExhibitDao EXHIBIT_DAO = new ExhibitDao();

    public ArrayList<String> getAll(){
        ArrayList<String> materials = EXHIBIT_DAO.getAllMaterial();
        if(materials != null){
            return materials;
        } else {
            throw new NullPointerException("exhibitDao.getAllMaterial() returned null");
        }
    }
}
