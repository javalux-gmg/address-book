package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Street {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private City city;


    public Street() {

    }

    public Street(String name, City city) {

        this.name = name;
        this.city = city;
    }


    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public City getCity() {

        return city;
    }

    public void setCity(City city) {

        this.city = city;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Street)) {
            return false;
        }

        Street street = (Street) o;

        if (id != street.id) {
            return false;
        }
        if (!city.equals(street.city)) {
            return false;
        }
        if (!name.equals(street.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + city.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "Street{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", city=" + city +
               '}';
    }
}
