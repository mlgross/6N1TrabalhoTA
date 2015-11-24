package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Negociador;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author mlgross 
 */
public class TesteInserirNegociador {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Negociador negociador = new Negociador();
        
        negociador.setAtivo(true);
        negociador.setComissao(4.5);
        negociador.setDataadm(Calendar.getInstance());
        negociador.setEndereco("R. Castelo Branco 12, São Gerônimo, Passo Fundo/RS");
        negociador.setNome("Dagoberto Strecht Sincomsky");
        negociador.setPis(392019485);
        negociador.setSalario(2000.00);
        
        em.getTransaction().begin();
        em.persist(negociador);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
