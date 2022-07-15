package com.tp.clinicaodontologica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Paciente;
import com.tp.clinicaodontologica.model.PacienteDTO;
import com.tp.clinicaodontologica.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    private final IPacienteRepository pacienteRepository;
    private final ObjectMapper mapper;
    private static SimpleDateFormat toStringDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public PacienteService(IPacienteRepository pacienteRepository, ObjectMapper mapper) {
        this.pacienteRepository = pacienteRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Paciente> crearPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        LocalDateTime fecha = LocalDateTime.now();
        paciente.setFechaIngreso(fecha);
        pacienteRepository.save(paciente);
        return Optional.ofNullable(paciente) ;
    }

    @Override
    public Optional<PacienteDTO> buscarPorId(Long id) throws ResourceNotFoundException {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDTO pacienteDTO = null;
        if(paciente.isPresent()){
            pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
        }else{
            throw new ResourceNotFoundException(String.format("paciente no encontrado"));
        }
        return Optional.ofNullable(pacienteDTO) ;
    }


   @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) throws ResourceNotFoundException {

       Optional<PacienteDTO> pacienteDTO1 = buscarPorId(pacienteDTO.getId());
       LocalDateTime fecha = pacienteDTO1.get().getFechaIngreso();
       Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
       paciente.setFechaIngreso(fecha);
       pacienteRepository.save(paciente);
    }


    @Override
    public void eliminarPorId(Long id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public Set<PacienteDTO> listarTodos() {
        List<Paciente> pacientes =pacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes ) {
            PacienteDTO pacienteDTO = mapper.convertValue(paciente, PacienteDTO.class);
            pacientesDTO.add(pacienteDTO);
        }
        return pacientesDTO;
    }
}

