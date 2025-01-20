package es.ca.andresmontoro.backoffice.localidades.provincias.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.Layout;
import es.ca.andresmontoro.backoffice.localidades.provincias.application.ManageProvinciasUseCase;

@Route(value = "provincias", layout = Layout.class)
public class ProvinciasView extends VerticalLayout {

  private final ManageProvinciasUseCase manageProvinciasUseCase;

  public ProvinciasView(ManageProvinciasUseCase manageProvinciasUseCase) {
    this.manageProvinciasUseCase = manageProvinciasUseCase;

    GridCrud<ProvinciaResponse> crud = new GridCrud<>(ProvinciaResponse.class);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("nombre", "comunidadAutonomaId");
    crud.getCrudFormFactory().setFieldCaptions("Nombre", "ID Comunidad Autónoma");

    // Personalizar el orden de las columnas en la cuadrícula
    crud.getGrid().setColumns("id", "nombre", "comunidadAutonomaId");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("comunidadAutonomaId").setHeader("ID Comunidad Autónoma");
    
    crud.setFindAllOperation(() -> manageProvinciasUseCase.findAll());
    crud.setAddOperation(this.manageProvinciasUseCase::create);
    crud.setUpdateOperation(this.manageProvinciasUseCase::update);
    crud.setDeleteOperation(this.manageProvinciasUseCase::delete);

    add(crud); 
  }

}
