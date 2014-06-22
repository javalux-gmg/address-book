package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.DataAccessException;
import ru.javalux.gmg.address_book.DAO.PersonDAO;
import ru.javalux.gmg.address_book.DAO.entity.Country;
import ru.javalux.gmg.address_book.DAO.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class PersonDAOImpl extends GenericDAOImpl<Person> implements PersonDAO {

    public PersonDAOImpl(EntityManager entityManager) {
        super(entityManager, Person.class);
    }

    @Override
    public List<Person> getPersonsByCountry(Country country) throws DataAccessException {

        try {
            Query query = entityManager.createQuery(
                    "SELECT entity FROM Person entity " +
                    "WHERE entity.country = :country ");
            query.setParameter("country", country);
            return (List<Person>) query.getResultList();

        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }
}
