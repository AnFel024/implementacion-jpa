package org.example.repositories.empresa;

import org.example.configs.EntityManagerPostgres;
import org.example.models.empresa.Persona;
import org.example.repositories.AbstractRepository;

public class PersonaRepository extends AbstractRepository<Persona> {

    public PersonaRepository() {
        super(new EntityManagerPostgres<>());
    }
}