package com.tp.clinicaodontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="odontologo")
public class Odontologo {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Integer matricula;

    @Column
    @OneToMany(mappedBy = "odontologo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Turno> turnos;

    public Odontologo(Long id, String nombre, String apellido, Integer matricula) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
