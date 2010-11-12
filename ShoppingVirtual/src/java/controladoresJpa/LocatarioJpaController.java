/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controladoresJpa;

import aplicacao.Locatario;
import controladoresJpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import aplicacao.Loja;

/**
 *
 * @author matheusmf
 */
public class LocatarioJpaController {

    public LocatarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ShoppingVirtualPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Locatario locatario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loja loja = locatario.getLoja();
            if (loja != null) {
                loja = em.getReference(loja.getClass(), loja.getId());
                locatario.setLoja(loja);
            }
            em.persist(locatario);
            if (loja != null) {
                Locatario oldDonoLojaOfLoja = loja.getDonoLoja();
                if (oldDonoLojaOfLoja != null) {
                    oldDonoLojaOfLoja.setLoja(null);
                    oldDonoLojaOfLoja = em.merge(oldDonoLojaOfLoja);
                }
                loja.setDonoLoja(locatario);
                loja = em.merge(loja);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Locatario locatario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Locatario persistentLocatario = em.find(Locatario.class, locatario.getId());
            Loja lojaOld = persistentLocatario.getLoja();
            Loja lojaNew = locatario.getLoja();
            if (lojaNew != null) {
                lojaNew = em.getReference(lojaNew.getClass(), lojaNew.getId());
                locatario.setLoja(lojaNew);
            }
            locatario = em.merge(locatario);
            if (lojaOld != null && !lojaOld.equals(lojaNew)) {
                lojaOld.setDonoLoja(null);
                lojaOld = em.merge(lojaOld);
            }
            if (lojaNew != null && !lojaNew.equals(lojaOld)) {
                Locatario oldDonoLojaOfLoja = lojaNew.getDonoLoja();
                if (oldDonoLojaOfLoja != null) {
                    oldDonoLojaOfLoja.setLoja(null);
                    oldDonoLojaOfLoja = em.merge(oldDonoLojaOfLoja);
                }
                lojaNew.setDonoLoja(locatario);
                lojaNew = em.merge(lojaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = locatario.getId();
                if (findLocatario(id) == null) {
                    throw new NonexistentEntityException("The locatario with id " + id + " no longer exists.");
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
            Locatario locatario;
            try {
                locatario = em.getReference(Locatario.class, id);
                locatario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The locatario with id " + id + " no longer exists.", enfe);
            }
            Loja loja = locatario.getLoja();
            if (loja != null) {
                loja.setDonoLoja(null);
                loja = em.merge(loja);
            }
            em.remove(locatario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Locatario> findLocatarioEntities() {
        return findLocatarioEntities(true, -1, -1);
    }

    public List<Locatario> findLocatarioEntities(int maxResults, int firstResult) {
        return findLocatarioEntities(false, maxResults, firstResult);
    }

    private List<Locatario> findLocatarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Locatario as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Locatario findLocatario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Locatario.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocatarioCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Locatario as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
