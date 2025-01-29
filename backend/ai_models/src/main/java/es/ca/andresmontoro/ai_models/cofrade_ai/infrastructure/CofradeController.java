package es.ca.andresmontoro.ai_models.cofrade_ai.infrastructure;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import es.ca.andresmontoro.ai_models.cofrade_ai.application.CofradeManageResponseUseCase;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/chatcofrade/ai/cofrade")
@AllArgsConstructor
public class CofradeController {

  private final CofradeManageResponseUseCase cofradeManageResponseUseCase;
  
  @PostMapping
  public String getHello(
    @RequestBody String userPrompt
  ) {
    return cofradeManageResponseUseCase.getResponse(userPrompt);
  }
}
