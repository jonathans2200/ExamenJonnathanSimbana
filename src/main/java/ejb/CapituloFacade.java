/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public List<Capitulo> metodoBuscar(String dato) {

        String jpl = "select p from Capitulo p Where  p.autor.nombre LIKE :dato";

        Query q = em.createQuery(jpl, Capitulo.class);
        q.setParameter("dato", "%" + dato + "%");
        return (List<Capitulo>) q.getResultList();

        //return null;
    }

    public List<Capitulo> metodoBuscar2(String dato) {

        String jpl = "select p from Capitulo p Where  p.titulo LIKE :dato";

        Query q = em.createQuery(jpl, Capitulo.class);
        q.setParameter("dato", "%" + dato + "%");
        return (List<Capitulo>) q.getResultList();

        //return null;
    }

}
