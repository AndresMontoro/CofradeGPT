package es.ca.andresmontoro.information.shared.application;

import java.util.List;

public interface CrudService <T> {
  T create(T request);
  List<T> findAll();
  T findById(Long id);
  T update(Long id, T request);
  T delete(Long id);
}
