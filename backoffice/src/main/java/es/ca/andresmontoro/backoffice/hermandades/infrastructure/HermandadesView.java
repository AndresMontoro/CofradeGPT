package es.ca.andresmontoro.backoffice.hermandades.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import es.ca.andresmontoro.backoffice.hermandades.application.ManageHermandadesUseCase;

@Route("hermandades")
public class HermandadesView extends VerticalLayout{

  private final ManageHermandadesUseCase manageHermandadesUseCase;

  public HermandadesView(ManageHermandadesUseCase manageHermandadesUseCase) {
    this.manageHermandadesUseCase = manageHermandadesUseCase;

    GridCrud<HermandadResponse> crud = new GridCrud<>(HermandadResponse.class);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("apodo", "nombre", "historia", "numeroHermanos", "fundacion");
    crud.getCrudFormFactory().setFieldCaptions("Apodo", "Nombre", "Historia", "Número de Hermanos", "Año de Fundación");

    crud.getCrudFormFactory().setFieldProvider("historia", field -> {
      TextArea textArea = new TextArea();
      textArea.getStyle().set("minHeight", "300px");
      textArea.getStyle().set("minWidth", "300px");
      textArea.setPlaceholder("Historia de la hermandad");
      textArea.setRequired(true);
      return textArea;
    });

    // Personalizar el orden de las columnas en la cuadrícula
    crud.getGrid().setColumns("id", "apodo", "nombre", "historia", "numeroHermanos", "fundacion");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("apodo").setHeader("Apodo");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("historia").setHeader("Historia");
    crud.getGrid().getColumnByKey("numeroHermanos").setHeader("Número de Hermanos");
    crud.getGrid().getColumnByKey("fundacion").setHeader("Año de Fundación");
    
    crud.setFindAllOperation(() -> manageHermandadesUseCase.findAll());
    crud.setAddOperation(this.manageHermandadesUseCase::create);
    crud.setUpdateOperation(this.manageHermandadesUseCase::update);
    crud.setDeleteOperation(this.manageHermandadesUseCase::delete);

    add(crud); 
  }
}
