package com.fabriciojf.util;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe para pegar o EntityManager do JPA
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class JpaUtil implements Serializable {
    
    private static EntityManagerFactory factory;
    
    static{
        factory = Persistence.createEntityManagerFactory("teste");
    }

    /**
     * Retorna o EntityManager
     */
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }

}
