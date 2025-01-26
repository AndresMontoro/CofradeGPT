package es.ca.andresmontoro.information.shared.application;

public class ValidationUtils {
  private ValidationUtils() {}

  public static void validateId(Long id) {
    if(id == null || id <= 0) {
      throw new IllegalArgumentException("Invalid id");
    }
  }
}
