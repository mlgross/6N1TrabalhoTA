package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author mlgross
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "negociador")
public class Negociador extends Empregado implements Serializable {

    @NotNull(message = "A comissao da compra deve ser informado.")
    @Column(name = "comissao", nullable = false, columnDefinition = "decimal(12,2)")
    private Double comissao;

    @OneToMany(mappedBy = "negociador", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Compra> compras = new ArrayList<>();

    @OneToMany(mappedBy = "negociador", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Venda> vendas = new ArrayList<>();

    public void adicionarCompra(Compra obj) {
        obj.setNegociador(this);
        compras.add(obj);
    }

    public void removerCompra(int index) {
        compras.remove(index);
    }

    public void adicionarVenda(Venda obj) {
        obj.setNegociador(this);
        vendas.add(obj);
    }

    public void removerVenda(int index) {
        vendas.remove(index);
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

}
