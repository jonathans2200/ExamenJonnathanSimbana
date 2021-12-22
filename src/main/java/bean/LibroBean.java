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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
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
public class LibroBean implements Serializable {

    @EJB
    private LibroFacade ejbLibro;

    @EJB
    private AutorFacade ejbAutor;

    @EJB
    private CapituloFacade ejbCapitulo;

    private String nombre;
    private String buscar;
    private int numPagina;
    private Autor autor;
    private List<Capitulo> capitulos;
    private String isbn;

    private int numero;
    private String titulo;

    @PostConstruct
    public void init() {
        capitulos = new ArrayList<Capitulo>();
    }

    public String crear() {
        Libro l = new Libro();
        l.setNombre(nombre);
        l.setNumPagina(numPagina);
        l.setIsbn(isbn);
        ejbLibro.crear(l);
        return null;
    }

    public LibroFacade getEjbLibro() {
        return ejbLibro;
    }

    public void setEjbLibro(LibroFacade ejbLibro) {
        this.ejbLibro = ejbLibro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumPagina() {
        return numPagina;
    }

    public void setNumPagina(int numPagina) {
        this.numPagina = numPagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public AutorFacade getEjbAutor() {
        return ejbAutor;
    }

    public void setEjbAutor(AutorFacade ejbAutor) {
        this.ejbAutor = ejbAutor;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void buscarAutor() throws Exception {
        autor = ejbAutor.obtenerUsuario(Integer.parseInt(buscar));
    }

    public CapituloFacade getEjbCapitulo() {
        return ejbCapitulo;
    }

    public void setEjbCapitulo(CapituloFacade ejbCapitulo) {
        this.ejbCapitulo = ejbCapitulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String crearLibro() {

        Libro libro = new Libro();

        libro.setNombre(nombre);
        libro.setIsbn(isbn);
        libro.setNumPagina(numPagina);
        ejbLibro.crear(libro);

        Capitulo cap = new Capitulo();

        for (int i = 0; i < capitulos.size(); i++) {
            cap.setTitulo(capitulos.get(i).getTitulo());
            cap.setNumero(capitulos.get(i).getNumero());
            cap.setAutor(capitulos.get(i).getAutor());
            cap.setLibro(libro);
            ejbCapitulo.crear(cap);
        }

        return null;
    }

    public void add() {

        Capitulo cap = new Capitulo();
        cap.setNumero(numero);
        cap.setTitulo(titulo);
        cap.setAutor(autor);

        capitulos.add(cap);

        for (int i = 0; i < capitulos.size(); i++) {
            System.out.println(capitulos.get(i).getTitulo());
        }
    }
}
