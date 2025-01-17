package es.ca.andresmontoro.information.shared.infrastructure;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public interface CrudController<R, D> {
  
  @PostMapping
  R create(@RequestBody @Valid D dto);

  @GetMapping
  List<R> findAll();

  @GetMapping("/{id}")
  R findById(@PathVariable Long id);

  @PutMapping("/{id}")
  R update(@PathVariable Long id, @RequestBody @Valid D dto);

  @DeleteMapping("/{id}")
  R deleteById(@PathVariable Long id);
}