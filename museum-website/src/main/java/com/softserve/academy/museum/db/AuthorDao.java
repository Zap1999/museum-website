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
        String query = "SELECT author.id, author.firstname, author.lastname "
                + "FROM author "
                + "WHERE id=?;";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet authorData = statement.executeQuery();
            authorData.next();

            Author author = new Author();

            author.setId(authorData.getInt("author.id"));
            author.setFirstname(authorData.getNString("author.firstname"));
            author.setLastname(authorData.getNString("author.lastname"));

            return author;

        } catch (SQLException e) {
            System.err.println("Cannot execute 'getAuthorById' author dao.");
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Author> getAll() {
        String query = "SELECT author.id, author.firstname, author.lastname "
                + "FROM author ";
        try {

            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet authorsData = statement.executeQuery();

            ArrayList<Author> list = new ArrayList<>();
            while (authorsData.next()) {

                Author author = new Author();

                author.setId(authorsData.getInt("author.id"));
                author.setFirstname(authorsData.getNString("author.firstname"));
                author.setLastname(authorsData.getNString("author.lastname"));

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
