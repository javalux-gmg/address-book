package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.ApartmentDAO;
import ru.javalux.gmg.address_book.DAO.entity.Apartment;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class ApartmentDAOImpl extends GenericDAOImpl<Apartment> implements ApartmentDAO {

    public ApartmentDAOImpl(EntityManager entityManager) {
        super(entityManager, Apartment.class);
    }
}
