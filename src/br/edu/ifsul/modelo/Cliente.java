package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author mlgross 
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable{

    @Id
    @CPF(message = "CPF inválido")
    @Length(min = 14,max = 14,message = "CPF inválido")
    @NotEmpty(message = "O CPF deve ser informado")
    @Column(name = "cpf", length = 14,nullable = false)
    private String cpf;

    @Length(max = 10, min = 10,message = "O RG deve ter {max} caracteres")
    @NotEmpty(message = "O RG deve ser informado")
    @Column(name = "rg",length = 10,nullable = false)
    private String rg;
    
    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O modelo nome ter no máximo {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)    
    private String nome;
    
    @Length(max = 14,message = "O telefone não deve ter mais que {max} caracteres")
    @NotEmpty(message = "O telefone deve ser informado")
    @Column(name = "telefone",length = 14, nullable = false)
    private String telefone;
    
    @NotEmpty(message = "O endereco deve ser informado")
    @Length(max = 50, message = "O endereco nome ter no máximo {max} caracteres")
    @Column(name = "endereco", length = 50, nullable = false)      
    private String endereco;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cpf);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + '}';
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
}
