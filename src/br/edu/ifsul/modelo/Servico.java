package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author mlgross 
 */
@Entity
@Table(name = "servico")
public class Servico implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_servico", strategy = GenerationType.SEQUENCE)
    private Integer numero;
    
    @NotNull(message = "O custo de compra deve ser informado.")
    @Column(name = "custo", nullable = false, columnDefinition = "decimal(12,2)")        
    private Double custo;
    
    @Length(max = 50, message = "Os insumos devem ter até {max} caracteres")
    @NotEmpty(message = "Os insumos deve ser informado")
    @Column(name = "insumos",length = 50, nullable = false)    
    private String insumos;
    
    @Length(max = 50, message = "A descrição devem ter até {max} caracteres")
    @NotEmpty(message = "A descrição deve ser informado")
    @Column(name = "descricao",length = 50, nullable = false)        
    private String descricao;
    
    @NotNull(message = "A duração deve ser informada")
    @Column(name = "duracao", nullable = false)  
    private Integer duracao;

    @NotNull(message = "O carro deve ser informado")
    @ManyToOne
    @JoinColumn(name = "carro_id", referencedColumnName = "renavan", nullable = false)
    private Carro carro; 
    
    @NotNull(message = "O reparador deve ser informado")
    @ManyToOne
    @JoinColumn(name = "reparador_pis", referencedColumnName = "pis", nullable = false)
    private Reparador reparador;     
    
    public Servico() {
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }

    public String getInsumos() {
        return insumos;
    }

    public void setInsumos(String insumos) {
        this.insumos = insumos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "descricao=" + descricao + '}';
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Reparador getReparador() {
        return reparador;
    }

    public void setReparador(Reparador reparador) {
        this.reparador = reparador;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }
    

}
