package es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure;

import java.util.List;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.localidades.comunidades.application.ManageComunidadUseCase;
import es.ca.andresmontoro.backoffice.localidades.comunidades.infrastructure.ComunidadAutonomaResponse;
import es.ca.andresmontoro.backoffice.localidades.provincias.application.ManageProvinciasUseCase;

@Route(value = "provincias", layout = Layout.class)
public class ProvinciasView extends VerticalLayout {

  private final ManageProvinciasUseCase manageProvinciasUseCase;
  private final ManageComunidadUseCase manageComunidadUseCase;

  public ProvinciasView(ManageProvinciasUseCase manageProvinciasUseCase,
  ManageComunidadUseCase manageComunidadUseCase) {
    this.manageProvinciasUseCase = manageProvinciasUseCase;
    this.manageComunidadUseCase = manageComunidadUseCase;

    GridCrud<ProvinciaResponse> crud = new GridCrud<>(ProvinciaResponse.class);
    configureCrud(crud);
    add(crud); 
  }

  private void configureCrud(GridCrud<ProvinciaResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre", "comunidadAutonomaId");
    crud.getCrudFormFactory().setFieldCaptions("Nombre", "Comunidad Autonoma");

    crud.getCrudFormFactory().setFieldProvider("comunidadAutonomaId", field -> createComunidadComboBox());
    
    configureGrid(crud);
    
    crud.setFindAllOperation(() -> manageProvinciasUseCase.findAll());
    crud.setAddOperation(provincia -> {
      try {
        return manageProvinciasUseCase.create(provincia);
      } catch (Exception e) {
        showErrorNotification("Error al agregar la formación musical: " + e.getMessage());
        return null;
      }
    });
    crud.setUpdateOperation(provincia -> {
      try {
        return manageProvinciasUseCase.update(provincia);
      } catch (Exception e) {
        showErrorNotification("Error al actualizar la formación musical: " + e.getMessage());
        return null;
      }
    });
    crud.setDeleteOperation(provincia -> {
      try {
        manageProvinciasUseCase.delete(provincia);
      } catch (Exception e) {
        showErrorNotification("Error al eliminar la formación musical: " + e.getMessage());
      }
    });
  }

  private ComboBox<String> createComunidadComboBox() {
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.setLabel("Comunidad Autónoma");

    List<ComunidadAutonomaResponse> comunidades = manageComunidadUseCase.findAll();

    // Configurar el ComboBox
    comboBox.setItems(comunidades.stream()
        .map(provincia -> String.valueOf(provincia.getId()))
        .toList());
    comboBox.setItemLabelGenerator(id -> generateComunidadLabel(id, comunidades));

    return comboBox;
  }

  private String generateComunidadLabel(String id, List<ComunidadAutonomaResponse> comunidades) {
    return comunidades.stream()
        .filter(c -> String.valueOf(c.getId()).equals(id))
        .map(c -> c.getNombre() + " (ID: " + c.getId() + ")")
        .findFirst()
        .orElse(id);
  }

  private void configureGrid(GridCrud<ProvinciaResponse> crud) {
    crud.getGrid().setColumns("id", "nombre", "comunidadAutonomaNombre");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("comunidadAutonomaNombre").setHeader("Comunidad Autonoma");
  }

  private void showErrorNotification(String message) {
    Notification notification = new Notification(message, 3000, Position.MIDDLE);
    notification.open();
  }
}
