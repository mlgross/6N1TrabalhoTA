package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author mlgross 
 */
public class Compra implements Serializable{
    private Integer crv;
    private Calendar datacompra;
    private Double valorfipe;
    private Double precocompra;
    private Double custodesp;

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
