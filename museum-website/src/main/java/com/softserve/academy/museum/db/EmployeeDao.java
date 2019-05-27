package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Position;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeDao {

    private static final Logger LOGGER = Logger.getLogger(EmployeeDao.class);
    private Connection connection = MySQLConnection.getConnection();

    public Employee getEmplyeeById(int id) {
        String query = "SELECT employee.firstname, employee.lastname,"
                + " position.name, employee.image "
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
            employee.setImage(employeeData.getNString("employee.image"));

            return employee;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getEmployeeById' employee dao.");
            LOGGER.error("Cannot execute 'getEmployeeById' employee dao.", e);
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Employee> getAll() {
        String query = "SELECT employee.id, employee.firstname, employee.lastname," 
                + "position.name, employee.image "
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
                employee.setImage(employeesData.getNString("employee.image"));

                list.add(employee);

            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' employee dao.");
            LOGGER.error("Cannot execute 'getAll' employee dao.", e);
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
            LOGGER.error("Cannot execute 'save' employee dao.", e);
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
            LOGGER.error("Cannot execute 'update' employee dao.", e);
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
            LOGGER.error("Cannot execute 'delete' employee dao.", e);
            e.printStackTrace();
        }
    }

    public ArrayList<Employee> getByPosition(Position position) {

        String query = "SELECT employee.id, employee.firstname, employee.lastname, "
                + "position.name, employee.image "
                + "FROM employee join position on employee.position = position.id "
                + "WHERE position.name = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setNString(1, position.toString());
            ResultSet employees = statement.executeQuery();

            List<Employee> employeeList = new ArrayList<>();
            while(employees.next()) {
                Employee employee = new Employee();
                employee.setId(employees.getInt("employee.id"));
                employee.setFirstname(employees.getNString("employee.firstname"));
                employee.setLastname(employees.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(employees.getNString("position.name")));
                employee.setImage(employees.getNString("employee.image"));
                employeeList.add(employee);
            }

            return (ArrayList<Employee>) employeeList;
        } catch (SQLException e) {
            System.err.println("Getting employee list by postition failed.");
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Employee> getFreeGuides(LocalDateTime start, LocalDateTime end) {
        String query = "SELECT employee.id, employee.firstname, employee.lastname, position.name, "
                + "employee.image "
                + "FROM employee join position on employee.position = position.id "
                + "WHERE (position.name = 'guide') and "
                + "employee.id NOT IN ( "
                + "  select distinct employee.id "
                + "from employee join position on employee.position = position.id "
                + "join excursion on employee.id = excursion.employee_id "
                + "where  ( excursion.start between ? and ?) "
                + "or ( DATE_ADD(excursion.start, interval excursion.duration minute) "
                + "between ? and ?));";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setTimestamp(1, Timestamp.valueOf(start));
            statement.setTimestamp(2, Timestamp.valueOf(end));
            statement.setTimestamp(3, Timestamp.valueOf(start));
            statement.setTimestamp(4, Timestamp.valueOf(end));
            ResultSet guides = statement.executeQuery();

            List<Employee> guideList = new ArrayList<>();
            while(guides.next()) {

                Employee employee = new Employee();
                employee.setId(guides.getInt("employee.id"));
                employee.setFirstname(guides.getNString("employee.firstname"));
                employee.setLastname(guides.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(guides.getNString("position.name")));
                employee.setImage(guides.getNString("employee.image"));
                guideList.add(employee);

            }

            return (ArrayList<Employee>) guideList;
        } catch (SQLException e) {
            LOGGER.error("Getting free guides failed.", e);
            e.printStackTrace();
        }
        return null;
    }

    public int getWorkTime(int id, LocalDateTime start, LocalDateTime end) {

        String query = "SELECT SUM(excursion.duration) as s "
                + "FROM employee join excursion on employee.id = excursion.employee_id "
                + "WHERE employee.id = ? and excursion.start between ? and ?;";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setTimestamp(2, Timestamp.valueOf(start));
            statement.setTimestamp(3, Timestamp.valueOf(end));
            ResultSet workTime = statement.executeQuery();
            workTime.next();

            return workTime.getInt("s");

        } catch (SQLException e) {
            LOGGER.error("getWorkTime method sql failed", e);
            e.printStackTrace();
        }
        return -1;

    }

}
