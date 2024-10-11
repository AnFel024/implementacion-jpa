package org.example.configs;

import java.util.Map;

public class TypedQueryReference<T> implements jakarta.persistence.TypedQueryReference {
    private final String jpql;
    private final Class<T> resultClass;

    public TypedQueryReference(String jpql, Class<T> resultClass) {
        this.jpql = jpql;
        this.resultClass = resultClass;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public Class<T> getResultType() {
        return resultClass;
    }

    @Override
    public Map<String, Object> getHints() {
        return Map.of();
    }
}
