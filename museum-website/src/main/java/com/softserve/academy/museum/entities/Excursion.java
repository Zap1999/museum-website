package com.softserve.academy.museum.entities;

/**
 * Pojo class for 'excursion' entity from database.
 *
 * @author Andrii Vashchenok
 */
public class Excursion {

    private String start;
    private Employee employee;
    private int duration;


    /**
     * Gets date and time of an excursion start.
     *
     * @return String with date and time of the start.
     */
    public String getStart() {
        return start;
    }

    /**
     * Sets date and time of an excursion.
     *
     * @param start String with date and time of the start.
     */
    public void setStart(String start) {
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
        return super.hashCode();
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

}
