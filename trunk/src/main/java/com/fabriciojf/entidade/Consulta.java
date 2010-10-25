package com.fabriciojf.entidade;

/**
 * Pojo Consulta
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class Consulta {
    
    private String grupo;
    private String usuario;

    public Consulta(String grupo, String usuario) {
        this.grupo = grupo;
        this.usuario = usuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the grupo
     */
    public String getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    
}
