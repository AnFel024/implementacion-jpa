package org.example;

import org.example.models.Capacitacion;
import org.example.models.Cuenta;
import org.example.models.Departamento;
import org.example.models.Persona;
import org.example.repositories.CapacitacionRepository;
import org.example.repositories.CuentaRepository;
import org.example.repositories.DepartamentoRepository;
import org.example.repositories.PersonaRepository;

import java.time.LocalTime;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        // Repositorios
        PersonaRepository personaRepository = new PersonaRepository();
        DepartamentoRepository departamentoRepository = new DepartamentoRepository();
        CuentaRepository cuentaRepository = new CuentaRepository();
        CapacitacionRepository capacitacionRepository = new CapacitacionRepository();

        // Dominios (registros)
        Persona persona = new Persona();
        persona.setNombre("Juana Leon");
        persona.setCedula(1234987L);
        Persona persona2 = Persona.builder()
                .nombre("Andres Morales")
                .cedula(123L)
                .build();
        Departamento departamento = new Departamento();
        departamento.setNombre("Contabilidad");

        Cuenta cuenta = Cuenta.builder()
                .banco("Banco Santander")
                .numeroCuenta("123BS")
                .build();

        Cuenta cuenta2 = Cuenta.builder()
                .banco("Bancolombia")
                .numeroCuenta("123BC")
                .build();

        Capacitacion capacitacion = Capacitacion.builder()
                .horaInicio(LocalTime.of(17, 0, 0))
                .horaFin(LocalTime.of(18, 0, 0))
                .nombre("Java 1")
                .build();

        Capacitacion capacitacion2 = Capacitacion.builder()
                .horaInicio(LocalTime.of(18, 0, 0))
                .horaFin(LocalTime.of(19, 0, 0))
                .nombre("SQL Avanzado")
                .build();


        personaRepository.create(persona);
        personaRepository.create(persona2);
        departamentoRepository.create(departamento);
        cuentaRepository.create(cuenta);
        cuentaRepository.create(cuenta2);
        capacitacionRepository.create(capacitacion);
        capacitacionRepository.create(capacitacion2);

        personaRepository.findAll()
                                .forEach(System.out::println);
        departamentoRepository.findAll()
                                .forEach(System.out::println);
        cuentaRepository.findAll()
                                .forEach(System.out::println);
        capacitacionRepository.findAll()
                                .forEach(System.out::println);

        // Metodos para cerrar conexiones
        departamentoRepository.close();
        cuentaRepository.close();
        capacitacionRepository.close();
        personaRepository.close();
    }
}