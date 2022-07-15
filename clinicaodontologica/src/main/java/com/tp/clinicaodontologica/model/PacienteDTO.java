package com.tp.clinicaodontologica.model;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PacienteDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDateTime fechaIngreso;
    private Domicilio domicilio;
}
