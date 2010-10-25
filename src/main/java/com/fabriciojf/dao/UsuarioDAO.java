package com.fabriciojf.dao;

import java.util.List;
import javax.persistence.Query;
import com.fabriciojf.entidade.Usuario;
import com.fabriciojf.util.JpaUtil;

/**
 * Exemplo de Classe DAO
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class UsuarioDAO {

    /**
     * Lista todos os registros
     */
    public List<Usuario> listaTodos() {
        String oql = "from " + Usuario.class.getName();
        return JpaUtil.getEntityManager().createQuery(oql).getResultList();
    }

    /**
     * Localiza um usuario por nome
     */
    public List<Usuario> procura(String nome) {
        String oql = "from Usuario where upper(nome) like :nome";
        Query select = JpaUtil.getEntityManager().createQuery(oql);
        select.setParameter("nome", "%" + nome.toUpperCase() + "%");
        return select.getResultList();
    }

    /**
     * Localiza um usuario por id
     */
    public Usuario localiza(int id) {
        return (Usuario) JpaUtil.getEntityManager().find(Usuario.class, id);
    }
}
