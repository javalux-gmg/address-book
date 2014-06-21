address-book
============

Address book in Java, using JPA, MySQL, Vaadin. A probation perion test task:

As a test task for JPA please implement and present next week 27th June the following.
Please implement the task as a team – i.e. decide internally between you who will implement
what part using common SVN repository.
 
 
1. Use MySQL database
2. Write Java model
3. Write DAO
4. Write Unit tests
5. Use only JPA and not native queries
6. Create DB model using JPA export and not SQL queries
7. Class Child extends Person
8. Child – Person is a Many-To-Many relationship
9. Implement a tool which populates a database with
  1. 3 different countries
  2. 5-10 different cities for every country
  3. 50-100 citizen for every city
    1. Citizen should have 1 – 4 kids
 
 
**Country**
Name
 
**City**
Name
 
**Person**
First Name
Last Name
Age
Street
Home
Apartment
 
**Child extends Person**
First Name
Last Name
Age
Street
Home
Apartment


Create a Business interface and a implementation as such:
 
```java
IAddressBook {
 
    List<Person> findPersonsByCountry(Country country)
    List<Person> findPersonsByCity(City City)
    List<Person> findPersonsByStreet(Street street);
    List<Person> findParentsOfChild(Child child);
    List<Child> findChildrenOfPerson(Person person);
    List<Child> findChildrenByStreet(Street street);
    List<Street> findStreetsByCity(City city);
}
```
