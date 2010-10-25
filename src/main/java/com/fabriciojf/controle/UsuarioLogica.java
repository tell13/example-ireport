package com.fabriciojf.controle;

import javax.persistence.EntityManager;
import com.fabriciojf.entidade.Usuario;
import com.fabriciojf.util.JpaUtil;

/**
 * Controller de Usuario
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class UsuarioLogica {
    private Usuario usuario;

    /*
     * Note que em JPA toda atualização na base de dados precisa estar dentro
     * de uma transação. Veja a classe UsuarioLogicaEx para uma forma mais
     * interessante de resolver este problema.
     */

    public Usuario salva(Usuario usuario) {
        Usuario u = null;
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            u = em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
        return u;
    }

    public void remove(Usuario usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.remove(usuario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        }
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
