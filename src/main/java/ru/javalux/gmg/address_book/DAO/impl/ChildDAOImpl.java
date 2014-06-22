package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.ChildDAO;
import ru.javalux.gmg.address_book.DAO.entity.Child;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class ChildDAOImpl extends GenericDAOImpl<Child> implements ChildDAO {

    public ChildDAOImpl(EntityManager entityManager) {
        super(entityManager, Child.class);
    }
}
