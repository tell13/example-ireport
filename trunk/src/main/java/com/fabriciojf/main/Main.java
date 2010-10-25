package com.fabriciojf.main;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import javax.persistence.EntityManager;
import com.fabriciojf.entidade.Consulta;
import com.fabriciojf.entidade.Grupo;
import com.fabriciojf.entidade.Papel;
import com.fabriciojf.entidade.Usuario;
import com.fabriciojf.util.JpaUtil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Classe de entrada do Sistema
 *
 * @author Fabricio S Costa http://fabriciojf.com
 * @since 25/10/2010
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws Exception {
        EntityManager em = JpaUtil.getEntityManager();
        insert(em);
        //comoDeletarComJpaSomente(em);
        //comoDeletarComCamadasComSuporteADelecaoEmLista(em);

        //consultarPorNamedQueryMapeada(em);
        List<Usuario> usuarios = em.createQuery("from Usuario ").getResultList();
        print(em, "/template_beans.jrxml", usuarios);
        em.close();
    }

    /**
     * Imprime um relatorio via Jasper com Hibernate / JPA
     */
    public static void print(EntityManager em, String templatePath, List objects)
            throws Exception {
        
        /* Montando o relatório */
        URL url = Main.class.getResource(templatePath);
        File file = new File(url.toURI());
        FileInputStream in = new FileInputStream(file);

        JasperReport report = JasperCompileManager.compileReport(in);

        JRDataSource ds = new JRBeanCollectionDataSource(objects);
        JasperPrint print = JasperFillManager.fillReport(report, null, ds);

        // JasperPrintManager.printReport(print, true);
        JasperViewer.viewReport(print);
        JasperExportManager.exportReportToPdfFile(print, "e:\\report.pdf");
        JasperExportManager.exportReportToXmlFile(print, "e:\\report.xml", true);
        JasperExportManager.exportReportToHtmlFile(print, "e:\\report.html");

    }

    /**
     * Realiza uma consulta por NamedQuery, pode ser usada a named
     * query da classe Usuario ou do arquivo xml que se encontra em
     * ...\resources\META-INF\consultas.orm.xml
     */
    public static void consultarPorNamedQueryMapeada(EntityManager em) {
        /*
         * ...\resources\META-INF\consultas.orm.xml
         * List itens = em.createNamedQuery("consulta-xml").getResultList();
         * ou
         */ 
        List itens = em.createNamedQuery("consulta-classe").getResultList();

        Consulta cons = (Consulta) itens.get(0);
        System.out.print("grupo: ");
        System.out.println(cons.getGrupo());
        System.out.print("usaurio: ");
        System.out.println(cons.getUsuario());
    }

    /**
     * Delecao em camada pelo JPA
     */
    public static void comoDeletarComCamadasComSuporteADelecaoEmLista(EntityManager em)
            throws Exception {
        Papel papel = (Papel) em.createQuery("from Papel where id = 1").
                getSingleResult();
        em.getTransaction().begin();

        // Com anotacoes especificas de hibernate, toplink, etc, podemos apagar
        // diretamente o item da lista.
        papel.getUsuarios().remove(0);

        Usuario nico = new Usuario();
        nico.setNome("Bruce");
        nico.setPapel(papel);
        nico = em.merge(nico);

        em.getTransaction().commit();
        System.out.println(papel.getUsuarios().size());
    }

    /**
     * Deletando somente com JPA
     */
    public static void comoDeletarComJpaSomente(EntityManager em) throws Exception {
        Grupo grupo = (Grupo) em.createQuery("from Grupo where id = 1").
                getSingleResult();
        em.getTransaction().begin();

        // Trabalhando com somente o JPA devemos apagar o objeto diretamente, e
        // nao o item da lista, e em seguida ou remover o item da lista ou
        // commitar e atualizar o objeto pai.
        em.remove(grupo.getUsuarios().get(0));
        grupo.getUsuarios().remove(0);

        Usuario nico = new Usuario();
        nico.setNome("Nico");
        nico.setGrupo(grupo);
        nico = em.merge(nico);

        em.getTransaction().commit();
        System.out.println(grupo.getUsuarios().size());
    }

    /**
     * Inserindo dados com JPA
     */
    public static void insert(EntityManager em) {
        em.getTransaction().begin();

        // Criar novo
        Grupo grupo = new Grupo();
        grupo.setNome("Iron");
        grupo = em.merge(grupo);

        Papel papel = new Papel();
        papel.setNome("Musicos");
        papel = em.merge(papel);

        Usuario usuario = new Usuario();
        usuario.setNome("Bruce");
        usuario.setGrupo(grupo);
        usuario.setPapel(papel);
        usuario.setShows(5);
        usuario = em.merge(usuario);

        usuario = new Usuario();
        usuario.setNome("Steve");
        usuario.setGrupo(grupo);
        usuario.setPapel(papel);
        usuario.setShows(250);
        usuario = em.merge(usuario);

        em.getTransaction().commit();

        // Como estamos usando um mesmo contexto de persistencia para todos os
        // testes vamos atualizar os objetos abaixo para garantir que suas
        // listas internas contenham os usuarios cadastrados.
        em.refresh(grupo);
        em.refresh(papel);
    }
}
