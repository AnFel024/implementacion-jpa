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
import java.util.Set;
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
        Persona persona3 = Persona.builder()
                .nombre("Ares Morals")
                .cedula(124L)
                .build();
        Persona persona4 = Persona.builder()
                .nombre("ndres Moraes")
                .cedula(125L)
                .build();
        /* persona3 = Persona.builder()
                .nombre("Andres Morales")
                .cedula(123L)
                .build();*/
        Departamento departamento = new Departamento();
        departamento.setNombre("Contabilidad");
        Departamento departamento2 = new Departamento();
        departamento2.setNombre("Tesoreria");
        Departamento departamento3 = new Departamento();
        departamento3.setNombre("Sistemas");

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

        // Almacena las personas en la base de datos
        personaRepository.create(persona);
        personaRepository.create(persona2);
        personaRepository.create(persona3);
        personaRepository.create(persona4);

        // Almacena el departamento en la base
        departamento.getPersonas().add(persona);
        departamento.getPersonas().add(persona2);
        departamentoRepository.create(departamento);

        departamento2.getPersonas().add(persona3);
        departamentoRepository.create(departamento2);

        departamento3.getPersonas().add(persona4);
        departamentoRepository.create(departamento3);

        // Almacena
        cuentaRepository.create(cuenta);
        cuentaRepository.create(cuenta2);
        capacitacionRepository.create(capacitacion);
        capacitacionRepository.create(capacitacion2);

        // Metodos para listar

        for ( Departamento depto : departamentoRepository.findAll()) {
            System.out.println("Para el departamento " + depto.getNombre() + " trabajan las personas:");
            depto.getPersonas()
                    .forEach(System.out::println);
        }

        // Metodos para cerrar conexiones
        departamentoRepository.close();
        cuentaRepository.close();
        capacitacionRepository.close();
        personaRepository.close();
    }
}