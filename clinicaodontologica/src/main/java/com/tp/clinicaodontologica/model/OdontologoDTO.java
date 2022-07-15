package com.tp.clinicaodontologica.model;

import lombok.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;

}
