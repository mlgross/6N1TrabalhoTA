package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Reparador;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author mlgross 
 */
public class TesteInserirReparador {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Reparador reparador = new Reparador();
        
        reparador.setAtivo(true);
        reparador.setDataadm(Calendar.getInstance());
        reparador.setEndereco("Rua Machado Nelman 54, Lot. Borges, Passo Fundo/RS");
        reparador.setEspecialidade("Funilaria");
        reparador.setNome("Luis Ângelo Gonsalvez");
        reparador.setPis(327498234);
        reparador.setSalario(1400.0);
        
        em.getTransaction().begin();
        em.persist(reparador);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
