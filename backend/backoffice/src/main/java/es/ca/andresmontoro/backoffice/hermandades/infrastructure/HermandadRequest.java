package es.ca.andresmontoro.backoffice.hermandades.infrastructure;

import java.time.LocalDate;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HermandadRequest {
  @NotNull(message = "El apodo no puede ser nulo")
  @NotEmpty(message = "El apodo no puede estar vacío")
  @Size(max = 64, message = "El apodo no puede tener más de 64 caracteres")
  // TODO: @NoSpecialCharacters
  private String apodo;

  @NotNull(message = "El nombre no puede ser nulo")
  @NotEmpty(message = "El nombre no puede estar vacío")
  @Size(max = 1024, message = "El nombre no puede tener más de 1024 caracteres")
  // @NoSpecialCharacters
  private String nombre;

  @NotNull
  @NotEmpty
  private String historia;

  @NotNull
  @Range(min = 0)
  private Integer numeroHermanos;

  @NotNull
  @PastOrPresent
  private LocalDate fundacion;
}
