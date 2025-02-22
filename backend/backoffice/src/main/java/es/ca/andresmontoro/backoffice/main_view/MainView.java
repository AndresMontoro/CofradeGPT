package es.ca.andresmontoro.backoffice.main_view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {
  
  public MainView() {
    add(new H1("GESTIÓN DE COFRADEGPT"));

    Button loginButton = new Button("Iniciar sesión con Keycloak", event -> {
      getUI().ifPresent(ui -> ui.getPage().setLocation("/oauth2/authorization/keycloak"));
    });

    add(loginButton);
  }
}
