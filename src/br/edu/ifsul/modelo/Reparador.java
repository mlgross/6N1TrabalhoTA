package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
    
    @NotEmpty(message = "A especialidade deve ser informado")
    @Length(max = 50, message = "A especialidade nome ter no máximo {max} caracteres")
    @Column(name = "especialidade", length = 50, nullable = false)      
    private String especialidade;

    public Reparador() {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
}
