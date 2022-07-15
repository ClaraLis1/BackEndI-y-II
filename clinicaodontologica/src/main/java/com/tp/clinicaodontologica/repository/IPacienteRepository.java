package com.tp.clinicaodontologica.repository;

import com.tp.clinicaodontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IPacienteRepository extends JpaRepository<Paciente, Long> {


}
