package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.CityDAO;
import ru.javalux.gmg.address_book.DAO.entity.City;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class CityDAOImpl extends GenericDAOImpl<City> implements CityDAO {

    public CityDAOImpl(EntityManager entityManager) {
        super(entityManager, City.class);
    }
}
