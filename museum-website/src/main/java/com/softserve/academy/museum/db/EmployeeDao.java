package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private Connection connection = MySQLConnection.getConnection();

    public Employee getEmplyeeById(int id) {
        String query = "SELECT * "
                + "FROM employee "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            Employee employee = new Employee();

            res.next();
            employee.setId(res.getInt(1));
            employee.setFirstname(res.getNString(2));
            employee.setLastname(res.getNString(3));
            employee.setPosition(Position.getPos(Integer.toString(res.getInt(4))));

            return employee;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getEmployeeById' employee dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Employee> getAll() {
        String query = "SELECT * FROM employee ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            ArrayList<Employee> list = new ArrayList<>();
            while (res.next()) {
                Employee employee = new Employee();
                employee.setId(res.getInt(1));
                employee.setFirstname(res.getNString(2));
                employee.setLastname(res.getNString(3));
                employee.setPosition(Position.getPosById(res.getInt(4)));
                list.add(employee);
            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' employee dao.");
            e.printStackTrace();
            return null;
        }

    }

    public void save(Employee employee) {
        String query = "INSERT INTO employee(id, firstname, lastname, position) "
                + "VALUES (?, ?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getFirstname());
            statement.setString(3, employee.getLastname());
            statement.setString(4, employee.getPosition().toString());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' employee dao.");
            e.printStackTrace();
        }
    }

    public void update(Employee employee) {
        String query = "UPDATE employee "
                + "SET firstname = ?, lastname = ?, position = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getFirstname());
            statement.setString(2, employee.getLastname());
            statement.setString(3, employee.getPosition().toString());
            statement.setInt(4, employee.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' employee dao.");
            e.printStackTrace();
        }
    }

    public void delete(Employee employee) {
        String query = "DELETE FROM employee "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, employee.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'delete' employee dao.");
            e.printStackTrace();
        }
    }

}
