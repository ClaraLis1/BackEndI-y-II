package com.tp.clinicaodontologica.controller;

import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.OdontologoDTO;
import com.tp.clinicaodontologica.model.PacienteDTO;
import com.tp.clinicaodontologica.model.Turno;
import com.tp.clinicaodontologica.model.TurnoDTO;
import com.tp.clinicaodontologica.service.OdontologoService;
import com.tp.clinicaodontologica.service.PacienteService;
import com.tp.clinicaodontologica.service.TurnoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/turno")
public class TurnoController {
    final static Logger log = Logger.getLogger(TurnoController.class);

    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public void crearTurno(@RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> respuesta;
        Optional<PacienteDTO> paciente = pacienteService.buscarPorId(turnoDTO.getPaciente().getId());
        Optional<OdontologoDTO> odontologo = odontologoService.buscarPorId(turnoDTO.getOdontologo().getId());
        if(paciente.isPresent() && odontologo.isPresent()){
            turnoService.crearTurno(turnoDTO);
            ResponseEntity.ok(HttpStatus.CREATED);
            log.info("Se creó un turno");
        }else{
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<TurnoDTO> respuesta;
        if (turnoService.buscarPorId(id).isPresent()) {
            log.info("get del Turno id: " + id);
            respuesta = ResponseEntity.ok(turnoService.buscarPorId(id).get());
        } else {
            log.error("Id no encontrado");
            respuesta= ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return respuesta;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response;
        if (turnoService.buscarPorId(id).isPresent()) {
            turnoService.eliminarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) throws ResourceNotFoundException {
        ResponseEntity<Turno> response = null;
        if(turnoService.buscarPorId(turno.getId()).isPresent()){
            turnoService.modificarTurno(turno);
            response = ResponseEntity.status(HttpStatus.OK).build();
            log.info("Se modifico el Turno con id : " + turno.getId());
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("No se encontró el turno: " + turno.getId());
        }
        return response;
    }

    @GetMapping
    public Collection<Turno> listarTodos(){
        log.info("listando todos los turnos");
        return turnoService.listarTodos();
    }

}
