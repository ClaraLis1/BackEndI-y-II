package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TurnoDTOTest {

    @Test
    void getId() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(1L);
        assertEquals(1L, turnoDTO.getId());
    }

    @Test
    void getPaciente() {
        Paciente paciente = new Paciente();
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(paciente);
        assertEquals(paciente, turnoDTO.getPaciente());
    }

    @Test
    void getOdontologo() {
        Odontologo odontologo = new Odontologo();
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setOdontologo(odontologo);
        assertEquals(odontologo, turnoDTO.getOdontologo());
    }

    @Test
    void getFecha() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFecha(LocalDate.parse("2022-07-05"));
        assertEquals("2022-07-05", turnoDTO.getFecha().toString());

    }

    @Test
    void getHora() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setHora(LocalTime.parse("08:00"));
        assertEquals("08:00", turnoDTO.getHora().toString());
    }

    @Test
    void setId() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(1L);
        assertEquals(1L, turnoDTO.getId());
    }

    @Test
    void setPaciente() {
        Paciente paciente = new Paciente();
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setPaciente(paciente);
        assertEquals(paciente, turnoDTO.getPaciente());
    }

    @Test
    void setOdontologo() {
        Odontologo odontologo = new Odontologo();
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setOdontologo(odontologo);
        assertEquals(odontologo, turnoDTO.getOdontologo());
    }

    @Test
    void setFecha() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setFecha(LocalDate.parse("2022-07-05"));
        assertEquals("2022-07-05", turnoDTO.getFecha().toString());
    }

    @Test
    void setHora() {
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setHora(LocalTime.parse("08:00"));
        assertEquals("08:00", turnoDTO.getHora().toString());
    }

    @Test
    void testToString() {

        TurnoDTO turnoDTO = new TurnoDTO();
        System.out.println(turnoDTO.toString());

       assertEquals("TurnoDTO(id=null, paciente=null, odontologo=null, fecha=null, hora=null)", turnoDTO.toString());
    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un objeto con un constructor vacio")
        void constructorVacio() {
            TurnoDTO turnoDTO = new TurnoDTO();
            assertNotNull(turnoDTO);

        }

        @Test
        @DisplayName("Se crea un objeto con un constructor con argumentos")
        void constructorConAtributos() {
            Odontologo odontologo = new Odontologo(1L, "Odontologo", "Lisle", 1234);
            Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");

            Paciente paciente = new Paciente( "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
            paciente.setId(1L);

            TurnoDTO turnoDTO = new TurnoDTO(1L, paciente, odontologo, LocalDate.parse("2022-07-05"), LocalTime.parse("08:00"));
            //Assert
            assertEquals(1L, turnoDTO.getId());
            assertEquals(paciente, turnoDTO.getPaciente());
            assertEquals(odontologo, turnoDTO.getOdontologo());
            assertEquals("2022-07-05", turnoDTO.getFecha().toString());
            assertEquals("08:00", turnoDTO.getHora().toString());
        }

    }
}