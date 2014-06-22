package ru.javalux.gmg.address_book.DAO.impl;

import org.junit.Before;
import org.junit.Test;
import ru.javalux.gmg.address_book.DAO.*;
import ru.javalux.gmg.address_book.DAO.entity.*;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonDAOImplTest extends BaseDAOTest {

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
    private PersonDAO personDAO;
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
        tx.commit();
        personDAO = new PersonDAOImpl(entityManager);
        countryDAO = new CountryDAOImpl(entityManager);
        cityDAO = new CityDAOImpl(entityManager);
        streetDAO = new StreetDAOImpl(entityManager);
        buildingDAO = new BuildingDAOImpl(entityManager);
        apartmentDAO = new ApartmentDAOImpl(entityManager);
    }

    @Test
    public void testGetAll() throws Exception {

    }

    private Person createPerson1() throws Exception {

        return createPerson(FIRST_NAME_1, LAST_NAME_1, AGE_1, COUNTRY_NAME_1, CITY_NAME_1,
                            STREET_NAME_1, BUILDING_NAME_1, APARTMENT_NAME_1);
    }

    private Person createPerson2() throws Exception {

        return createPerson(FIRST_NAME_2, LAST_NAME_2, AGE_2, COUNTRY_NAME_2, CITY_NAME_2,
                            STREET_NAME_2, BUILDING_NAME_2, APARTMENT_NAME_2);
    }

    private Person createPerson3() throws Exception {

        return createPerson(FIRST_NAME_3, LAST_NAME_3, AGE_3, COUNTRY_NAME_3, CITY_NAME_3,
                            STREET_NAME_3, BUILDING_NAME_3, APARTMENT_NAME_3);
    }

    private Person createPerson(String firstName, String lastName, int age, String countryName,
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

        Person person = new Parent();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAge(age);
        person.setCountry(country);
        person.setCity(city);
        person.setStreet(street);
        person.setBuilding(building);
        person.setApartment(apartment);

        return person;
    }

    @Test
    public void testFind() throws Exception {

        Person person = createPerson1();
        entityManager.getTransaction().begin();
        personDAO.persist(person);
        entityManager.getTransaction().commit();
        long id = person.getId();

        Person foundPerson = personDAO.find(id);

        assertNotNull(foundPerson);
        assertEquals(person, foundPerson);
    }

    @Test
    public void testPersist() throws Exception {

        Person person = createPerson1();

        entityManager.getTransaction().begin();
        personDAO.persist(person);
        entityManager.getTransaction().commit();

        long id = person.getId();
        Person foundPerson = personDAO.find(id);
        assertNotNull(foundPerson);
        assertEquals(person, foundPerson);
    }

    @Test
    public void testRefresh() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

        Person person = createPerson1();
        entityManager.getTransaction().begin();
        personDAO.persist(person);
        entityManager.getTransaction().commit();
        long id = person.getId();
        Country country = new Country(COUNTRY_NAME_2);
        City city = new City(CITY_NAME_2, country);
        Street street = new Street(STREET_NAME_2, city);
        Building building = new Building(BUILDING_NAME_2, street);
        Apartment apartment = new Apartment(APARTMENT_NAME_2, building);
        entityManager.getTransaction().begin();
        countryDAO.persist(country);
        cityDAO.persist(city);
        streetDAO.persist(street);
        buildingDAO.persist(building);
        apartmentDAO.persist(apartment);
        entityManager.getTransaction().commit();
        person.setFirstName(FIRST_NAME_2);
        person.setLastName(LAST_NAME_2);
        person.setAge(AGE_2);
        person.setCountry(country);
        person.setCity(city);
        person.setStreet(street);
        person.setBuilding(building);
        person.setApartment(apartment);

        entityManager.getTransaction().begin();
        personDAO.update(person);
        entityManager.getTransaction().commit();

        Person updatedPerson = personDAO.find(id);
        assertNotNull(updatedPerson);
        assertEquals(person, updatedPerson);
    }

    @Test
    public void testDelete() throws Exception {

        Person person = createPerson1();
        entityManager.getTransaction().begin();
        personDAO.persist(person);
        entityManager.getTransaction().commit();
        long id = person.getId();

        entityManager.getTransaction().begin();
        personDAO.delete(person);
        entityManager.getTransaction().commit();

        Person deletedPerson = personDAO.find(id);
        assertNull(deletedPerson);
    }

    @Test
    public void testDeleteAll() throws Exception {

    }

    @Test
    public void testLockById() throws Exception {

    }

    @Test
    public void testLockByIdRange() throws Exception {

    }

    @Test
    public void testGetPersonsByCountry() throws Exception {

        Person person1 = createPerson1();
        Person person2 = createPerson2();
        entityManager.getTransaction().begin();
        personDAO.persist(person1);
        personDAO.persist(person2);
        entityManager.getTransaction().commit();
        List<Person> expectedPersons = new ArrayList<Person>();
        expectedPersons.add(person1);

        System.out.println(person1.getCountry());
        List<Person> foundPersons = personDAO.getPersonsByCountry(person1.getCountry());

        assertNotNull(foundPersons);
        boolean listsMatch = expectedPersons.containsAll(foundPersons) &&
                             foundPersons.containsAll(expectedPersons);
        assertTrue(listsMatch);
    }
}