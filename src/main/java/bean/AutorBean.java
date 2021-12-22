/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.AutorFacade;
import ejb.CapituloFacade;
import ejb.LibroFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import javax.persistence.Query;
import model.Autor;
import model.Capitulo;
import model.Libro;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class AutorBean implements Serializable {

    private List<Autor> listar;
    private List<Capitulo> listarLibro;
    private List<Capitulo> listarLibro1;
    private String nombre;
    private String buscarNombre;
    private String buscarCapitulo;
    private String nacionalidad;

    @EJB
    private AutorFacade ejbFacade;

    @EJB
    private LibroFacade ejblibro;

    @EJB
    private CapituloFacade ejbCapitulo;

    @PostConstruct
    public void init() {

        listar = ejbFacade.findAll();

        buscarNombre();
        // listarLibro = ejbCapitulo.metodoBuscar2("inicio");
    }

    public void buscarNombre() {

        if (buscarNombre != null) {
            listarLibro = ejbCapitulo.metodoBuscar(buscarNombre);
        }
    }

    public void buscarCapitulo() {

        if (buscarNombre != null) {
            listarLibro1 = ejbCapitulo.metodoBuscar2(buscarCapitulo);
        }
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

    public String getBuscarNombre() {
        return buscarNombre;
    }

    public void setBuscarNombre(String buscarNombre) {
        this.buscarNombre = buscarNombre;
    }

    public String getBuscarCapitulo() {
        return buscarCapitulo;
    }

    public void setBuscarCapitulo(String buscarCapitulo) {
        this.buscarCapitulo = buscarCapitulo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Capitulo> getListarLibro() {
        return listarLibro;
    }

    public void setListarLibro(List<Capitulo> listarLibro) {
        this.listarLibro = listarLibro;
    }

    public LibroFacade getEjblibro() {
        return ejblibro;
    }

    public void setEjblibro(LibroFacade ejblibro) {
        this.ejblibro = ejblibro;
    }

    public List<Autor> getListar() {
        return listar;
    }

    public CapituloFacade getEjbCapitulo() {
        return ejbCapitulo;
    }

    public void setEjbCapitulo(CapituloFacade ejbCapitulo) {
        this.ejbCapitulo = ejbCapitulo;
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

    public List<Capitulo> getListarLibro1() {
        return listarLibro1;
    }

    public void setListarLibro1(List<Capitulo> listarLibro1) {
        this.listarLibro1 = listarLibro1;
    }

}
