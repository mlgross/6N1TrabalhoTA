package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "empregado")
public abstract class Empregado implements Serializable{

    @Id
    @Column(name = "pis",length = 15,nullable = false)  
    private Integer pis;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O modelo nome ter no máximo {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)      
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @NotNull(message = "O nascimento deve ser informado")
    @Column(name = "nascimento",nullable = false)      
    private Calendar dataadm;
    
    @NotEmpty(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco nome ter no máximo {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)      
    private String endereco; 
    
    @NotNull(message = "O sálario de compra deve ser informado.")
    @Column(name = "salario", nullable = false, columnDefinition = "decimal(12,2)")        
    private Double salario;
   
    public Empregado() {
    }

    public Integer getPis() {
        return pis;
    }

    public void setPis(Integer pis) {
        this.pis = pis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataadm() {
        return dataadm;
    }

    public void setDataadm(Calendar dataadm) {
        this.dataadm = dataadm;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.pis);
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
        final Empregado other = (Empregado) obj;
        if (!Objects.equals(this.pis, other.pis)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empregado{" + "nome=" + nome + '}';
    }
    
    
    
}
