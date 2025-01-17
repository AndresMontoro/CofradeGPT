package es.ca.andresmontoro.information.hermandades.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.hermandades.domain.Hermandad;

public interface HermandadRepository extends JpaRepository<Hermandad, Long> {
  
}
