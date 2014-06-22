package ru.javalux.gmg.address_book.service.impl;

import ru.javalux.gmg.address_book.DAO.entity.*;
import ru.javalux.gmg.address_book.service.AddressBookService;

import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class AddressBookServiceImpl implements AddressBookService {

    @Override
    public List<Person> findPersonsByCountry(Country country) {

        return null;
    }

    @Override
    public List<Person> findPersonsByCity(City City) {

        return null;
    }

    @Override
    public List<Person> findPersonsByStreet(Street street) {

        return null;
    }

    @Override
    public List<Person> findParentsOfChild(Child child) {

        return null;
    }

    @Override
    public List<Child> findChildrenOfPerson(Person person) {

        return null;
    }

    @Override
    public List<Child> findChildrenByStreet(Street street) {

        return null;
    }

    @Override
    public List<Street> findStreetsByCity(City city) {

        return null;
    }
}
