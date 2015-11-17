package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author mlgross 
 */
public class Venda implements Serializable{
    private Integer nf;
    private Calendar dataven;
    private String banco;
    private Double valorven;
    private Double custodesp;

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
