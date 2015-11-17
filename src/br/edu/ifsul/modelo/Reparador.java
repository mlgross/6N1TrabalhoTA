package br.edu.ifsul.modelo;

import java.io.Serializable;

/**
 *
 * @author mlgross 
 */
public class Reparador extends Empregado implements Serializable{
    
    private String especialidade;

    public Reparador() {
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    
    
}
