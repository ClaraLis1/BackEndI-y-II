package com.tp.clinicaodontologica.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Paciente;
import com.tp.clinicaodontologica.model.PacienteDTO;
import com.tp.clinicaodontologica.service.IDomicilioService;
import com.tp.clinicaodontologica.service.IPacienteService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {
    final static Logger log = Logger.getLogger(PacienteController.class);

    private final IPacienteService pacienteService;
    private final IDomicilioService domicilioService;
    private final ObjectMapper mapper;

    public PacienteController(IPacienteService pacienteService, IDomicilioService domicilioService, ObjectMapper mapper) {
        this.pacienteService = pacienteService;
        this.domicilioService = domicilioService;
        this.mapper = mapper;
    }

    @PostMapping
    public Optional<Paciente> crearPaciente(@RequestBody PacienteDTO pacienteDTO){
        Optional<Paciente> paciente = pacienteService.crearPaciente(pacienteDTO);
        if(paciente.isPresent())
        ResponseEntity.ok(HttpStatus.CREATED);
        log.info("Se creó un paciente");
        return  paciente;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<PacienteDTO> respuesta;
        if(pacienteService.buscarPorId(id).isPresent()){
            log.info("get del paciente id: " + id);
            respuesta =  ResponseEntity.ok(pacienteService.buscarPorId(id).get());
        }else{
            // En get uso not Found
            respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("Id no encontrado");
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<HttpStatus> modificar(@RequestBody PacienteDTO pacienteDTO) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response = null;
        if(pacienteService.buscarPorId(pacienteDTO.getId()).isPresent()) {
            pacienteService.modificarPaciente(pacienteDTO);
            response = ResponseEntity.status(HttpStatus.OK).build();
            log.info("Se modifico el paciente con id : " + pacienteDTO.getId());
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("No se encontró el paciente: " + pacienteDTO.getId());
        }
        return response;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        if (pacienteService.buscarPorId(id).isPresent()) {
            pacienteService.eliminarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            log.info("Se elimino el paciente id: " + id);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("No se encontró el paciente: " + id);
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDTO>> buscarTodos(){
        log.info("listando todos los pacientes");
        return ResponseEntity.ok(pacienteService.listarTodos());
    }
}
