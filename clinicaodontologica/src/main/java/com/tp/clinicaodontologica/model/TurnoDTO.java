package com.tp.clinicaodontologica.model;

import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class TurnoDTO {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDate fecha;
    private LocalTime hora;


}
