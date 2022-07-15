package com.tp.clinicaodontologica.model;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@TestMethodOrder(MethodOrderer.MethodName)
class PacienteTest {


    @Test
    void getId() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setId(1L);

        //Assert
        assertEquals(1L, paciente.getId());
    }

    @Test
    void getNombre() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Clara");

        //Assert
        assertEquals("Clara", paciente.getNombre());
    }

    @Test
    void getApellido() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setApellido("Lisle");

        //Assert
        assertEquals("Lisle", paciente.getApellido());
    }

    @Test
    void getDni() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setDni("12345");

        //Assert
        assertEquals("12345", paciente.getDni());
    }

    @Test
    void getFechaIngreso() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setFechaIngreso(LocalDateTime.parse("2022-07-04T11:20"));

        //Assert
        assertEquals("2022-07-04T11:20", paciente.getFechaIngreso().toString());
    }

    @Test
    void getDomicilio() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.now(), domicilio);

        assertEquals(1L, paciente.getDomicilio().getId());
    }

    @Test
    void getTrunos(){
        //Arrange
        Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.now(), LocalTime.now());
        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno);
        paciente.setTurnos(turnos);

        //Assert
        assertEquals(1, paciente.getTurnos().size());
    }

    @Test
    void setId() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setId(1L);

        //Assert
        assertEquals(1L, paciente.getId());
    }

    @Test
    void setNombre() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Clara");

        //Assert
        assertEquals("Clara", paciente.getNombre());
    }

    @Test
    void setApellido() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setApellido("Lisle");

        //Assert
        assertEquals("Lisle", paciente.getApellido());
    }

    @Test
    void setDni() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setDni("12345");

        //Assert
        assertEquals("12345", paciente.getDni());
    }

    @Test
    void setFechaIngreso() {
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setFechaIngreso(LocalDateTime.parse("2022-07-04T11:20"));

        //Assert
        assertEquals("2022-07-04T11:20", paciente.getFechaIngreso().toString());
    }

    @Test
    void setDomicilio() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.now(), domicilio);

        assertEquals(domicilio, paciente.getDomicilio());
    }

    @Test
    void setTurnos(){
        //Arrange
        Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.now(), LocalTime.now());
        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno);
        paciente.setTurnos(turnos);

        //Assert
        assertEquals(1, paciente.getTurnos().size());
    }


    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        paciente.setId(1L);

        assertEquals("Paciente(id=1, nombre=Clara, apellido=Lisle, dni=1234, fechaIngreso=2022-07-04T11:20, turnos=null, domicilio=Domicilio(id=1, calle=San Martin, numero=1, localidad=Tandil, provincia=BsAs))", paciente.toString());
    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un Paciente con un constructor vacio")
        void constructorVacio() {
            Paciente paciente = new Paciente();
            assertNotNull(paciente);

        }

        @Test
        @DisplayName("Se crea un paciente con un constructor con argumentos")
        void constructorConAtributos() {

            Domicilio domicilio = new Domicilio();
           // Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);

            List<Turno> turnos = new ArrayList<>();
            Paciente paciente = new Paciente(1L, "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), turnos, domicilio);
            //Assert
            assertNotNull(paciente);
            assertEquals("Clara", paciente.getNombre());
            assertEquals("Lisle", paciente.getApellido());
            assertEquals("1234", paciente.getDni());
        }

    }
}