package com.tp.clinicaodontologica.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Odontologo;
import com.tp.clinicaodontologica.model.OdontologoDTO;
import com.tp.clinicaodontologica.model.Turno;
import com.tp.clinicaodontologica.model.TurnoDTO;
import com.tp.clinicaodontologica.repository.ITurnoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TurnoService implements  ITurnoService{

    private final ITurnoRepository turnoRepository;
    private final ObjectMapper mapper;

    public TurnoService(ITurnoRepository turnoRepository, ObjectMapper mapper) {
        this.turnoRepository = turnoRepository;
        this.mapper = mapper;
    }


    @Override
    public void crearTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        turnoRepository.save(turno);
    }

    @Override
    public Optional<TurnoDTO> buscarPorId(Long id) throws ResourceNotFoundException {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDTO turnoDTO = null;
        if(turno.isPresent()){
            turnoDTO = mapper.convertValue(turno, TurnoDTO.class);
        }else{
            throw new ResourceNotFoundException(String.format("Turno no encontrado"));
        }
        return Optional.ofNullable(turnoDTO);
    }

    @Override
    public void modificarTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarPorId(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Collection<Turno> listarTodos() {
        List<Turno>turnos = turnoRepository.findAll();
        return turnos;
    }

}
