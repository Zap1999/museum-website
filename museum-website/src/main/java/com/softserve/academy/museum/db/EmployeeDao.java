package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Position;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {


    public Employee get(int id) {


        return employees.get(id);
    }

    public List<Employee> getAll() {
        return employees;
    }

    public void save(Employee o) {
        employees.add(o);
    }

    public void update(Employee o, Object[] params) {
        o.setFirstname((String) params[0]);
        o.setLastname((String) params[1]);
        o.setPosition((Position) params[2]);
    }

    public void delete(Employee o) {

    }

}
