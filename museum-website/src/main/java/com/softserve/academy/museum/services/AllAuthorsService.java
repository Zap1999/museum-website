package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.AuthorDao;
import com.softserve.academy.museum.entities.Author;

import java.util.ArrayList;

public class AllAuthorsService {
    public static AuthorDao authorDao = new AuthorDao();

    public ArrayList<Author> getAll(){
        ArrayList<Author> exhibits = authorDao.getAll();
        if(exhibits != null){
            return exhibits;
        } else {
            throw new NullPointerException("authorDao.getAll() returned null");
        }
    }
}
