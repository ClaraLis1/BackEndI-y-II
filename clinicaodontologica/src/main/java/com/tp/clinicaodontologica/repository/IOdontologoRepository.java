package com.tp.clinicaodontologica.repository;

import com.tp.clinicaodontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface IOdontologoRepository extends JpaRepository<Odontologo, Long>{

    @Query("SELECT o FROM Odontologo o WHERE o.nombre =?1")
    Optional<Odontologo> buscarNombre(String nombre);

}
