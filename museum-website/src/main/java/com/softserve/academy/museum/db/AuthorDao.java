package com.softserve.academy.museum.db;

import com.softserve.academy.museum.entities.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class AuthorDao {

    public Author getAuthorById(int id) {
        Connection connection = MySQLConnection.getConnection();
        PreparedStatement statement = connection.createStatement();
        String query = "SELECT id, firstname, lastname "
                + "FROM author "
                + "WHERE id=?;";
    }

    public List<Author> getAll() {
        return authors;
    }

    public void save(Author o) {
        authors.add(o);
    }

    public void update(Author o, String[] params) {
        o.setFirstname(params[0]);
        o.setLastname(params[1]);
    }

    public void delete(Author o) {
        authors.remove(o);
    }

}
