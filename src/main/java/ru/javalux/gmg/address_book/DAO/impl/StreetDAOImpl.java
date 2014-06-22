package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.StreetDAO;
import ru.javalux.gmg.address_book.DAO.entity.Street;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class StreetDAOImpl extends GenericDAOImpl<Street> implements StreetDAO {

    public StreetDAOImpl(EntityManager entityManager) {
        super(entityManager, Street.class);
    }
}
