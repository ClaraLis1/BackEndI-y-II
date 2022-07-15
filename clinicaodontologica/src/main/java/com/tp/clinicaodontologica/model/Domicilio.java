package com.tp.clinicaodontologica.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="domicilio")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Long id;

    @Column
    private String calle;

    @Column
    private String numero;

    @Column
    private String localidad;

    @Column
    private String provincia;

    public Domicilio(String calle, String numero, String ciudad, String provincia) {

    }

}
