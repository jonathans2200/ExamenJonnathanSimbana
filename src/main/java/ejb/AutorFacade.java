/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public Autor obtenerUsuario(int id) throws Exception {
        try {
            String jpl = "select p from Autor p Where p.idAutor =:usu";
            Query q = em.createQuery(jpl, Autor.class);
            q.setParameter("usu", id);

            return (Autor) q.getSingleResult();

        } catch (NoResultException e) {

            System.out.println("No se encuentra");
        }
        return null;
    }
}
