package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
public abstract class Person {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne
    private Country country;
    @ManyToOne
    private City city;
    @ManyToOne
    private Street street;
    @ManyToOne
    private Building building;
    @ManyToOne
    private Apartment apartment;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }

        Person person = (Person) o;

        if (age != person.age) {
            return false;
        }
        if (id != person.id) {
            return false;
        }
        if (!apartment.equals(person.apartment)) {
            return false;
        }
        if (!building.equals(person.building)) {
            return false;
        }
        if (!city.equals(person.city)) {
            return false;
        }
        if (!country.equals(person.country)) {
            return false;
        }
        if (!firstName.equals(person.firstName)) {
            return false;
        }
        if (!lastName.equals(person.lastName)) {
            return false;
        }
        if (!street.equals(person.street)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + age;
        result = 31 * result + country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + building.hashCode();
        result = 31 * result + apartment.hashCode();
        return result;
    }

    @Override
    public String toString() {

        return "Person{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", age=" + age +
               ", country=" + country +
               ", city=" + city +
               ", street=" + street +
               ", building=" + building +
               ", apartment=" + apartment;
    }
}
