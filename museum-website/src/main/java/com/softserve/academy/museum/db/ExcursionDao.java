package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Excursion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExcursionDao {

    private Connection connection = MySQLConnection.getConnection();

    public Excursion getExcursionById(int id) {
        String query = "SELECT * "
                + "FROM excursion "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            Excursion excursion = new Excursion();

            res.next();
            excursion.setId(Integer.parseInt(res.getNString(1)));
            excursion.setStart(res.getNString(2));
            excursion.setDuration(res.getInt(3));
            excursion.setEmployee(
                    new EmployeeDao().getEmplyeeById(res.getInt(4)));

            return excursion;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getExcursionById' excursion dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Excursion> getAll() {
        String query = "SELECT * FROM excursion ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            ArrayList<Excursion> list = new ArrayList<>();
            while (res.next()) {
                Excursion excursion = new Excursion();
                excursion.setId(res.getInt(1));
                excursion.setStart(res.getTimestamp(2).toString());
                excursion.setDuration(res.getInt(3));
                excursion.setEmployee(
                        new EmployeeDao().getEmplyeeById(res.getInt(4)));
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
        String query = "INSERT INTO excursion(id, start, duration, employee_id) "
                + "VALUES (?, ?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, excursion.getId());
            statement.setString(2, excursion.getStart());
            statement.setInt(3, excursion.getDuration());
            statement.setInt(4, excursion.getEmployee().getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' excursion dao.");
            e.printStackTrace();
        }
    }

    public void update(Excursion excursion) {
        String query = "UPDATE excursion "
                + "SET start = ?, duration = ?, employee_id = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, excursion.getStart());
            statement.setInt(2, excursion.getDuration());
            statement.setInt(3, excursion.getEmployee().getId());
            statement.setInt(4, excursion.getId());
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
