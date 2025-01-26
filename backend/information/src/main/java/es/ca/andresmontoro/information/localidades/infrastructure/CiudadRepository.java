package es.ca.andresmontoro.information.localidades.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.localidades.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
  
}
