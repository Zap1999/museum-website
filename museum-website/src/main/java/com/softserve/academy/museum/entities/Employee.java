package com.softserve.academy.museum.entities;

import java.util.Objects;

/**
 * Pojo class for 'employee' entity from database.
 *
 * @author Andrii Vashchenok
 */
public class Employee {

    private String firstname;
    private String lastname;
    private Position position;


    /**
     * Gets first name of an employee.
     *
     * @return First name of an employee.
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * Sets first name of an employee.
     *
     * @param firstname First name of an employee.
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * Gets last name of an employee.
     *
     * @return Last name of an employee.
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets last name of an employee.
     *
     * @param lastname Last name of an employee.
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets position of an employee.
     *
     * @return Enum with position of an employee.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets position of an employee.
     *
     * @param position Enum with position of an employee.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, position);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) object;

        return (employee.firstname.equals(firstname))
                && (employee.lastname.equals(lastname))
                && (employee.position.equals(position));
    }

}
