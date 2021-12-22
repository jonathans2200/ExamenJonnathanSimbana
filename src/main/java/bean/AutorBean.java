/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AutorFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.persistence.Query;
import model.Autor;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean implements Serializable {

    private List<Autor> listar;
    private String nombre;
    private String nacionalidad;

    @EJB
    private AutorFacade ejbFacade;

    @PostConstruct
    public void init() {
        listar = ejbFacade.findAll();
    }

    public AutorFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(AutorFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Autor> getListar() {
        return listar;
    }

    public void setListar(List<Autor> listar) {
        this.listar = listar;
    }

    public String crear() {

        Autor a = new Autor();
        a.setNombre(nombre);
        a.setNacionalidad(nacionalidad);
        ejbFacade.crear(a);
        listar = ejbFacade.findAll();
        return null;

    }

    

}
