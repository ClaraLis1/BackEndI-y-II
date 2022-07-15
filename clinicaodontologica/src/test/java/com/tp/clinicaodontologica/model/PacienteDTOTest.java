package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PacienteDTOTest {

    @Test
    @DisplayName("tiene nombre")
    void tieneNombre(){
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Clara");
        assertEquals(pacienteDTO.getNombre(),"Clara");

    }


    @Test
    void getId() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(1L);

        //Assert
        assertEquals(1L, pacienteDTO.getId());
    }

    @Test
    void getNombre() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Clara");

        //Assert
        assertEquals("Clara", pacienteDTO.getNombre());
    }

    @Test
    void getApellido() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Lisle");

        //Assert
        assertEquals("Lisle", pacienteDTO.getApellido());
    }

    @Test
    void getDni() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setDni("12345");

        //Assert
        assertEquals("12345", pacienteDTO.getDni());
    }

    @Test
    void getFechaIngreso() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setFechaIngreso(LocalDateTime.parse("2022-07-04T11:20"));

        //Assert
        assertEquals("2022-07-04T11:20", pacienteDTO.getFechaIngreso().toString());
    }

    @Test
    void getDomicilio() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        PacienteDTO pacienteDTO = new PacienteDTO( 1L,"Clara", "Lisle", "1234", LocalDateTime.now(), domicilio);

        assertEquals(1L, pacienteDTO.getDomicilio().getId());
    }

    @Test
    void setId() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setId(1L);

        //Assert
        assertEquals(1L, pacienteDTO.getId());
    }

    @Test
    void setNombre() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Clara");

        //Assert
        assertEquals("Clara", pacienteDTO.getNombre());
    }

    @Test
    void setApellido() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setApellido("Lisle");

        //Assert
        assertEquals("Lisle", pacienteDTO.getApellido());
    }

    @Test
    void setDni() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setDni("12345");

        //Assert
        assertEquals("12345", pacienteDTO.getDni());
    }

    @Test
    void setFechaIngreso() {
        //Arrange
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setFechaIngreso(LocalDateTime.parse("2022-07-04T11:20"));

        //Assert
        assertEquals("2022-07-04T11:20", pacienteDTO.getFechaIngreso().toString());
    }

    @Test
    void setDomicilio() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        PacienteDTO pacienteDTO = new PacienteDTO(1L, "Clara", "Lisle", "1234", LocalDateTime.now(), domicilio);

        assertEquals(1L, pacienteDTO.getDomicilio().getId());
    }

    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        PacienteDTO pacienteDTO = new PacienteDTO( 1L,"Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);
        pacienteDTO.setId(1L);


        assertEquals("PacienteDTO(id=1, nombre=Clara, apellido=Lisle, dni=1234, fechaIngreso=2022-07-04T11:20, domicilio=Domicilio(id=1, calle=San Martin, numero=1, localidad=Tandil, provincia=BsAs))", pacienteDTO.toString());

    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un Paciente con un constructor vacio")
        void constructorVacio() {
            PacienteDTO paciente = new PacienteDTO();
            assertNotNull(paciente);

        }

        @Test
        @DisplayName("Se crea un paciente con un constructor con argumentos")
        void constructorConAtributos() {

            Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
            PacienteDTO paciente = new PacienteDTO(1L, "Clara", "Lisle", "1234", LocalDateTime.parse("2022-07-04T11:20"), domicilio);

            //Assert
            assertEquals(1L, paciente.getId());
            assertEquals("Clara", paciente.getNombre());
            assertEquals("Lisle", paciente.getApellido());
            assertEquals("1234", paciente.getDni());
        }

    }

}