package com.tp.clinicaodontologica.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tp.clinicaodontologica.exceptions.ResourceNotFoundException;
import com.tp.clinicaodontologica.model.Odontologo;
import com.tp.clinicaodontologica.model.OdontologoDTO;
import com.tp.clinicaodontologica.service.OdontologoService;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;


@RestController
@RequestMapping("api/v1/odontologo")
public class OdontologoController {

    final static Logger log = Logger.getLogger(OdontologoController.class);
    private final OdontologoService odontologoService;
    private final ObjectMapper mapper;

    public OdontologoController(OdontologoService odontologoService, ObjectMapper mapper) {
        this.odontologoService = odontologoService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> crearOdontolog(@RequestBody OdontologoDTO odontologoDTO){
        odontologoService.crearOdontologo(odontologoDTO);
        log.info("Se creó un odontologo");
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

   @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> buscar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<OdontologoDTO> respuesta;
        if (odontologoService.buscarPorId(id).isPresent()) {
            log.info("get del odontologo id: " + id);
            respuesta = ResponseEntity.ok(odontologoService.buscarPorId(id).get());
        } else {
            respuesta = ResponseEntity.status(HttpStatus.NOT_FOUND).build();log.error("Id no encontrado");
        }
        return respuesta;
    }

    @PutMapping
    public ResponseEntity<HttpStatus> modificar(@RequestBody OdontologoDTO odontologoDTO) throws ResourceNotFoundException {
        ResponseEntity<HttpStatus> response = null;
        if (odontologoService.buscarPorId(odontologoDTO.getId()).isPresent()){
            odontologoService.modificarOdontologo(odontologoDTO);
            Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
            response = ResponseEntity.status(HttpStatus.OK).build();
            log.info("put odontologo: " + odontologo.toString());
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("No se encontró el odontologo: " + odontologoDTO.getId());
        }
        return response;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) throws ResourceNotFoundException {
        ResponseEntity<String> response = null;
        if (odontologoService.buscarPorId(id).isPresent()) {
            odontologoService.eliminarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
            log.info("Se elimino el odontologo id: " + id);
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            log.error("No se encontró el odontologo: " + id);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> buscarTodos(){
        log.info("listando todos los odontologos");
        return ResponseEntity.ok(odontologoService.listarTodos());
    }
}
