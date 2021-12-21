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
import model.Autor;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean implements Serializable {

    private String nombre;
    private String nacionalidad;
    private List<Autor> listaAutor;
    @EJB
    private AutorFacade ejbFacade;

    @PostConstruct
    public void init() {

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

    public List<Autor> getListaAutor() {
        return listaAutor;
    }

    public void setListaAutor(List<Autor> listaAutor) {
        this.listaAutor = listaAutor;
    }

}
