package ru.javalux.gmg.address_book.DAO.entity;

import javax.persistence.*;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
@Entity
@IdClass(ParentChildId.class)
public class ParentChild {

    @Id
    @ManyToOne
    @JoinColumn(name="parent_id")
    private Parent parent;
    @Id
    @ManyToOne
    @JoinColumn(name="child_id")
    private Child child;


    public ParentChild() {
    }

    public ParentChild(Parent parent, Child child) {

        this.parent = parent;
        this.child = child;
    }


    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
