package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author mlgross 
 */
public abstract class Empregado implements Serializable{
    private Integer pis;
    private String nome;
    private Calendar dataadm;
    private String endereco; 
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
