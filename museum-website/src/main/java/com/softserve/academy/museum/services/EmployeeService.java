package com.softserve.academy.museum.services;

import com.softserve.academy.museum.db.AuthorDao;
import com.softserve.academy.museum.db.EmployeeDao;
import com.softserve.academy.museum.entities.Author;
import com.softserve.academy.museum.entities.Employee;

import java.util.ArrayList;

public class EmployeeService {
    public static EmployeeDao employeeDao = new EmployeeDao();

    public ArrayList<Employee> getAllManagersOnHall(){
        ArrayList<Employee> employees = employeeDao.getAllManagersOnHall();
        if(employees != null){
            return employees;
        } else {
            throw new NullPointerException("authorDao.getAll() returned null");
        }
    }

}
