package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class City {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @ManyToOne
    private Country country;


    public City() {

    }

    public City(String name, Country country) {

        this.name = name;
        this.country = country;
    }


    public Country getCountry() {

        return country;
    }

    public void setCountry(Country country) {

        this.country = country;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof City)) {
            return false;
        }

        City city = (City) o;

        if (id != city.id) {
            return false;
        }
        if (!country.equals(city.country)) {
            return false;
        }
        if (!name.equals(city.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "City{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", country=" + country +
               '}';
    }
}
