package org.example.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

import java.util.List;

public class EntityManagerPostgres<T> {
    @Getter
    private final EntityManagerFactory entityManagerFactory;

    @Getter
    private final EntityManager entityManager;

    public EntityManagerPostgres() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("myPU");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public List<T> listAll(String query, Class<T> t) {
        return entityManager.createQuery(query, t).getResultList();
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
