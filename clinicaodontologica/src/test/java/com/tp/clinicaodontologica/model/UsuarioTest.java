package com.tp.clinicaodontologica.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void getId() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        assertEquals(1L, usuario.getId());
    }

    @Test
    void setId() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        assertEquals(1L, usuario.getId());
    }

    @Test
    void getUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario("user");
        assertEquals("user", usuario.getUsuario());
    }

    @Test
    void setUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario("user");
        assertEquals("user", usuario.getUsuario());
    }

    @Test
    void getPassword() {
        Usuario usuario = new Usuario();
        usuario.setPassword("pass");
        assertEquals("pass", usuario.getPassword());
    }

    @Test
    void getEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("a@gmail");
        assertEquals("a@gmail", usuario.getEmail());
    }

    @Test
    void setEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("a@gmail");
        assertEquals("a@gmail", usuario.getEmail());
    }

    @Test
    void setPassword() {
        Usuario usuario = new Usuario();
        usuario.setPassword("pass");
        assertEquals("pass", usuario.getPassword());
    }


    @Test
    void getRol() {
        Usuario usuario = new Usuario();
        usuario.setRol(Rol.ADMIN);
        assertNotNull(usuario.getRol());
    }

    @Test
    void setRol() {
        Usuario usuario = new Usuario();
        usuario.setRol(Rol.ADMIN);
        assertNotNull(usuario.getRol());
    }

    @Test
    void getAuthorities() {

            }

    @Test
    void getUsername() {
    }

    @Test
    void isAccountNonExpired() {
    }

    @Test
    void isAccountNonLocked() {
    }

    @Test
    void isCredentialsNonExpired() {
    }

    @Test
    void isEnabled() {
    }
}