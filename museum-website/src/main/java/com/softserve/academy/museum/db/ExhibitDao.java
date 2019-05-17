package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Author;
import com.softserve.academy.museum.entities.Exhibit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExhibitDao {

    private Connection connection = MySQLConnection.getConnection();

    public Exhibit getExhibitById(int id) {
        String query = "SELECT * "
                + "FROM exhibit "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            Exhibit exhibit = new Exhibit();

            res.next();
            exhibit.setId(res.getInt(0));
            exhibit.setName(res.getNString(1));
            exhibit.setMaterial(res.getNString(2));
            exhibit.setTechnique(res.getNString(3));
            exhibit.setAuthor(new AuthorDao().getAuthorById(
                    res.getInt(4)));
            exhibit.setHall(new HallDao().getHallById(
                    res.getInt(5)));

            return exhibit;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAuthorById' author dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Exhibit> getAll() {
        String query = "SELECT * FROM exhibit ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            ArrayList<Exhibit> list = new ArrayList<>();
            while (res.next()) {
                Exhibit exhibit = new Exhibit();
                exhibit.setId(res.getInt(1));
                exhibit.setName(res.getNString(2));
                exhibit.setMaterial(res.getNString(3));
                exhibit.setTechnique(res.getNString(4));
                exhibit.setAuthor(
                        new AuthorDao().getAuthorById(res.getInt(5)));
                exhibit.setHall(
                        new HallDao().getHallById(res.getInt(6)));
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
