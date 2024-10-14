package org.example.repositories;


import org.example.configs.EntityManagerPostgres;
import org.example.models.Cuenta;
import org.example.models.Departamento;

public class CuentaRepository extends AbstractRepository<Cuenta> {
    public CuentaRepository() {
        super(new EntityManagerPostgres<>());
    }
}