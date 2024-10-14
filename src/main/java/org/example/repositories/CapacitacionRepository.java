package org.example.repositories;


import org.example.configs.EntityManagerPostgres;
import org.example.models.Capacitacion;
import org.example.models.Departamento;

public class CapacitacionRepository extends AbstractRepository<Capacitacion> {

    public CapacitacionRepository() {
        super(new EntityManagerPostgres<>());
    }
}