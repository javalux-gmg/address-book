package ru.javalux.gmg.address_book.DAO.impl;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public class BaseDAOTest {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;


    @Before
    public void setUp() throws Exception {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("addr_book_unit_test");
            entityManager = entityManagerFactory.createEntityManager();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
