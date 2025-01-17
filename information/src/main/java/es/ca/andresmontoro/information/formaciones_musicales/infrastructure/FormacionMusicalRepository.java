package es.ca.andresmontoro.information.formaciones_musicales.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.information.formaciones_musicales.domain.FormacionMusical;

public interface FormacionMusicalRepository extends JpaRepository<FormacionMusical, Long> {
  
}
