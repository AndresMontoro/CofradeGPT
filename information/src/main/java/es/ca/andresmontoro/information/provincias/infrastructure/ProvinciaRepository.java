package es.ca.andresmontoro.information.provincias.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.provincias.domain.Provincia;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
  
}
