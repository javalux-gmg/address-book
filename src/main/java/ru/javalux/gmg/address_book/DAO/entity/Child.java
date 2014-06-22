package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
public class Child extends Person {

    @OneToMany(mappedBy = "child")
    private Set<ParentChild> parents;


    public Set<ParentChild> getParents() {
        return parents;
    }

    public void setParents(Set<ParentChild> parents) {
        this.parents = parents;
    }

    public void addParent(Parent parent) {

        if (parents == null) {
            parents = new HashSet<ParentChild>();
        }
        parents.add(new ParentChild(parent, this));
    }

    @Override
    public String toString() {

        return super.toString() +
               "parents=" + parents +
               '}';
    }
}
