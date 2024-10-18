package org.example.repositories.empresa;


import org.example.configs.EntityManagerPostgres;
import org.example.models.empresa.Departamento;
import org.example.repositories.AbstractRepository;

public class DepartamentoRepository extends AbstractRepository<Departamento> {

    public DepartamentoRepository() {
        super(new EntityManagerPostgres<>());
    }
}