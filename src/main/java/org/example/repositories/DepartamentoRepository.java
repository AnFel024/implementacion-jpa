package org.example.repositories;


import org.example.configs.EntityManagerPostgres;
import org.example.models.Departamento;

public class DepartamentoRepository extends AbstractRepository<Departamento> {

    public DepartamentoRepository() {
        super(new EntityManagerPostgres<>());
    }
}