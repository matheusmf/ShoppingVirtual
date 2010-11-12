/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controladoresJpa;

import aplicacao.Loja;
import controladoresJpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author matheusmf
 */
public class LojaJpaController {

    public LojaJpaController() {
        emf = Persistence.createEntityManagerFactory("PrimeiroIncrementoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Loja loja) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(loja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Loja loja) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            loja = em.merge(loja);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = loja.getId();
                if (findLoja(id) == null) {
                    throw new NonexistentEntityException("The loja with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loja loja;
            try {
                loja = em.getReference(Loja.class, id);
                loja.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loja with id " + id + " no longer exists.", enfe);
            }
            em.remove(loja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Loja> findLojaEntities() {
        return findLojaEntities(true, -1, -1);
    }

    public List<Loja> findLojaEntities(int maxResults, int firstResult) {
        return findLojaEntities(false, maxResults, firstResult);
    }

    private List<Loja> findLojaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Loja as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Loja findLoja(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Loja.class, id);
        } finally {
            em.close();
        }
    }

    public int getLojaCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Loja as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
