/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controladoresJpa;

import aplicacao.Carrinho;
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
public class CarrinhoJpaController {

    public CarrinhoJpaController() {
        emf = Persistence.createEntityManagerFactory("PrimeiroIncrementoPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carrinho carrinho) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrinho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carrinho carrinho) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            carrinho = em.merge(carrinho);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = carrinho.getId();
                if (findCarrinho(id) == null) {
                    throw new NonexistentEntityException("The carrinho with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
               //em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrinho carrinho;
            try {
                carrinho = em.getReference(Carrinho.class, id);
                carrinho.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrinho with id " + id + " no longer exists.", enfe);
            }
            em.remove(carrinho);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carrinho> findCarrinhoEntities() {
        return findCarrinhoEntities(true, -1, -1);
    }

    public List<Carrinho> findCarrinhoEntities(int maxResults, int firstResult) {
        return findCarrinhoEntities(false, maxResults, firstResult);
    }

    private List<Carrinho> findCarrinhoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Carrinho as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Carrinho findCarrinho(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrinho.class, id);
        } finally {
            //em.close();
        }
    }

    public int getCarrinhoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Carrinho as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
