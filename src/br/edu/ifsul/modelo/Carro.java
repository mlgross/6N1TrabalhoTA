package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
    @NotNull(message = "O renavan deve ser informado")
    @Column(name = "renavan", nullable = false)
    private Integer renavan;
    
    @NotEmpty(message = "A placa deve ser informada")
    @Length(max = 8, message = "O placa deve ter no máximo {max} caracteres")
    @Column(name = "placa", length = 8, nullable = false)
    private String placa;

    @NotEmpty(message = "O modelo deve ser informado")
    @Length(max = 20, message = "O modelo deve ter no máximo {max} caracteres")
    @Column(name = "modelo", length = 20, nullable = false)
    private String modelo;
    
    @NotNull(message = "O ano deve ser informado")
    @Column(name = "ano", nullable = false)
    private Integer ano;
    
//A descrição pode ser vazia 
    @Length(max = 50, message = "A descrição deve ter no máximo {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)        
    private String descricao;
    
    @NotNull(message = "O valor das multas deve ser informado. Caso não houver, informe zero")
    @Column(name = "multas", nullable = false, columnDefinition = "decimal(12,2)")        
    private Double multas;

    @NotNull(message = "Deve ser especificado se o veículo está em posse da revenda ou não")
    @Column(name = "emposse", nullable = false)
    private Boolean emposse;
    
    @OneToMany(mappedBy = "carro",
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<Servico> servicos = new ArrayList<>();    

    public void adicionarServico(Servico obj){
        obj.setCarro(this);
        servicos.add(obj);
    }
    
    public void removerServico(int index){
        servicos.remove(index);
    }    
    
    
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

    public Integer getRenavan() {
        return renavan;
    }

    public void setRenavan(Integer renavan) {
        this.renavan = renavan;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public Boolean getEmposse() {
        return emposse;
    }

    public void setEmposse(Boolean emposse) {
        this.emposse = emposse;
    }
    
    
    
}
