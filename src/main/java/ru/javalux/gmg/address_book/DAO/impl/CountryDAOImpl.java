package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.CountryDAO;
import ru.javalux.gmg.address_book.DAO.entity.Country;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class CountryDAOImpl extends GenericDAOImpl<Country> implements CountryDAO {

    public CountryDAOImpl(EntityManager entityManager) {
        super(entityManager, Country.class);
    }
}
