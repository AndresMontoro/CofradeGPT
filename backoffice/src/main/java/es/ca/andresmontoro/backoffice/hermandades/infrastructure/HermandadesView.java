package es.ca.andresmontoro.backoffice.hermandades.infrastructure;

import org.vaadin.crudui.crud.impl.GridCrud;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import es.ca.andresmontoro.backoffice.hermandades.application.HermandadResponse;

@Route("hermandades")
public class HermandadesView extends VerticalLayout{

  public HermandadesView() {
    GridCrud<HermandadResponse> crud = new GridCrud<>(HermandadResponse.class);
    crud.getCrudFormFactory().setUseBeanValidation(true);
    crud.getCrudFormFactory().setVisibleProperties("id", "apodo", "nombre", "historia", "numeroHermanos", "fundacion");
    crud.getCrudFormFactory().setFieldCaptions("ID", "Apodo", "Nombre", "Historia", "Número de Hermanos", "Año de Fundación");

    // Personalizar el orden de las columnas en la cuadrícula
    crud.getGrid().setColumns("id", "apodo", "nombre", "historia", "numeroHermanos", "fundacion");
    crud.getGrid().getColumnByKey("id").setHeader("ID");
    crud.getGrid().getColumnByKey("apodo").setHeader("Apodo");
    crud.getGrid().getColumnByKey("nombre").setHeader("Nombre");
    crud.getGrid().getColumnByKey("historia").setHeader("Historia");
    crud.getGrid().getColumnByKey("numeroHermanos").setHeader("Número de Hermanos");
    crud.getGrid().getColumnByKey("fundacion").setHeader("Año de Fundación");
    
    add(crud); 
  }
}
