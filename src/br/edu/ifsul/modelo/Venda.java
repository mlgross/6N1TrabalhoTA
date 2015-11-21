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
@Table(name = "venda")
public class Venda implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_venda", sequenceName = "seq_venda_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_venda", strategy = GenerationType.SEQUENCE)
    private Integer nf;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "A data da venda deve ser informado")
    @Column(name = "dataven",nullable = false) 
    private Calendar dataven;
    
    @Length(max = 50, message = "O banco devem ter até {max} caracteres")
    @NotEmpty(message = "O banco deve ser informado")
    @Column(name = "banco",length = 50, nullable = false)        
    private String banco;
    
    @NotNull(message = "O valor da venda deve ser informado.")
    @Column(name = "valorven", nullable = false, columnDefinition = "decimal(12,2)")     
    private Double valorven;
    
    @NotNull(message = "O custo da venda ocorrida deve ser informado.")
    @Column(name = "custodesp", nullable = false, columnDefinition = "decimal(12,2)")         
    private Double custodesp;
/**
 * relacionamento
 */
    @NotNull(message = "O cliente deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "cpf", nullable = false)    
    private Cliente cliente;
    
    public Venda() {
    }

    public Integer getNf() {
        return nf;
    }

    public void setNf(Integer nf) {
        this.nf = nf;
    }

    public Calendar getDataven() {
        return dataven;
    }

    public void setDataven(Calendar dataven) {
        this.dataven = dataven;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public Double getValorven() {
        return valorven;
    }

    public void setValorven(Double valorven) {
        this.valorven = valorven;
    }

    public Double getCustodesp() {
        return custodesp;
    }

    public void setCustodesp(Double custodesp) {
        this.custodesp = custodesp;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.nf);
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
        final Venda other = (Venda) obj;
        if (!Objects.equals(this.nf, other.nf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "nf=" + nf + '}';
    }
    
    
}
