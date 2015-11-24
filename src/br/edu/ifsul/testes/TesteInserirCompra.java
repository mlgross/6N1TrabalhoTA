package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Negociador;
import br.edu.ifsul.modelo.Compra;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross 
 */
public class TesteInserirCompra {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Carro carro = em.find(Carro.class, 985798354);
        Negociador negociador = em.find(Negociador.class, 392019485);
        Cliente cliente = em.find(Cliente.class, "181.810.869-02");
        
        Compra compra = new Compra();
        compra.setCarro(carro);
        compra.setCliente(cliente);
        compra.setNegociador(negociador);
        
        compra.setCrv(412788975);
        compra.setCustodesp(1200.00);
        compra.setDatacompra(Calendar.getInstance());
        compra.setPrecocompra(36000.00);
        compra.setValorfipe(39000.00);
        
        em.getTransaction().begin();
        em.persist(compra);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
