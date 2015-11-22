package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cliente;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author mlgross 
 */
public class TesteInserirCliente {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("Nome da Unidade de Persistência");
            em = emf.createEntityManager();
 
            Cliente cliente = new Cliente();
            cliente.setCpf(null);
            cliente.setEndereco(null);
            cliente.setNome(null);
            cliente.setRg(null);
            cliente.setTelefone(null);
            
            // criando o objeto para validar as anotações da bean validation API
            Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Cliente>> erros = validador.validate(cliente);
            if (erros.size() > 0) {
                for (ConstraintViolation<Cliente> erro : erros){
                    System.out.println("Erro: "+erro.getMessage());
                }
            } else {
                em.getTransaction().begin();
                em.persist(cliente);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive() == false) {
                em.getTransaction().begin();
            }
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
