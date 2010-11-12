/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.ProdutoJpaController;
import java.io.Serializable;
import java.util.Iterator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author matheusmf
 */
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_pedido")
    private int id;
    private double valorTotal;
    @OneToOne
    private Carrinho carrinho;

    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    /*@OneToOne
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }*/

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void finalizarPedido() throws Exception{
        ProdutoJpaController produtoJpa = new ProdutoJpaController();
        Iterator it = carrinho.getItens().iterator();
        while(it.hasNext()){
            Item item = (Item)it.next();
            Produto prod = produtoJpa.findProduto(item.getId_produto());
            prod.setQuantidade(prod.getQuantidade() - item.getQuantidade());
            produtoJpa.edit(prod);
        }
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacao.Pedido[id=" + id + "]";
    }

}
