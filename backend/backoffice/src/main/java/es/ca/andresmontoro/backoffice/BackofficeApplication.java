package es.ca.andresmontoro.backoffice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;

@SpringBootApplication
@PWA(name = "Backoffice", shortName = "Backoffice")
public class BackofficeApplication implements AppShellConfigurator{

	public static void main(String[] args) {
		SpringApplication.run(BackofficeApplication.class, args);
	}

}
