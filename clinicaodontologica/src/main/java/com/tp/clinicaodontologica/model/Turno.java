package com.tp.clinicaodontologica.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="turno")

public class Turno {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="paciente_id", nullable = false)
    //@JsonIgnore
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name="odontologo_id", nullable = false)
    //@JsonIgnore
    private Odontologo odontologo;

    private LocalDate fecha;

    private LocalTime hora;


}
