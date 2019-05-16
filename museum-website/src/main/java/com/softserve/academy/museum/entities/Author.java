package com.softserve.academy.museum.entities;

import java.util.Objects;

/**
 * Pojo class for 'author' entity from database.
 *
 * @author Andrii Vashchenok
 */
public class Author {

    private String firstname;
    private String lastname;


    /**
     * Gets first name of an author.
     *
     * @return First name of an author.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets first name of an author.
     *
     * @param firstname First name of an author.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets last name of an author.
     *
     * @return Last name of an author.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets last name of an author.
     *
     * @param lastname Last name of an author.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    @Override
    public boolean equals(Object object) {

        if (object == this) {
            return true;
        } else if (!(object instanceof Author)) {
            return false;
        }

        Author author = (Author) object;

        return (author.firstname.equals(firstname))
                && (author.lastname.equals(lastname));
    }

}
