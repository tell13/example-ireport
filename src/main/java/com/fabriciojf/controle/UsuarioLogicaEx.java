package com.fabriciojf.controle;

import javax.persistence.EntityManager;
import com.fabriciojf.entidade.Usuario;
import com.fabriciojf.util.JpaUtil;

/**
 * Logica de Usuario exemplo 2
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class UsuarioLogicaEx {

    private Usuario usuario;
    
    private final EntityManager em;

    /*
     * Como toda alteração deve estar dentro de uma transação passe o
     * gerenciador de entidades como parâmetros. Dessa forma você pode controlar
     * a transação de fora quando executar vários métodos seguidos.
     */
    public static void main(String... args) {
        /*
         * Exemplo de uso desta classe
         */
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        try {

            Usuario novo = new Usuario();
            novo.setNome("Convidado");

            new UsuarioLogicaEx(em).salva(novo);

            em.getTransaction().commit();
        } catch (Throwable th) {
            em.getTransaction().rollback();
        }
    }

    public UsuarioLogicaEx(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public Usuario salva(Usuario usuario) {
        return getEm().merge(usuario);
    }

    public void remove(Usuario usuario) {
        getEm().remove(usuario);
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
