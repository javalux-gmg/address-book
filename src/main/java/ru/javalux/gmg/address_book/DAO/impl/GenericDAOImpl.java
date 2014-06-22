package ru.javalux.gmg.address_book.DAO.impl;

import ru.javalux.gmg.address_book.DAO.DataAccessException;
import ru.javalux.gmg.address_book.DAO.GenericDAO;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Grigoriy Alexeev on 22 Jun 2014.
 */
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

    protected EntityManager entityManager;
    protected Class<T> entityClass;


    public GenericDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        ParameterizedType genericSuperclass = (ParameterizedType) (getClass().getGenericSuperclass());
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    public GenericDAOImpl(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.entityClass = clazz;
    }


    @Override
    public List<T> getAll() throws DataAccessException {

        try {
            Query query = entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e");
            return (List<T>) query.getResultList();
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public T find(long id) throws DataAccessException {

        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public void persist(T object) throws DataAccessException {

        try {
            entityManager.persist(object);
        } catch (Exception e) {
            throw new DataAccessException(e);
        }
    }

    @Override
    public void refresh(T object) throws DataAccessException {

        try {
            entityManager.refresh(object);
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public void update(T object) throws DataAccessException {

        try {
            entityManager.merge(object);
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public void delete(T object) throws DataAccessException {

        try {
            entityManager.remove(object);
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public void deleteAll() throws DataAccessException {

        try {
            Query query = entityManager.createQuery("DELETE FROM " + entityClass.getSimpleName() + " entity");
            query.executeUpdate();
        } catch (Exception ex) {
            throw new DataAccessException(ex);
        }
    }

    @Override
    public boolean lockById(String queryName, Long id) {

        try {
            entityManager.createNamedQuery(queryName).setParameter(1, id).getResultList();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public boolean lockByIdRange(String tableName, List<Long> ids) {

        try {
            if (ids == null || ids.size() == 0) {
                return true;
            }
            StringBuilder sb = new StringBuilder().append("SELECT T.ID FROM ").append(tableName).append(" T WHERE T.ID IN (");
            Iterator<Long> it = ids.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                if (it.hasNext()) {
                    sb.append(",");
                }
            }
            sb.append(") FOR UPDATE NOWAIT");
            entityManager.createNativeQuery(sb.toString()).getResultList();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
