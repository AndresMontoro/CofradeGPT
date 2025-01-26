package es.ca.andresmontoro.information.hermandades.domain;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Hermandad {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "El apodo no puede ser nulo")
  @NotEmpty(message = "El apodo no puede estar vacío")
  @Column(unique = true)
  @Size(max = 64, message = "El apodo no puede tener más de 64 caracteres")
  // TODO: @NoSpecialCharacters
  private String apodo;

  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @Column(unique = true)
  @Size(max = 1024, message = "El nombre no puede tener más de 1024 caracteres")
  // @NoSpecialCharacters
  private String nombre;

  @NotNull(message = "La historia no puede ser nula")
  @NotEmpty(message = "La historia no puede estar vacía")
  @NotBlank(message = "La historia no puede estar en blanco")
  private String historia;

  @NotNull(message = "El número de hermanos no puede ser nulo")
  @Range(min = 0, message = "El número de hermanos no puede ser negativo")
  private Integer numeroHermanos;

  @NotNull(message = "La fecha de fundación no puede ser nula")
  @PastOrPresent(message = "La fecha de fundación no puede ser futura")
  private LocalDate fundacion;
}
