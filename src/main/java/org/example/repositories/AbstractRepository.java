package org.example.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.NoArgsConstructor;
import org.example.configs.EntityManagerPostgres;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@NoArgsConstructor
public abstract class AbstractRepository<T> {

    protected EntityManagerPostgres<T> entityManagerPostgres;

    private Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public AbstractRepository(EntityManagerPostgres<T> entityManagerPostgres) {
        this.entityManagerPostgres = entityManagerPostgres;
    }

    public void create(T entity) {
        entityManagerPostgres.save(entity);
        System.out.println("Entidad creada");
    }

    public List<T> findAll() {
        String className = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0].getTypeName().split("\\.")[3]);
        return entityManagerPostgres.listAll(
                "SELECT d FROM " + className  + " d",
                tClass);
    }

    // Cerrar el EntityManagerFactory cuando haya terminado.
    public void close() {
        if (entityManagerPostgres.getEntityManager() != null) {
            entityManagerPostgres.getEntityManager().close();
        }
    }

}
