package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Tests atributos Odontologos")
class OdontologoDTOTest {

    @BeforeEach
    void setupBeforeEach(){
        OdontologoDTO odontologoDTO = new OdontologoDTO();
    }


    @Test
    @DisplayName("GetId Odontologo")
    void getId() {
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(1L);

        //Assert
        assertEquals(1L, odontologoDTO.getId());
    }

    @Test
    @DisplayName("GetNombre Odontologo")
    void getNombre() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Clara");

        assertEquals("Clara", odontologoDTO.getNombre());
    }

    @Test
    @DisplayName("GetApellido Odontologo")
    void getApellido() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Apellido");

        assertEquals("Apellido", odontologoDTO.getApellido());
    }

    @Test
    @DisplayName("GetMatricula Odontologo")
    void getMatricula() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setMatricula(123);

        assertEquals(123, odontologoDTO.getMatricula());
    }

    @Test
    @DisplayName("SetId Odontologo")
    void setId() {
        //Arrange
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setId(1L);

        //Assert
        assertEquals(1L, odontologoDTO.getId());
    }

    @Test
    @DisplayName("GetNombre Odontologo")
    void setNombre() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Clara");

        assertEquals("Clara", odontologoDTO.getNombre());
    }

    @Test
    @DisplayName("GetApellido Odontologo")
    void setApellido() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setApellido("Apellido");

        assertEquals("Apellido", odontologoDTO.getApellido());
    }

    @Test
    @DisplayName("GetMatricula Odontologo")
    void setMatricula() {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setMatricula(123);

        assertEquals(123, odontologoDTO.getMatricula());
    }

    @Test
    @DisplayName("To String")
    void testToString() {
        OdontologoDTO odontologoDto = new OdontologoDTO(1L, "Clara", "Lisle", 1234);

        //Assert
        assertEquals("OdontologoDTO(id=1, nombre=Clara, apellido=Lisle, matricula=1234)", odontologoDto.toString());
    }


    @Nested
    @DisplayName("Tests Constructor Odontologo")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un odontologo con un constructor vacio")
        void constructorVacio() {
            OdontologoDTO odontologoDTO = new OdontologoDTO();
            assertNotNull(odontologoDTO);

        }

        @Test
        @DisplayName("Se crea un odontologo con un constructor con argumentos")
        void constructorConAtributos() {

            OdontologoDTO odontologoDTO = new OdontologoDTO(1L, "Clara", "Lisle", 1234);
            //Assert
            assertEquals(1L, odontologoDTO.getId());
            assertEquals("Clara", odontologoDTO.getNombre());
            assertEquals("Lisle", odontologoDTO.getApellido());
            assertEquals(1234, odontologoDTO.getMatricula());
        }

    }
}