package ru.javalux.gmg.address_book.DAO;

import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public interface GenericDAO<T> {

    List<T> getAll() throws DataAccessException;

    T find(long id) throws DataAccessException;

    void persist(T object) throws DataAccessException;

    void refresh(T object) throws DataAccessException;

    void update(T object) throws DataAccessException;

    void delete(T object) throws DataAccessException;

    void deleteAll() throws DataAccessException;

    boolean lockById(String queryName, Long id);

    boolean lockByIdRange(String queryName, List<Long> ids);
}
