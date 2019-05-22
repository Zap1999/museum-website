package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExhibitDao {

    private Connection connection = MySQLConnection.getConnection();

    public Exhibit getExhibitById(int id) {
        String query = "SELECT exhibit.name, exhibit.material, "
                + "exhibit.technique, exhibit.image, author.id, author.firstname, author.lastname, "
                + "hall.id, hall.name, employee.id, employee.firstname, employee.lastname, position.name "
                + "FROM exhibit join author on exhibit.author_id = author.id "
                + "join hall on exhibit.hall_id = hall.id "
                + "join employee on hall.employee_id = employee.id "
                + "join position on employee.position = position.id "
                + "WHERE exhibit.id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet exhibitData = statement.executeQuery();
            exhibitData.next();

            Employee employee = new Employee();
            Author author = new Author();
            Hall hall = new Hall();
            Exhibit exhibit = new Exhibit();

            employee.setId(exhibitData.getInt("employee.id"));
            employee.setFirstname(exhibitData.getNString("employee.firstname"));
            employee.setLastname(exhibitData.getNString("employee.lastname"));
            employee.setPosition(Position.getPos(exhibitData.getNString("position.name")));

            hall.setId(exhibitData.getInt("hall.id"));
            hall.setName(exhibitData.getNString("hall.name"));
            hall.setEmployee(employee);

            author.setId(exhibitData.getInt("author.id"));
            author.setFirstname(exhibitData.getNString("author.firstname"));
            author.setLastname(exhibitData.getNString("author.lastname"));

            exhibit.setId(id);
            exhibit.setName(exhibitData.getNString("exhibit.name"));
            exhibit.setMaterial(exhibitData.getNString("exhibit.material"));
            exhibit.setTechnique(exhibitData.getNString("exhibit.technique"));
            exhibit.setAuthor(author);
            exhibit.setHall(hall);
            exhibit.setImage(exhibitData.getNString("exhibit.image"));

            return exhibit;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAuthorById' author dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Exhibit> getAll() {
        String query = "SELECT exhibit.id, exhibit.name, exhibit.material, "
                + "exhibit.technique, exhibit.image, author.id, author.firstname, author.lastname, "
                + "hall.id, hall.name, employee.id, employee.firstname, employee.lastname, position.name "
                + "FROM exhibit join author on exhibit.author_id = author.id "
                + "join hall on exhibit.hall_id = hall.id "
                + "join employee on hall.employee_id = employee.id "
                + "join position on employee.position = position.id ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet exhibitData = statement.executeQuery();

            ArrayList<Exhibit> list = new ArrayList<>();
            while (exhibitData.next()) {
                Employee employee = new Employee();
                Author author = new Author();
                Hall hall = new Hall();
                Exhibit exhibit = new Exhibit();

                employee.setId(exhibitData.getInt("employee.id"));
                employee.setFirstname(exhibitData.getNString("employee.firstname"));
                employee.setLastname(exhibitData.getNString("employee.lastname"));
                employee.setPosition(Position.getPos(exhibitData.getNString("position.name")));

                hall.setId(exhibitData.getInt("hall.id"));
                hall.setName(exhibitData.getNString("hall.name"));
                hall.setEmployee(employee);

                author.setId(exhibitData.getInt("author.id"));
                author.setFirstname(exhibitData.getNString("author.firstname"));
                author.setLastname(exhibitData.getNString("author.lastname"));

                exhibit.setId(exhibitData.getInt("exhibit.id"));
                exhibit.setName(exhibitData.getNString("exhibit.name"));
                exhibit.setMaterial(exhibitData.getNString("exhibit.material"));
                exhibit.setTechnique(exhibitData.getNString("exhibit.technique"));
                exhibit.setAuthor(author);
                exhibit.setHall(hall);
                exhibit.setImage(exhibitData.getNString("exhibit.image"));

                list.add(exhibit);
            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' author dao.");
            e.printStackTrace();
            return null;
        }
    }

    public void save(Exhibit exhibit) {
        String query = "INSERT INTO exhibit(id, name, material, technique, "
                + "author_id, hall_id) "
                + "VALUES (?, ?, ?, ?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, exhibit.getId());
            statement.setString(2, exhibit.getName());
            statement.setString(3, exhibit.getMaterial());
            statement.setString(4, exhibit.getTechnique());
            statement.setInt(5, exhibit.getAuthor().getId());
            statement.setInt(6, exhibit.getHall().getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' author dao.");
            e.printStackTrace();
        }
    }

    public void update(Exhibit exhibit) {
        String query = "UPDATE exhibit "
                + "SET name = ?, material = ?, technique = ?,"
                + "author_id = ?, hall_id = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, exhibit.getName());
            statement.setString(2, exhibit.getMaterial());
            statement.setString(3, exhibit.getTechnique());
            statement.setInt(4, exhibit.getAuthor().getId());
            statement.setInt(5, exhibit.getHall().getId());
            statement.setInt(6, exhibit.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' author dao.");
            e.printStackTrace();
        }
    }

    public void delete(Exhibit exhibit) {
        String query = "DELETE FROM exhibit "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, exhibit.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'delete' author dao.");
            e.printStackTrace();
        }
    }

}
