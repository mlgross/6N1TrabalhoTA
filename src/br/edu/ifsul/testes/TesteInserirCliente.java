package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mlgross
 */
public class TesteInserirCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("Revenda-ModelPU");
        EntityManager em = emf.createEntityManager();

        Cliente cliente = new Cliente();
        cliente.setCpf("181.810.869-02");
        cliente.setEndereco("Av. Brasil 476, Centro, Passo Fundo/RS");
        cliente.setNome("Josivaldo Gerônimo dos Santos");
        cliente.setRg("4050345");
        cliente.setTelefone("(55) 3311-2376");

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
