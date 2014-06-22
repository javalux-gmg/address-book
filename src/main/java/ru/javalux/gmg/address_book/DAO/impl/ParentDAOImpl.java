package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.ParentDAO;
import ru.javalux.gmg.address_book.DAO.entity.Parent;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class ParentDAOImpl extends GenericDAOImpl<Parent> implements ParentDAO {

    public ParentDAOImpl(EntityManager entityManager) {
        super(entityManager, Parent.class);
    }
}
