package com.tp.clinicaodontologica.service;

import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Paciente;
import com.tp.clinicaodontologica.model.PacienteDTO;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    Optional<Paciente> crearPaciente(PacienteDTO pacienteDTO);
    Optional<PacienteDTO> buscarPorId(Long id) throws ReadOnlyFileSystemException, ResourceNotFoundException;
    void modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException;
    void eliminarPorId(Long id);
    Set<PacienteDTO> listarTodos();

}
