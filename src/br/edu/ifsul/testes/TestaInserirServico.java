package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Reparador;
import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Servico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross 
 */
public class TestaInserirServico {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Reparador reparador = em.find(Reparador.class, 166666266);       
        Carro carro = em.find(Carro.class, 876876876);
        
        Servico servico = new Servico();

        servico.setCarro(carro);
        servico.setReparador(reparador);        
        servico.setCusto(250.0);
        servico.setDescricao("Troca de escapamento");
        //modify tipe of data
        servico.setDuracao(5);
        servico.setInsumos("Jogo de Escapamento");
        
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }    
}
