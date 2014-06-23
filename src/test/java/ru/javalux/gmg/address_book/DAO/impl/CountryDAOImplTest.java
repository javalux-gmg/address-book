package ru.javalux.gmg.address_book.DAO.impl;

import org.junit.Before;
import org.junit.Test;
import ru.javalux.gmg.address_book.DAO.CountryDAO;
import ru.javalux.gmg.address_book.DAO.entity.Country;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static org.junit.Assert.*;

public class CountryDAOImplTest extends BaseDAOTest {

    public static final String COUNTRYNAME_1 = "Russia";
    public static final String COUNTRYNAME_2 = "US";
    private CountryDAO countryDAO;


    @Before
    public void setUp() throws Exception {

        super.setUp();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query_delete_persons = entityManager.createNativeQuery("delete from Person");
        Query query_delete_streets = entityManager.createNativeQuery("delete from Street");
        Query query_delete_cities = entityManager.createNativeQuery("delete from City");
        Query query_delete_countries = entityManager.createNativeQuery("delete from Country");
        query_delete_persons.executeUpdate();
        query_delete_streets.executeUpdate();
        query_delete_cities.executeUpdate();
        query_delete_countries.executeUpdate();
        tx.commit();
        countryDAO = new CountryDAOImpl(entityManager);
    }

    @Test
    public void testGetAll() throws Exception {
        fail();
    }

    @Test
    public void testFind() throws Exception {

        Country country = new Country();
        country.setName(COUNTRYNAME_1);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        entityManager.getTransaction().commit();
        long id = country.getId();

        Country foundCountry = countryDAO.find(id);

        assertNotNull(foundCountry);
        assertEquals(country, foundCountry);
    }

    @Test
    public void testPersist() throws Exception {

        Country country = new Country();
        country.setName(COUNTRYNAME_1);

        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        entityManager.getTransaction().commit();

        long id = country.getId();
        Country persistedCountry = countryDAO.find(id);
        assertNotNull(persistedCountry);
        assertEquals(country, persistedCountry);
    }

    @Test
    public void testRefresh() throws Exception {
        fail();
    }

    @Test
    public void testUpdate() throws Exception {

        Country country = new Country();
        country.setName(COUNTRYNAME_1);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        entityManager.getTransaction().commit();
        long id = country.getId();
        country.setName(COUNTRYNAME_2);

        entityManager.getTransaction().begin();
        countryDAO.update(country);
        entityManager.getTransaction().commit();

        Country updatedCountry = countryDAO.find(id);
        assertNotNull(updatedCountry);
        assertEquals(country, updatedCountry);
    }

    @Test
    public void testDelete() throws Exception {

        Country country = new Country();
        country.setName(COUNTRYNAME_1);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        entityManager.getTransaction().commit();
        long id = country.getId();

        entityManager.getTransaction().begin();
        countryDAO.delete(country);
        entityManager.getTransaction().commit();

        Country deletedCountry = countryDAO.find(id);
        assertNull(deletedCountry);
    }

    @Test
    public void testDeleteAll() throws Exception {
        fail();
    }

    @Test
    public void testLockById() throws Exception {
        fail();
    }

    @Test
    public void testLockByIdRange() throws Exception {
        fail();
    }
}
