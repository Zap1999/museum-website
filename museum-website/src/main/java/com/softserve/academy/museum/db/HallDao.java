package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Employee;
import com.softserve.academy.museum.entities.Exhibit;
import com.softserve.academy.museum.entities.Hall;
import com.softserve.academy.museum.entities.Position;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HallDao {

    private Connection connection = MySQLConnection.getConnection();

    public Hall getHallById(int id) {
        String query = "SELECT hall.name, employee.id, employee.firstname, "
                + "employee.lastname, position.name "
                + "FROM hall join employee on hall.employee_id = employee.id "
                + "join position on employee.position = position.id "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet hallData = statement.executeQuery();
            hallData.next();

            Hall hall = new Hall();
            Employee employee = new Employee();

            employee.setId(hallData.getInt("employee.id"));
            employee.setFirstname(hallData.getNString("employee.firstname"));
            employee.setLastname(hallData.getNString("employee.lastname"));
            employee.setPosition(Position.getPos(hallData.getNString("position.name")));

            hall.setId(id);
            hall.setName(hallData.getNString("hall.name"));
            hall.setEmployee(employee);

            return hall;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getHallById' hall dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Hall> getAll() {
        String query = "SELECT hall.id, hall.name, employee.id, employee.firstname, "
                + "employee.lastname, position.name "
                + "FROM hall join employee on hall.employee_id = employee.id "
                + "join position on employee.position = position.id ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet hallData = statement.executeQuery();

            ArrayList<Hall> list = new ArrayList<>();
            while (hallData.next()) {

                Hall hall = new Hall();
                Employee employee = new Employee();

                employee.setId(hallData.getInt("employee.id"));
                employee.setFirstname(hallData.getNString("employee.firstname"));
                employee.setLastname(hallData.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(hallData.getNString("position.name")));

                hall.setId(hallData.getInt("hall.id"));
                hall.setName(hallData.getNString("hall.name"));
                hall.setEmployee(employee);

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
