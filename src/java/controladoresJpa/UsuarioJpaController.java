/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package controladoresJpa;

import aplicacao.Usuario;
import controladoresJpa.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import aplicacao.Carrinho;

/**
 *
 * @author matheusmf
 */
public class UsuarioJpaController {

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("ShoppingVirtualPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrinho carrinho = usuario.getCarrinho();
            if (carrinho != null) {
                carrinho = em.getReference(carrinho.getClass(), carrinho.getId());
                usuario.setCarrinho(carrinho);
            }
            em.persist(usuario);
            if (carrinho != null) {
                Usuario oldUsuarioOfCarrinho = carrinho.getUsuario();
                if (oldUsuarioOfCarrinho != null) {
                    oldUsuarioOfCarrinho.setCarrinho(null);
                    oldUsuarioOfCarrinho = em.merge(oldUsuarioOfCarrinho);
                }
                carrinho.setUsuario(usuario);
                carrinho = em.merge(carrinho);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getId());
            Carrinho carrinhoOld = persistentUsuario.getCarrinho();
            Carrinho carrinhoNew = usuario.getCarrinho();
            if (carrinhoNew != null) {
                carrinhoNew = em.getReference(carrinhoNew.getClass(), carrinhoNew.getId());
                usuario.setCarrinho(carrinhoNew);
            }
            usuario = em.merge(usuario);
            if (carrinhoOld != null && !carrinhoOld.equals(carrinhoNew)) {
                carrinhoOld.setUsuario(null);
                carrinhoOld = em.merge(carrinhoOld);
            }
            if (carrinhoNew != null && !carrinhoNew.equals(carrinhoOld)) {
                Usuario oldUsuarioOfCarrinho = carrinhoNew.getUsuario();
                if (oldUsuarioOfCarrinho != null) {
                    oldUsuarioOfCarrinho.setCarrinho(null);
                    oldUsuarioOfCarrinho = em.merge(oldUsuarioOfCarrinho);
                }
                carrinhoNew.setUsuario(usuario);
                carrinhoNew = em.merge(carrinhoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = usuario.getId();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            Carrinho carrinho = usuario.getCarrinho();
            if (carrinho != null) {
                carrinho.setUsuario(null);
                carrinho = em.merge(carrinho);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Usuario as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuario(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Usuario as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
