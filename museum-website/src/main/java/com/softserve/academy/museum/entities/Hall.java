package com.softserve.academy.museum.entities;

import java.util.Objects;

public class Hall {

    private String name;
    private Employee employee;


    /**
     * Gets the name of the hall.
     *
     * @return String with the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the hall.
     *
     * @param name String the name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the employee with manager position
     * who is the manager of the hall.
     *
     * @return Employee object.
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets the employee with manager position
     * who is the manager of the hall.
     *
     * @param employee Employee object.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, employee);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Hall)) {
            return false;
        }

        Hall hall = (Hall) object;

        return (hall.name.equals(name))
                && (hall.employee.equals(employee));

    }

}
