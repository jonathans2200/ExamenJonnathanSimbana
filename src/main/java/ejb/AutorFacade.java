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

/**
 *
 * @author jonat
 */
@Stateless
public class AutorFacade extends AbstractFacade<Autor> {

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public AutorFacade() {
        super(Autor.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
