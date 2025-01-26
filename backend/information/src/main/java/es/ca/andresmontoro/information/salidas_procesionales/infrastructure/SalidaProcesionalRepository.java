package es.ca.andresmontoro.information.salidas_procesionales.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.salidas_procesionales.domain.SalidaProcesional;

public interface SalidaProcesionalRepository extends JpaRepository<SalidaProcesional, Long> {
  
}