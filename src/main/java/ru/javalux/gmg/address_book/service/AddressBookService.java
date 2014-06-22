package ru.javalux.gmg.address_book.service;

import ru.javalux.gmg.address_book.DAO.entity.*;

import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public interface AddressBookService {

    List<Person> findPersonsByCountry(Country country);
    List<Person> findPersonsByCity(City City);
    List<Person> findPersonsByStreet(Street street);
    List<Person> findParentsOfChild(Child child);
    List<Child> findChildrenOfPerson(Person person);
    List<Child> findChildrenByStreet(Street street);
    List<Street> findStreetsByCity(City city);
}
