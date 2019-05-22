package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Excursion;
import com.softserve.academy.museum.entities.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExcursionDao {

    private Connection connection = MySQLConnection.getConnection();

    public Excursion getExcursionById(int id) {
        String query = "SELECT excursion.name, excursion.start, excursion.duration, employee.id,"
                + "employee.firstname, employee.lastname, position.name "
                + "FROM excursion join employee on excursion.employee_id = employee.id "
                + "join position on employee.position = position.id "
                + "WHERE excursion.id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet excursionData = statement.executeQuery();
            excursionData.next();

            Excursion excursion = new Excursion();
            Employee employee = new Employee();

            employee.setId(excursionData.getInt("employee.id"));
            employee.setFirstname(excursionData.getNString("employee.firstname"));
            employee.setLastname(excursionData.getNString("employee.lastname"));
            employee.setPosition(Position.getPos(excursionData.getNString("position.name")));

            excursion.setId(id);
            excursion.setStart(excursionData.getTimestamp("excursion.start").toString());
            excursion.setDuration(excursionData.getInt("excursion.duration"));
            excursion.setEmployee(employee);

            return excursion;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getExcursionById' excursion dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Excursion> getAll() {
        String query = "SELECT excursion.id, excursion.name, excursion.start, excursion.duration, "
                + "employee.id, employee.firstname, employee.lastname, position.name "
                + "FROM excursion join employee on excursion.employee_id = employee.id "
                + "join position on employee.position = position.id;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet excursionsData = statement.executeQuery();

            ArrayList<Excursion> list = new ArrayList<>();
            while (excursionsData.next()) {

                Excursion excursion = new Excursion();
                Employee employee = new Employee();

                employee.setId(excursionsData.getInt("employee.id"));
                employee.setFirstname(excursionsData.getNString("employee.firstname"));
                employee.setLastname(excursionsData.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(excursionsData.getNString("position.name")));

                excursion.setId(excursionsData.getInt("excursion.id"));
                excursion.setName(excursionsData.getNString("excursion.name"));
                excursion.setStart(excursionsData.getTimestamp("excursion.start").toString());
                excursion.setDuration(excursionsData.getInt("excursion.duration"));
                excursion.setEmployee(employee);

                list.add(excursion);

            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' excursion dao.");
            e.printStackTrace();
            return null;
        }
    }

    public void save(Excursion excursion) {
        String query = "INSERT INTO excursion(id, name, start, duration, employee_id) "
                + "VALUES (?, ?, ?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, excursion.getId());
            statement.setString(2, excursion.getName());
            statement.setString(3, excursion.getStart());
            statement.setInt(4, excursion.getDuration());
            statement.setInt(5, excursion.getEmployee().getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' excursion dao.");
            e.printStackTrace();
        }
    }

    public void update(Excursion excursion) {
        String query = "UPDATE excursion "
                + "SET name = ?, start = ?, duration = ?, employee_id = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, excursion.getName());
            statement.setString(2, excursion.getStart());
            statement.setInt(3, excursion.getDuration());
            statement.setInt(4, excursion.getEmployee().getId());
            statement.setInt(5, excursion.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' excursion dao.");
            e.printStackTrace();
        }
    }

    public void delete(Excursion excursion) {
        String query = "DELETE FROM excursion "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, excursion.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'delete' author dao.");
            e.printStackTrace();
        }
    }

}
