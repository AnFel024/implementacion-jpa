package org.example;

import org.example.models.Departamento;
import org.example.models.Persona;
import org.example.repositories.DepartamentoRepository;
import org.example.repositories.PersonaRepository;

public class Main {
    public static void main(String[] args) {

        PersonaRepository personaRepository = new PersonaRepository();
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();

        Persona persona = new Persona();
        persona.setNombre("Juana Leon");
        persona.setCedula(1234987L);
        personaRepository.create(persona);

        personaRepository.findAll()
                        .stream()
                                .forEach(System.out::println);

        Departamento departamento = new Departamento();
        departamento.setNombre("Contabilidad");
        departamentoRepository.create(departamento);

        System.out.println("Listar departamentos:");
        for (Departamento departamento1 : departamentoRepository.findAll()) {
            System.out.println(departamento1.toString());
        }

        // Metodos para cerrar conexiones
        departamentoRepository.close();
        personaRepository.close();
    }
}