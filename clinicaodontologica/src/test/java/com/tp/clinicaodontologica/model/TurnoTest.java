package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoTest {

    @Test
    void getId() {
        Turno turno = new Turno();
        turno.setId(1L);
        assertEquals(1L, turno.getId());
    }

    @Test
    void getPaciente() {
        Paciente paciente = new Paciente();
        Turno turno = new Turno();
        turno.setPaciente(paciente);
        assertEquals(paciente, turno.getPaciente());
    }

    @Test
    void getOdontologo() {
        Odontologo odontologo = new Odontologo();
        Turno turno = new Turno();
        turno.setOdontologo(odontologo);
        assertEquals(odontologo, turno.getOdontologo());
    }

    @Test
    void getFecha() {
        Turno turno = new Turno();
        turno.setFecha(LocalDate.parse("2022-07-05"));
        assertEquals("2022-07-05", turno.getFecha().toString());

    }

    @Test
    void getHora() {
        Turno turno = new Turno();
        turno.setHora(LocalTime.parse("08:00"));
        assertEquals("08:00", turno.getHora().toString());
    }

    @Test
    void setId() {
        Turno turno = new Turno();
        turno.setId(1L);
        assertEquals(1L, turno.getId());
    }

    @Test
    void setPaciente() {
        Paciente paciente = new Paciente();
        Turno turno = new Turno();
        turno.setPaciente(paciente);
        assertEquals(paciente, turno.getPaciente());
    }

    @Test
    void setOdontologo() {
        Odontologo odontologo = new Odontologo();
        Turno turno = new Turno();
        turno.setOdontologo(odontologo);
        assertEquals(odontologo, turno.getOdontologo());
    }

    @Test
    void setFecha() {
        Turno turno = new Turno();
        turno.setFecha(LocalDate.parse("2022-07-05"));
        assertEquals("2022-07-05", turno.getFecha().toString());
    }

    @Test
    void setHora() {
        Turno turno = new Turno();
        turno.setHora(LocalTime.parse("08:00"));
        assertEquals("08:00", turno.getHora().toString());
    }

    @Test
    void testToString() {
        Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        paciente.setId(1L);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.parse("2022-07-05"), LocalTime.parse("08:00"));

        assertEquals("Turno(id=1, paciente=Paciente(id=1, nombre=Clara, apellido=Lisle, dni=1234, fechaIngreso=2022-07-04T11:20, turnos=null, domicilio=Domicilio(id=1, calle=San Martin, numero=1, localidad=Tandil, provincia=BsAs)), odontologo=Odontologo(id=1, nombre=Odontologo, apellido=Lisle, matricula=1234, turnos=null), fecha=2022-07-05, hora=08:00)", turno.toString());
    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un objeto con un constructor vacio")
        void constructorVacio() {
            Turno turno = new Turno();
            assertNotNull(turno);

        }

        @Test
        @DisplayName("Se crea un objeto con un constructor con argumentos")
        void constructorConAtributos() {
            Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
            Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

            Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
            paciente.setId(1L);

            Turno turno = new Turno(1L, paciente, odontologo, LocalDate.parse("2022-07-05"), LocalTime.parse("08:00"));
            //Assert
            assertEquals(1L, turno.getId());
            assertEquals(paciente, turno.getPaciente());
            assertEquals(odontologo, turno.getOdontologo());
            assertEquals("2022-07-05", turno.getFecha().toString());
            assertEquals("08:00", turno.getHora().toString());
        }

    }

}