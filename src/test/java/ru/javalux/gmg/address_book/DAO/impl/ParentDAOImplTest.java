package ru.javalux.gmg.address_book.DAO.impl;

import org.junit.Before;
import org.junit.Test;
import ru.javalux.gmg.address_book.DAO.*;
import ru.javalux.gmg.address_book.DAO.entity.*;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import static org.junit.Assert.*;

public class ParentDAOImplTest extends BaseDAOTest {

    public static final String FIRST_NAME_1 = "Audrey";
    public static final String FIRST_NAME_2 = "Nicole";
    public static final String FIRST_NAME_3 = "Scarlett";
    public static final String LAST_NAME_1 = "Hepburn";
    public static final String LAST_NAME_2 = "Kidman";
    public static final String LAST_NAME_3 = "Johansson";
    public static final int AGE_1 = 25;
    public static final int AGE_2 = 23;
    public static final int AGE_3 = 21;
    public static final String COUNTRY_NAME_1 = "Belguim";
    public static final String COUNTRY_NAME_2 = "Australia";
    public static final String COUNTRY_NAME_3 = "Sweden";
    public static final String CITY_NAME_1 = "Brugge";
    public static final String CITY_NAME_2 = "Sidney";
    public static final String CITY_NAME_3 = "Stockholm";
    public static final String STREET_NAME_1 = "First Street";
    public static final String STREET_NAME_2 = "Second Street";
    public static final String STREET_NAME_3 = "Third Street";
    public static final String BUILDING_NAME_1 = "1a";
    public static final String BUILDING_NAME_2 = "2b";
    public static final String BUILDING_NAME_3 = "3c";
    public static final String APARTMENT_NAME_1 = "111i";
    public static final String APARTMENT_NAME_2 = "222j";
    public static final String APARTMENT_NAME_3 = "333k";
    private ParentDAO parentDAO;
    private CountryDAO countryDAO;
    private CityDAO cityDAO;
    private StreetDAO streetDAO;
    private BuildingDAO buildingDAO;
    private ApartmentDAO apartmentDAO;


    @Before
    public void setUp() throws Exception {

        super.setUp();

        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        // TODO check on person removal cascade removal of corresponding child/parent relations
        Query del_all_persons_query = entityManager.createNativeQuery("delete from Person");
        del_all_persons_query.executeUpdate();
        Query del_all_parentchild_query = entityManager.createNativeQuery("delete from ParentChild");
        del_all_parentchild_query.executeUpdate();
        tx.commit();
        parentDAO = new ParentDAOImpl(entityManager);
        countryDAO = new CountryDAOImpl(entityManager);
        cityDAO = new CityDAOImpl(entityManager);
        streetDAO = new StreetDAOImpl(entityManager);
        buildingDAO = new BuildingDAOImpl(entityManager);
        apartmentDAO = new ApartmentDAOImpl(entityManager);
    }

    @Test
    public void testGetAll() throws Exception {
        fail();
    }

    private Parent createParent1() throws Exception {

        return createParent(FIRST_NAME_1, LAST_NAME_1, AGE_1, COUNTRY_NAME_1, CITY_NAME_1,
                            STREET_NAME_1, BUILDING_NAME_1, APARTMENT_NAME_1);
    }

    private Parent createParent2() throws Exception {

        return createParent(FIRST_NAME_2, LAST_NAME_2, AGE_2, COUNTRY_NAME_2, CITY_NAME_2,
                            STREET_NAME_2, BUILDING_NAME_2, APARTMENT_NAME_2);
    }

    private Child createChild3() throws Exception {

        return createChild(FIRST_NAME_3, LAST_NAME_3, AGE_3, COUNTRY_NAME_3, CITY_NAME_3,
                           STREET_NAME_3, BUILDING_NAME_3, APARTMENT_NAME_3);
    }

    private Parent createParent(String firstName, String lastName, int age, String countryName,
                                String cityName, String streetName, String buildingName,
                                String apartmentName) throws Exception {

        Country country = new Country(countryName);
        City city = new City(cityName, country);
        Street street = new Street(streetName, city);
        Building building = new Building(buildingName, street);
        Apartment apartment = new Apartment(apartmentName, building);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        cityDAO.persist(city);
        streetDAO.persist(street);
        buildingDAO.persist(building);
        apartmentDAO.persist(apartment);
        entityManager.getTransaction().commit();

        Parent parent = new Parent();
        parent.setFirstName(firstName);
        parent.setLastName(lastName);
        parent.setAge(age);
        parent.setCountry(country);
        parent.setCity(city);
        parent.setStreet(street);
        parent.setBuilding(building);
        parent.setApartment(apartment);

        return parent;
    }

    private Child createChild(String firstName, String lastName, int age, String countryName,
                              String cityName, String streetName, String buildingName,
                              String apartmentName) throws Exception {

        Country country = new Country(countryName);
        City city = new City(cityName, country);
        Street street = new Street(streetName, city);
        Building building = new Building(buildingName, street);
        Apartment apartment = new Apartment(apartmentName, building);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        cityDAO.persist(city);
        streetDAO.persist(street);
        buildingDAO.persist(building);
        apartmentDAO.persist(apartment);
        entityManager.getTransaction().commit();

        Child child = new Child();
        child.setFirstName(firstName);
        child.setLastName(lastName);
        child.setAge(age);
        child.setCountry(country);
        child.setCity(city);
        child.setStreet(street);
        child.setBuilding(building);
        child.setApartment(apartment);

        return child;
    }

    @Test
    public void testFind() throws Exception {

        Parent parent = createParent1();
        Child child = createChild3();
        parent.addChild(child);
        entityManager.getTransaction().begin();
        parentDAO.persist(parent);
        entityManager.getTransaction().commit();
        long id = parent.getId();

        Parent foundParent = parentDAO.find(id);

        assertNotNull(foundParent);
        assertEquals(parent, foundParent);
        assertEquals(parent.getChildren(), foundParent.getChildren());
    }

    @Test
    public void testPersist() throws Exception {

        Parent parent = createParent1();
        Child child = createChild3();
        parent.addChild(child);

        entityManager.getTransaction().begin();
        parentDAO.persist(parent);
        entityManager.getTransaction().commit();

        long id = parent.getId();
        Parent foundParent = parentDAO.find(id);
        assertNotNull(foundParent);
        assertEquals(parent, foundParent);
        assertEquals(parent.getChildren(), foundParent.getChildren());
    }

    @Test
    public void testRefresh() throws Exception {
        fail("Test not implemented");
    }

    @Test
    public void testUpdate() throws Exception {
        fail("Test not implemented");
    }

    @Test
    public void testDelete() throws Exception {
        fail("Test not implemented");
    }

    @Test
    public void testDeleteAll() throws Exception {
        fail("Test not implemented.");
    }

    @Test
    public void testLockById() throws Exception {
        fail("Test not implemented.");
    }

    @Test
    public void testLockByIdRange() throws Exception {
        fail("Test not implemented.");
    }
}