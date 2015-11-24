package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Carro;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Negociador;
import br.edu.ifsul.modelo.Venda;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross 
 */
public class TesteInserirVenda {
    
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
        
        Venda venda = new Venda();
        venda.setCarro(carro);
        venda.setCliente(cliente);
        venda.setNegociador(negociador);

        venda.setBanco("Itau");
        venda.setCustodesp(1500.00);
        venda.setDataven(Calendar.getInstance());
        venda.setValorven(45000.00);
        
        em.getTransaction().begin();
        em.persist(venda);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
