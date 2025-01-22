package es.ca.andresmontoro.backoffice.localidades.ciudades.infrastructure;

import java.util.List;

import org.vaadin.crudui.crud.impl.GridCrud;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.localidades.ciudades.application.ManageCiudadesUseCase;
import es.ca.andresmontoro.backoffice.localidades.provincias.application.ManageProvinciasUseCase;
import es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure.ProvinciaResponse;

@Route(value = "ciudades", layout = Layout.class)
public class CiudadesView extends VerticalLayout {

  private final ManageCiudadesUseCase manageCiudadesUseCase;
  private final ManageProvinciasUseCase manageProvinciasUseCase;

  public CiudadesView(ManageCiudadesUseCase manageCiudadesUseCase,
  ManageProvinciasUseCase manageProvinciasUseCase) {
    this.manageCiudadesUseCase = manageCiudadesUseCase;
    this.manageProvinciasUseCase = manageProvinciasUseCase;

    GridCrud<CiudadResponse> crud = new GridCrud<>(CiudadResponse.class);
    configureCrud(crud);

    add(crud); 
  }

  private void configureCrud(GridCrud<CiudadResponse> crud) {
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre", "provinciaId");
    crud.getCrudFormFactory().setFieldCaptions("Nombre", "ID Provincia");

    crud.getCrudFormFactory().setFieldProvider("provinciaId", field -> createProvinciaComboBox());
    
    configureGrid(crud);
    
    crud.setFindAllOperation(() -> manageCiudadesUseCase.findAll());
    crud.setAddOperation(this.manageCiudadesUseCase::create);
    crud.setUpdateOperation(this.manageCiudadesUseCase::update);
    crud.setDeleteOperation(this.manageCiudadesUseCase::delete);
  }

  private ComboBox<String> createProvinciaComboBox() {
    ComboBox<String> comboBox = new ComboBox<>();
    comboBox.setLabel("Provincia");

    // Obtener las provincias
    List<ProvinciaResponse> provincias = manageProvinciasUseCase.findAll();

    // Configurar el ComboBox
    comboBox.setItems(provincias.stream()
      .map(provincia -> String.valueOf(provincia.getId()))
      .toList());
    comboBox.setItemLabelGenerator(id -> generateProvinciaLabel(id, provincias));

    return comboBox;
  }

  private String generateProvinciaLabel(String id, List<ProvinciaResponse> provincias) {
    return provincias.stream()
        .filter(p -> String.valueOf(p.getId()).equals(id))
        .map(p -> p.getNombre() + " (ID: " + p.getId() + ")")
        .findFirst()
        .orElse(id);
  }

  private void configureGrid(GridCrud<CiudadResponse> crud) {
    crud.getGrid().setColumns("id", "nombre", "provinciaNombre");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("provinciaNombre").setHeader("Nombre Provincia");
  }
}
