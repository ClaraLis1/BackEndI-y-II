package com.tp.clinicaodontologica.service;

import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Turno;
import com.tp.clinicaodontologica.model.TurnoDTO;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ITurnoService {
    void crearTurno(TurnoDTO turnoDTO);
    Optional<TurnoDTO> buscarPorId(Long id) throws ResourceNotFoundException;
    void modificarTurno(Turno turno);
    void eliminarPorId(Long id);
    Collection<Turno> listarTodos();
}
