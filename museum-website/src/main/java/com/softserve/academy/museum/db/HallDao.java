package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Exhibit;
import com.softserve.academy.museum.entities.Hall;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HallDao {

    private Connection connection = MySQLConnection.getConnection();

    public Hall getHallById(int id) {
        String query = "SELECT * "
                + "FROM hall "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            Hall hall = new Hall();

            res.next();
            hall.setId(res.getInt(0));
            hall.setName(res.getNString(1));
            hall.setEmployee(
                    new EmployeeDao().getEmplyeeById(res.getInt(2)));

            return hall;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getHallById' hall dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Hall> getAll() {
        String query = "SELECT * FROM hall ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            ArrayList<Hall> list = new ArrayList<>();
            while (res.next()) {
                Hall hall = new Hall();
                hall.setId(res.getInt(0));
                hall.setName(res.getNString(1));
                hall.setEmployee(
                        new EmployeeDao().getEmplyeeById(res.getInt(2)));
                list.add(hall);
            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' hall dao.");
            e.printStackTrace();
            return null;
        }
    }

    public void save(Hall hall) {
        String query = "INSERT INTO hall(id, name, employee_id) "
                + "VALUES (?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hall.getId());
            statement.setString(2, hall.getName());
            statement.setInt(3, hall.getEmployee().getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' hall dao.");
            e.printStackTrace();
        }
    }

    public void update(Hall hall) {
        String query = "UPDATE hall "
                + "SET name = ?, employee_id = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, hall.getName());
            statement.setInt(2, hall.getEmployee().getId());
            statement.setInt(3, hall.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' hall dao.");
            e.printStackTrace();
        }
    }

    public void delete(Hall hall) {
        String query = "DELETE FROM hall "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, hall.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'delete' hall dao.");
            e.printStackTrace();
        }
    }

}
