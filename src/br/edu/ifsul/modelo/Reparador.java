package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author mlgross 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "reparador")
public class Reparador extends Empregado implements Serializable{
    
    @NotEmpty(message = "A especialidade deve ser informada")
    @Length(max = 50, message = "A especialidade deve ter no máximo {max} caracteres")
    @Column(name = "especialidade", length = 50, nullable = false)      
    private String especialidade;

    @OneToMany(mappedBy = "reparador",
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Servico> servicos = new ArrayList<>();    

    public void adicionarServico(Servico obj){
        obj.setReparador(this);
        servicos.add(obj);
    }
    
    public void removerServico(int index){
        servicos.remove(index);
    }    
    
    public Reparador() {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }
    
    
    
}
