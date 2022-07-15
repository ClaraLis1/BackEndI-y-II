package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioDTOTest {
    @Test
    void getId() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(1L);
        assertEquals(1L, domicilioDTO.getId());
    }

    @Test
    void getCalle() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Mitre");
        assertEquals("Mitre", domicilioDTO.getCalle());
    }

    @Test
    void getNumero() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setNumero("123");
        assertEquals("123", domicilioDTO.getNumero());
    }

    @Test
    void getLocalidad() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setLocalidad("Tandil");
        assertEquals("Tandil", domicilioDTO.getLocalidad());
    }

    @Test
    void getProvincia() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setProvincia("BsAs");
        assertEquals("BsAs", domicilioDTO.getProvincia());
    }

    @Test
    void setId() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setId(1L);
        assertEquals(1L, domicilioDTO.getId());
    }

    @Test
    void setCalle() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("Mitre");
        assertEquals("Mitre", domicilioDTO.getCalle());
    }

    @Test
    void setNumero() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setNumero("123");
        assertEquals("123", domicilioDTO.getNumero());
    }

    @Test
    void setLocalidad() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setLocalidad("Tandil");
        assertEquals("Tandil", domicilioDTO.getLocalidad());
    }

    @Test
    void setProvincia() {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setProvincia("BsAs");
        assertEquals("BsAs", domicilioDTO.getProvincia());
    }

    @Test
    void testToString() {
        DomicilioDTO domicilioDTO = new DomicilioDTO(1L,"San Martin", "1", "Tandil", "BsAs");

        assertEquals("DomicilioDTO(id=1, calle=San Martin, numero=1, localidad=Tandil, provincia=BsAs)", domicilioDTO.toString());
    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un objeto con un constructor vacio")
        void constructorVacio() {
            DomicilioDTO domicilioDTO = new DomicilioDTO();
            assertNotNull(domicilioDTO);

        }

        @Test
        @DisplayName("Se crea un objeto con un constructor con argumentos")
        void constructorConAtributos() {

            DomicilioDTO domicilioDTO = new DomicilioDTO(1L,"San Martin", "1", "Tandil", "BsAs");
            //Assert
            assertEquals(1L, domicilioDTO.getId());
            assertEquals("San Martin", domicilioDTO.getCalle());
            assertEquals("1", domicilioDTO.getNumero());
            assertEquals("Tandil", domicilioDTO.getLocalidad());
            assertEquals("BsAs", domicilioDTO.getProvincia());
        }

    }


}