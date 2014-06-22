package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Building {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private Street street;


    public Building() {

    }

    public Building(String name, Street street) {

        this.name = name;
        this.street = street;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Building)) {
            return false;
        }

        Building building = (Building) o;

        if (id != building.id) {
            return false;
        }
        if (!name.equals(building.name)) {
            return false;
        }
        if (!street.equals(building.street)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + street.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "Building{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", street=" + street +
               '}';
    }
}
