package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AuthorDao {

    private Connection connection = MySQLConnection.getConnection();

    public Author getAuthorById(int id) {
        String query = "SELECT * "
                + "FROM author "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet res = statement.executeQuery();
            Author author = new Author();

            res.next();
            author.setId(res.getInt(1));
            author.setFirstname(res.getNString(2));
            author.setLastname(res.getNString(3));

            return author;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAuthorById' author dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Author> getAll() {
        String query = "SELECT * FROM author ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet res = statement.executeQuery();

            ArrayList<Author> list = new ArrayList<>();
            while (res.next()) {
                Author author = new Author();
                author.setId(res.getInt(1));
                author.setFirstname(res.getNString(2));
                author.setLastname(res.getNString(3));
                list.add(author);
            }

            return list;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAll' author dao.");
            e.printStackTrace();
            return null;
        }
    }

    public void save(Author author) {
        String query = "INSERT INTO author(id, firstname, lastname) "
                + "VALUES (?, ?, ?) ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, author.getId());
            statement.setString(2, author.getFirstname());
            statement.setString(3, author.getLastname());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'save' author dao.");
            e.printStackTrace();
        }
    }

    public void update(Author author) {
        String query = "UPDATE author "
                + "SET firstname = ?, lastname = ? "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, author.getFirstname());
            statement.setString(2, author.getLastname());
            statement.setInt(3, author.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot 'update' author dao.");
            e.printStackTrace();
        }
    }

    public void delete(Author author) {
        String query = "DELETE FROM author "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, author.getId());
            statement.execute();

        } catch (SQLException e) {
            System.err.println("Cannot execute 'delete' author dao.");
            e.printStackTrace();
        }
    }

}
