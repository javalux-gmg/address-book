package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Apartment {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private Building building;


    public Apartment() {

    }

    public Apartment(String name, Building building) {

        this.name = name;
        this.building = building;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Apartment)) {
            return false;
        }

        Apartment apartment = (Apartment) o;

        if (id != apartment.id) {
            return false;
        }
        if (!building.equals(apartment.building)) {
            return false;
        }
        if (!name.equals(apartment.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + building.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "Apartment{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", building=" + building +
               '}';
    }
}
