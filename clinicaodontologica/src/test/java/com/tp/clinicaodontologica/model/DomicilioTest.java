package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DomicilioTest {

    @Test
    void getId() {
        Domicilio domicilio = new Domicilio();
        domicilio.setId(1L);
        assertEquals(1L, domicilio.getId());
    }

    @Test
    void getCalle() {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Mitre");
        assertEquals("Mitre", domicilio.getCalle());
    }

    @Test
    void getNumero() {
        Domicilio domicilio = new Domicilio();
        domicilio.setNumero("123");
        assertEquals("123", domicilio.getNumero());
    }

    @Test
    void getLocalidad() {
        Domicilio domicilio = new Domicilio();
        domicilio.setLocalidad("Tandil");
        assertEquals("Tandil", domicilio.getLocalidad());
    }

    @Test
    void getProvincia() {
        Domicilio domicilio = new Domicilio();
        domicilio.setProvincia("BsAs");
        assertEquals("BsAs", domicilio.getProvincia());
    }

    @Test
    void setId() {
        Domicilio domicilio = new Domicilio();
        domicilio.setId(1L);
        assertEquals(1L, domicilio.getId());
    }

    @Test
    void setCalle() {
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Mitre");
        assertEquals("Mitre", domicilio.getCalle());
    }

    @Test
    void setNumero() {
        Domicilio domicilio = new Domicilio();
        domicilio.setNumero("123");
        assertEquals("123", domicilio.getNumero());
    }

    @Test
    void setLocalidad() {
        Domicilio domicilio = new Domicilio();
        domicilio.setLocalidad("Tandil");
        assertEquals("Tandil", domicilio.getLocalidad());
    }

    @Test
    void setProvincia() {
        Domicilio domicilio = new Domicilio();
        domicilio.setProvincia("BsAs");
        assertEquals("BsAs", domicilio.getProvincia());
    }

    @Test
    void testToString() {
        Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
        assertEquals("Domicilio(id=1, calle=San Martin, numero=1, localidad=Tandil, provincia=BsAs)", domicilio.toString());
    }

    @Nested
    @DisplayName("Tests Constructor ")
    public class PruebaConstructor{

        @Test
        @DisplayName("Se crea un objeto con un constructor vacio")
        void constructorVacio() {
            Domicilio domicilio = new Domicilio();
            assertNotNull(domicilio);

        }

        @Test
        @DisplayName("Se crea un objeto con un constructor con argumentos")
        void constructorConAtributos() {

            Domicilio domicilio = new Domicilio(1L,"San Martin", "1", "Tandil", "BsAs");
            //Assert
            assertEquals(1L, domicilio.getId());
            assertEquals("San Martin", domicilio.getCalle());
            assertEquals("1", domicilio.getNumero());
            assertEquals("Tandil", domicilio.getLocalidad());
            assertEquals("BsAs", domicilio.getProvincia());
        }

    }
}