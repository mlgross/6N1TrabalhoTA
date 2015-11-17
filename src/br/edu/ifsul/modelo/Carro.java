package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author mlgross
 */
@Entity
@Table(name = "carro")
public class Carro implements Serializable{
    @Id
    @NotEmpty(message = "A placa deve ser informada")
    @Length(max = 8, message = "O placa deve ter no máximo {max} caracteres")
    @Column(name = "placa", length = 8, nullable = false)
    private String placa;

    @NotEmpty(message = "O modelo deve ser informado")
    @Length(max = 20, message = "O modelo deve ter no máximo {max} caracteres")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @Column(name = "ano", nullable = false)
    private Integer ano;
    
    private String descricao;
    
    private Double multas;

    public Carro() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMultas() {
        return multas;
    }

    public void setMultas(Double multas) {
        this.multas = multas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.placa);
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
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }
    
    
    
}
