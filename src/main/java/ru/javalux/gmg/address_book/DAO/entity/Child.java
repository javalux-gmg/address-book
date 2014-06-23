package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
public class Child extends Person {

    @ManyToMany
    private Set<Person> parents;


    public Set<Person> getParents() {
        return parents;
    }

    public void setParents(Set<Person> parents) {
        for (Person parent : parents) {
            if (parent instanceof Child) {
                throw new IllegalArgumentException("A child can't be also a parent.");
            }
        }
        this.parents = parents;
    }

    public void addParent(Person parent) {

        if (parents == null) {
            parents = new HashSet<Person>();
        }
        if (parent instanceof Child) {
            throw new IllegalArgumentException("A child can't be also a parent.");
        }
        parents.add(parent);
    }

    @Override
    public String toString() {

        return super.toString() +
               "parents=" + parents +
               '}';
    }
}
