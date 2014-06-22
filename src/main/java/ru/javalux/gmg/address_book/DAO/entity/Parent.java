package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
public class Parent extends Person {

    @OneToMany(mappedBy="parent")
    private Set<ParentChild> children;


    public Set<ParentChild> getChildren() {
        return children;
    }

    public void setChildren(Set<ParentChild> children) {
        this.children = children;
    }

    public void addChild(Child child) {

        if (children == null) {
            children = new HashSet<ParentChild>();
        }
        children.add(new ParentChild(this, child));
    }

    @Override
    public String toString() {

        return super.toString() +
               ", children=" + children +
               '}';
    }
}
