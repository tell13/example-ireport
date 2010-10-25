package com.fabriciojf.entidade;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Exemplo de NamedQuery
 */
@NamedQuery(
  name="consulta-classe",
  query="select new net.kinghost.fabriciojf.entidade.Consulta(g.nome, u.nome) " +
        "from Grupo g " +
        "join g.usuarios u "
)
        
/**
 * Pojo de Usuario
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    @Column(unique=true)
    private String nome;
    @ManyToOne
    private Grupo grupo;
    @ManyToOne
    private Papel papel;
    private Integer shows;

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

    /**
     * @return the grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the grupo
     */
    public Papel getPapel() {
        return papel;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    /**
     * @return the shows
     */
    public Integer getShows() {
        return shows;
    }

    /**
     * @param shows the shows to set
     */
    public void setShows(Integer shows) {
        this.shows = shows;
    }
}
