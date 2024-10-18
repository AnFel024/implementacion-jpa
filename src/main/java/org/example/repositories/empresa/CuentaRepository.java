package org.example.repositories.empresa;


import org.example.configs.EntityManagerPostgres;
import org.example.models.empresa.Cuenta;
import org.example.repositories.AbstractRepository;

public class CuentaRepository extends AbstractRepository<Cuenta> {
    public CuentaRepository() {
        super(new EntityManagerPostgres<>());
    }
}