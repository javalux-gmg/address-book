package ru.javalux.gmg.address_book.DAO.entity;

import java.io.Serializable;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */

public class ParentChildId implements Serializable {

    private static final long serialVersionUID = 1L;

    private int parent;
    private int child;


    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof ParentChildId)) {
            return false;
        }

        ParentChildId that = (ParentChildId) o;

        if (child != that.child) {
            return false;
        }
        if (parent != that.parent) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = parent;
        result = 31 * result + child;
        return result;
    }
}
