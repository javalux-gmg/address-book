package ru.javalux.gmg.address_book.DAO;

import ru.javalux.gmg.address_book.DAO.entity.Country;
import ru.javalux.gmg.address_book.DAO.entity.Person;

import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public interface PersonDAO extends GenericDAO<Person> {

    public List<Person> getPersonsByCountry(Country country) throws DataAccessException;
}
