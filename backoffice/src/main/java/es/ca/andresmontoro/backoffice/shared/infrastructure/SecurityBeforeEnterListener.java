package es.ca.andresmontoro.backoffice.shared.infrastructure;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityBeforeEnterListener implements BeforeEnterListener { 
  
  @Override
  public void beforeEnter(BeforeEnterEvent event) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    if(authentication == null || !authentication.isAuthenticated()) {
      UI.getCurrent().getPage().setLocation("/oauth2/authorization/keycloak");
    }
  }
}
