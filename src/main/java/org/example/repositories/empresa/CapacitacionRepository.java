package org.example.repositories.empresa;


import org.example.configs.EntityManagerPostgres;
import org.example.models.empresa.Capacitacion;
import org.example.repositories.AbstractRepository;

public class CapacitacionRepository extends AbstractRepository<Capacitacion> {

    public CapacitacionRepository() {
        super(new EntityManagerPostgres<>());
    }
}