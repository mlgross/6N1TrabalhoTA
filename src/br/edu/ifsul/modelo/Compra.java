package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mlgross 
 */
@Entity
@Table(name = "compra")
public class Compra implements Serializable{
    
    @Id
    @Column(name = "crv",length = 15,nullable = false)    
    private Integer crv;

    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    @Column(name = "nascimento",nullable = false)    
    private Calendar datacompra;
    
    @NotNull(message = "O Valor FIPE do veículo deve ser informado.")
    @Column(name = "valorfipe", nullable = false, columnDefinition = "decimal(12,2)")         
    private Double valorfipe;
    
    @NotNull(message = "O preço de compra deve ser informado.")
    @Column(name = "precocompra", nullable = false, columnDefinition = "decimal(12,2)")         
    private Double precocompra;
    
    @NotNull(message = "O custo das despesas envolvidas na compra deve ser informado.")
    @Column(name = "custodesp", nullable = false, columnDefinition = "decimal(12,2)")         
    private Double custodesp;

/**
 * relacionamento
 */
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "cpf", nullable = false)    
    private Cliente cliente;    
    
    public Compra() {
    }

    public Integer getCrv() {
        return crv;
    }

    public void setCrv(Integer crv) {
        this.crv = crv;
    }

    public Calendar getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(Calendar datacompra) {
        this.datacompra = datacompra;
    }

    public Double getValorfipe() {
        return valorfipe;
    }

    public void setValorfipe(Double valorfipe) {
        this.valorfipe = valorfipe;
    }

    public Double getPrecocompra() {
        return precocompra;
    }

    public void setPrecocompra(Double precocompra) {
        this.precocompra = precocompra;
    }

    public Double getCustodesp() {
        return custodesp;
    }

    public void setCustodesp(Double custodesp) {
        this.custodesp = custodesp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.crv);
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
        final Compra other = (Compra) obj;
        if (!Objects.equals(this.crv, other.crv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "crv=" + crv + '}';
    }
    
    
}
