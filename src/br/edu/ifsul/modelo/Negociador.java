package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mlgross 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "negociador")
public class Negociador extends Empregado implements Serializable{
    
    @NotNull(message = "A comissao da compra deve ser informado.")
    @Column(name = "comissao", nullable = false, columnDefinition = "decimal(12,2)")     
    private Double comissao;

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    
}
