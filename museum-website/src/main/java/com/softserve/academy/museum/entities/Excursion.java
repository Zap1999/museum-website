package com.softserve.academy.museum.entities;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Pojo class for 'excursion' entity from database.
 *
 * @author Andrii Vashchenok
 */
public class Excursion {

    private String name;
    private int id;
    private LocalDateTime start;
    private Employee employee;
    private int duration;


    /**
     * Gets id of an excursion.
     *
     * @return Integer id.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id of an excursion.
     *
     * @param id Integer id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets date and time of an excursion start.
     *
     * @return String with date and time of the start.
     */
    public LocalDateTime getStart() {
        return start;
    }

    /**
     * Sets date and time of an excursion.
     *
     * @param start String with date and time of the start.
     */
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee with guide position for an excursion.
     *
     * @param employee Employee (guide) for an excursion.
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets a duration for current excursion.
     *
     * @return Integer value of duration in minutes.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets a duration for current excursion.
     *
     * @param duration Integer value of duration in minutes.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, employee, duration);
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Excursion)) {
            return false;
        }

        Excursion excursion = (Excursion) object;

        return (excursion.start.equals(start))
                && (excursion.employee.equals(employee))
                && (excursion.duration == duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
