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
import model.Capitulo;

/**
 *
 * @author jonat
 */
@Stateless
public class CapituloFacade extends AbstractFacade<Capitulo> {

    @PersistenceContext(unitName = "examen")
    private EntityManager em;

    public CapituloFacade() {
        super(Capitulo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}
