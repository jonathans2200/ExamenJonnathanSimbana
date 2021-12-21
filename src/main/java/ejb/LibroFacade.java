/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Autor;
import model.Libro;

/**
 *
 * @author jonat
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> {

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public LibroFacade() {
        super(Libro.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
