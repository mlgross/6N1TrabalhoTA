package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross 
 */
public class TesteInserirCarro {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Carro carro = new Carro();
        
        carro.setAno(2009);
        carro.setDescricao("Seguro em dia, 17 prestações a quitar");
        carro.setModelo("Fiat Estrada 2.0");
        carro.setMultas(0.0);
        carro.setPlaca("IXF-7896");
        carro.setRenavan(985798354);
        carro.setEmposse(false);
        

        em.getTransaction().begin();
        em.persist(carro);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
