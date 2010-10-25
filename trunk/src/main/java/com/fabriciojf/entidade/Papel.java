package com.fabriciojf.entidade;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * Pojo de Papel
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
@Entity
public class Papel {

    @Id
    @GeneratedValue
    private int id;
    private String nome;

    @OneToMany(mappedBy="papel")
    @Cascade({CascadeType.ALL, CascadeType.DELETE_ORPHAN})
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    /**
     * @return the usuarios
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
