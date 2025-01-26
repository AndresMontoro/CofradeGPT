package es.ca.andresmontoro.information.comunidades.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.comunidades.domain.ComunidadAutonoma;

public interface ComunidadAutonomaRepository extends JpaRepository<ComunidadAutonoma, Long> {
  
}
