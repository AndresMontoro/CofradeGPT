package es.ca.andresmontoro.ai_models.shared.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.langchain4j.model.github.GitHubModelsChatModel;

@Configuration
public class GitHubModelsConfig {
  @Value("${githubToken}")
  private String githubModels;

  @Bean
  public GitHubModelsChatModel gitHubModelsChatModel() {
    return GitHubModelsChatModel.builder()
      .gitHubToken(githubModels)
      .modelName("gpt-4o")
      .logRequestsAndResponses(true)
      .build();
  }
}
