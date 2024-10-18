package org.example.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.configs.EntityManagerPostgres;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class AbstractRepository<T> {

    protected final EntityManagerPostgres<T> entityManagerPostgres;

    private final String className;

    private Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public AbstractRepository(EntityManagerPostgres<T> entityManagerPostgres) {
        this.entityManagerPostgres = entityManagerPostgres;
        // org.example.models.empresa.Cuenta
        this.className = (((ParameterizedType) getClass().getGenericSuperclass())
                .getActualTypeArguments()[0].getTypeName().split("\\.")[4]);
    }

    public void create(T entity) {
        entityManagerPostgres.save(entity);
        System.out.println("Entidad creada");
    }

    public List<T> findAll() {
        return entityManagerPostgres.listAll(
                "SELECT d FROM " + className  + " d",
                tClass);
    }

    public T findById(Object id) {
        return entityManagerPostgres.findEntityById(id, tClass);
    }

    // Cerrar el EntityManagerFactory cuando haya terminado.
    public void close() {
        if (entityManagerPostgres.getEntityManager() != null) {
            entityManagerPostgres.getEntityManager().close();
        }
    }

}
