package br.edu.ifsul.modelo;

import java.io.Serializable;

/**
 *
 * @author mlgross 
 */
public class Negociador extends Empregado implements Serializable{
    
    private Double comissao;

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }
    
}
