package com.tp.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String dni;

    @Column
    private LocalDateTime fechaIngreso;

    @Column
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Turno> turnos;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="id_domicilio")
    private Domicilio domicilio;

    public Paciente( String nombre, String apellido, String dni, LocalDateTime fechaIngreso, Domicilio domicilio) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }
}
