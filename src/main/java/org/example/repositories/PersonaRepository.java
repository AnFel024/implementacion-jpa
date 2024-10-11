package org.example.repositories;


import org.example.configs.EntityManagerPostgres;
import org.example.models.Persona;

public class PersonaRepository extends AbstractRepository<Persona> {

    public PersonaRepository() {
        super(new EntityManagerPostgres<>());
    }
}