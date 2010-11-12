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
import aplicacao.Usuario;

/**
 *
 * @author matheusmf
 */
public class CarrinhoJpaController {

    public CarrinhoJpaController() {
        emf = Persistence.createEntityManagerFactory("ShoppingVirtualPU");
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
            Usuario usuario = carrinho.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getId());
                carrinho.setUsuario(usuario);
            }
            em.persist(carrinho);
            if (usuario != null) {
                Carrinho oldCarrinhoOfUsuario = usuario.getCarrinho();
                if (oldCarrinhoOfUsuario != null) {
                    oldCarrinhoOfUsuario.setUsuario(null);
                    oldCarrinhoOfUsuario = em.merge(oldCarrinhoOfUsuario);
                }
                usuario.setCarrinho(carrinho);
                usuario = em.merge(usuario);
            }
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
            Carrinho persistentCarrinho = em.find(Carrinho.class, carrinho.getId());
            Usuario usuarioOld = persistentCarrinho.getUsuario();
            Usuario usuarioNew = carrinho.getUsuario();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getId());
                carrinho.setUsuario(usuarioNew);
            }
            carrinho = em.merge(carrinho);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.setCarrinho(null);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                Carrinho oldCarrinhoOfUsuario = usuarioNew.getCarrinho();
                if (oldCarrinhoOfUsuario != null) {
                    oldCarrinhoOfUsuario.setUsuario(null);
                    oldCarrinhoOfUsuario = em.merge(oldCarrinhoOfUsuario);
                }
                usuarioNew.setCarrinho(carrinho);
                usuarioNew = em.merge(usuarioNew);
            }
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
                em.close();
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
            Usuario usuario = carrinho.getUsuario();
            if (usuario != null) {
                usuario.setCarrinho(null);
                usuario = em.merge(usuario);
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
            em.close();
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
