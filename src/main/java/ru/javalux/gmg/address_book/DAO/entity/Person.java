package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne
    private Street street;
    private String building;
    private String apartment;
    @ManyToMany(mappedBy = "parents")
    private Set<Child> children;


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

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
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
               ", country=" + street.getCity().getCountry() +
               ", city=" + street.getCity() +
               ", street=" + street +
               ", building=" + building +
               ", apartment=" + apartment;
    }
}
