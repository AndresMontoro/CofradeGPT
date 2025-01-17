package es.ca.andresmontoro.ai_models.cofrade_ai.application;

import org.jetbrains.annotations.NotNull;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class LoggingDTO {

  @NotNull
  @NotEmpty
  @NotBlank
  private String userPrompt;

  @NotNull
  @NotEmpty
  @NotBlank
  private String aiResponse;
}
