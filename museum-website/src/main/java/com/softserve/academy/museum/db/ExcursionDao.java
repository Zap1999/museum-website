package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Excursion;
import com.softserve.academy.museum.entities.Position;
import org.apache.log4j.Logger;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ExcursionDao {

    private static final Logger LOGGER = Logger.getLogger(ExcursionDao.class);
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
            excursion.setStart(excursionData.getTimestamp("excursion.start").toLocalDateTime());
            excursion.setDuration(excursionData.getInt("excursion.duration"));
            excursion.setEmployee(employee);

            return excursion;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getExcursionById' excursion dao.");
            LOGGER.error("Cannot execute 'getExcursionById' excursion dao.", e);
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
                excursion.setStart(excursionsData.getTimestamp("excursion.start").toLocalDateTime());
                excursion.setDuration(excursionsData.getInt("excursion.duration"));
                excursion.setEmployee(employee);

                list.add(excursion);

            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' excursion dao.");
            LOGGER.error("Cannot execute 'getAll' excursion dao.", e);
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
            statement.setTimestamp(3, Timestamp.valueOf(excursion.getStart()));
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
            statement.setTimestamp(2, Timestamp.valueOf(excursion.getStart()));
            statement.setInt(3, excursion.getDuration());
            statement.setInt(4, excursion.getEmployee().getId());
            statement.setInt(5, excursion.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' excursion dao.");
            LOGGER.error("Cannot execute 'update' excursion dao.", e);
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
            LOGGER.error("Cannot execute 'delete' excursion dao.", e);
            e.printStackTrace();
        }
    }

    public ArrayList<Excursion> getAvailableExcursions(LocalDateTime start, LocalDateTime end) {
        String query = "SELECT excursion.id, excursion.start, excursion.duration, excursion.name, "
                + "employee.id, employee.firstname, employee.lastname, employee.image, position.name "
                + "FROM excursion join employee on excursion.employee_id = employee.id "
                + "join position on employee.position = position.id "
                + "WHERE excursion.start between ? and ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setTimestamp(1, Timestamp.valueOf(start));
            statement.setTimestamp(2, Timestamp.valueOf(end));
            ResultSet excursionRes = statement.executeQuery();

            List<Excursion> excursionList = new ArrayList<>();
            while(excursionRes.next()) {

                Excursion excursion = new Excursion();
                Employee employee = new Employee();

                employee.setId(excursionRes.getInt("employee.id"));
                employee.setFirstname(excursionRes.getNString("employee.firstname"));
                employee.setLastname(excursionRes.getNString("employee.lastname"));
                employee.setImage(excursionRes.getNString("employee.image"));
                employee.setPosition(Position.getPos(excursionRes.getNString("position.name")));

                excursion.setId(excursionRes.getInt("excursion.id"));
                excursion.setStart(excursionRes.getTimestamp("excursion.start").toLocalDateTime());
                excursion.setDuration(excursionRes.getInt("excursion.duration"));
                excursion.setEmployee(employee);
                excursion.setName(excursionRes.getNString("excursion.name"));

                excursionList.add(excursion);
            }

            return (ArrayList<Excursion>) excursionList;
        } catch (SQLException e) {
            System.err.println("Getting free guides failed.");
            e.printStackTrace();
        }
        return null;
    }

}
