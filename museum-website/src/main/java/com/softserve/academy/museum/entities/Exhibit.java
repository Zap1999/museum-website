package com.softserve.academy.museum.entities;

/**
 * Pojo class for 'exhibit' entity from database.
 *
 * @author Andrii Vashchenok
 */
public class Exhibit {

    private String material;
    private String technique;
    private Author author;
    private Hall hall;


    /**
     * Gets material of an exhibit.
     *
     * @return String name of material.
     */
    public String getMaterial() {
        return material;
    }

    /**
     * Sets material of an exhibit.
     *
     * @param material String with the name of material.
     */
    public void setMaterial(String material) {
        this.material = material;
    }

    /**
     * Gets the name of technique.
     *
     * @return String with the name fo technique.
     */
    public String getTechnique() {
        return technique;
    }


    /**
     * Sets the name of technique.
     *
     * @param technique String with the name of technique.
     */
    public void setTechnique(String technique) {
        this.technique = technique;
    }

    /**
     * Gets the author of an exhibit.
     *
     * @return Author object.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of an exhibit.
     *
     * @param author Author object.
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Gets the hall where exhibit is situated.
     *
     * @return Hall object.
     */
    public Hall getHall() {
        return hall;
    }

    /**
     * Sets the hall where exhibit is situated.
     *
     * @param hall Hall object.
     */
    public void setHall(Hall hall) {
        this.hall = hall;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        } else if (!(object instanceof Exhibit)) {
            return false;
        }

        Exhibit exhibit = (Exhibit) object;

        return (exhibit.material.equals(material))
                && (exhibit.technique.equals(technique))
                && (exhibit.author.equals(author)
                && (exhibit.hall.equals(hall)));
    }

}
