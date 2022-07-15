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

class OdontologoTest {

    @Test
    void getId() {

        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);
        assertEquals(1L, odontologo.getId());
    }

    @Test
    void getNombre() {

        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Clara");
        assertEquals("Clara", odontologo.getNombre());
    }

    @Test
    void getApellido() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Lisle");
        assertEquals("Lisle", odontologo.getApellido());
    }

    @Test
    void getMatricula() {

        Odontologo odontologo = new Odontologo();
        odontologo.setMatricula(123);
        assertEquals(123, odontologo.getMatricula());
    }

    @Test
    void getTrunos() {
        //Arrange
        Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.now(), LocalTime.now());
        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno);
        odontologo.setTurnos(turnos);

        //Assert
        assertEquals(1, odontologo.getTurnos().size());
    }

    @Test
    void setId() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setId(1L);

        //Assert
        assertEquals(1L, odontologo.getId());
    }

    @Test
    void setNombre() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("Clara");

        //Assert
        assertEquals("Clara", odontologo.getNombre());
    }

    @Test
    void setApellido() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setApellido("Lisle");

        //Assert
        assertEquals("Lisle", odontologo.getApellido());
    }

    @Test
    void setMatricula() {
        //Arrange
        Odontologo odontologo = new Odontologo();
        odontologo.setMatricula(123);

        //Assert
        assertEquals(123, odontologo.getMatricula());
    }

    @Test
    void setTrunos(){
        //Arrange
        Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

        Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        Turno turno = new Turno(1L, paciente, odontologo, LocalDate.now(), LocalTime.now());
        List<Turno> turnos = new ArrayList<>();
        turnos.add(turno);
        odontologo.setTurnos(turnos);

        //Assert
        assertEquals(1, odontologo.getTurnos().size());
    }

    @Test
    void testToString() {

    }


       @Nested
    @DisplayName("Tests Constructor Odontologo")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un odontologo con un constructor vacio")
        void constructorVacio() {
            Odontologo odontologo = new Odontologo();
            assertNotNull(odontologo);

        }

        @Test
        @DisplayName("Se crea un odontologo con un constructor con argumentos")
        void constructorConAtributos() {

            List<Turno> turnos = new ArrayList<>();

            Odontologo odontologo = new Odontologo(1L, "Clara", "Lisle", 1234, turnos);


            //Assert
            assertNotNull(odontologo);
            assertEquals("Clara", odontologo.getNombre());
            assertEquals("Lisle", odontologo.getApellido());
            assertEquals(1234, odontologo.getMatricula());
            assertEquals(0, odontologo.getTurnos().size());
        }

    }
}