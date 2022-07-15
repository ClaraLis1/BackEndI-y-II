package com.tp.clinicaodontologica.service;

import com.tp.clinicaodontologica.model.Domicilio;

import java.util.Optional;
import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio(Domicilio domicilio);
    Optional<Domicilio> buscarPorId(Long id);
    void modificarDomicilio(Domicilio domicilio);
    void eliminarPorId(Long id);
    Set<Domicilio> listarTodos();
}
