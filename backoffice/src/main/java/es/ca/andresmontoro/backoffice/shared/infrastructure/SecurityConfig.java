package es.ca.andresmontoro.backoffice.shared.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(authorizeRequests -> authorizeRequests
        .requestMatchers(
          "/oauth2/authorization/keycloak", 
          "/",                              // Página principal
          "/VAADIN/**",                     // Recursos estáticos de Vaadin
          "/frontend/**",                   // Recursos frontend
          "/webjars/**",                    // Librerías web
          "/images/**",                     // Recursos de imágenes
          "/icons/**"                       // Iconos de Vaadin
        ).permitAll()
        .anyRequest().authenticated()
      )
      .oauth2Login(oauth2 -> oauth2
        .loginPage("/oauth2/authorization/keycloak")
        .defaultSuccessUrl("/hermandades", true)
      )
      .logout(logout -> logout
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Ruta para logout
        .logoutSuccessUrl("/") // Redirección tras logout
        .invalidateHttpSession(true) // Invalidar sesión
        .deleteCookies("JSESSIONID") // Eliminar cookies
        .addLogoutHandler((request, response, authentication) -> {
          try {
            String logoutUrl = "http://localhost:8181/realms/CofradeGPT/protocol/openid-connect/logout";
            response.sendRedirect(logoutUrl);
          } catch (Exception e) {
            throw new RuntimeException("Error durante la redireccion al logout", e);
          }
        })
      );

    return http.build();
  }
}
