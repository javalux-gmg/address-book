package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.BuildingDAO;
import ru.javalux.gmg.address_book.DAO.entity.Building;

import javax.persistence.EntityManager;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class BuildingDAOImpl extends GenericDAOImpl<Building> implements BuildingDAO {

    public BuildingDAOImpl(EntityManager entityManager) {
        super(entityManager, Building.class);
    }
}
