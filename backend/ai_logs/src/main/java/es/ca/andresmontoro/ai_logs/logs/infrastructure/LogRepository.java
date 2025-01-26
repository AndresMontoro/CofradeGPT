package es.ca.andresmontoro.ai_logs.logs.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import es.ca.andresmontoro.ai_logs.logs.domain.Log;

public interface LogRepository extends JpaRepository<Log, Long> {
  
}
