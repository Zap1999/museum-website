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
        String query = "SELECT employee.firstname, employee.lastname,"
                + " position.name "
                + "FROM employee join position on employee.position = position.id "
                + "WHERE employee.id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet employeeData = statement.executeQuery();
            employeeData.next();

            Employee employee = new Employee();

            employee.setId(id);
            employee.setFirstname(employeeData.getNString("employee.firstname"));
            employee.setLastname(employeeData.getNString("employee.lastname"));
            employee.setPosition(Position.getPos(employeeData.getNString("position.name")));

            return employee;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getEmployeeById' employee dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Employee> getAll() {
        String query = "SELECT employee.id, employee.firstname, employee.lastname," 
                + "position.name " 
                + "FROM employee join position on employee.position = position.id";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet employeesData = statement.executeQuery();

            ArrayList<Employee> list = new ArrayList<>();
            while (employeesData.next()) {

                Employee employee = new Employee();

                employee.setId(employeesData.getInt("employee.id"));
                employee.setFirstname(employeesData.getNString("employee.firstname"));
                employee.setLastname(employeesData.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(employeesData.getNString("position.name")));

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
