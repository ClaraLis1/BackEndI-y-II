package com.tp.clinicaodontologica.service;

import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Odontologo;
import com.tp.clinicaodontologica.model.OdontologoDTO;

import java.util.Optional;
import java.util.Set;

public interface IOdontologoService {
    void crearOdontologo(OdontologoDTO odontologoDTO);
    Optional<OdontologoDTO> buscarPorId(Long id) throws ResourceNotFoundException;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void eliminarPorId(Long id);
    Set<OdontologoDTO> listarTodos();
}
