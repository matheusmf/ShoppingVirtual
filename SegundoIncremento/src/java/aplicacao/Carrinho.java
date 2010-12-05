/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.*;
import java.io.Serializable;
import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author matheusmf
 */
@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_carrinho")
    private int id;
    @OneToMany(mappedBy="carrinho", fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    private Set<Item> itens = new HashSet<Item>();

    public Set<Item> getItens() {
        return itens;
    }

    public void setItens(Set<Item> itens) {
        this.itens = itens;
    }
    


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item adicionarItem(int id_produto, int quantidade, double valor){
        Item item = Fabrica.getInstancia().criaItem();
        item.setQuantidade(quantidade);
        item.setId_produto(id_produto);
        item.setValor(valor);
        this.itens.add(item);
        return item;
    }

    public void limparCarrinho(){
        Set tempSet = itens;
        Iterator it = tempSet.iterator();
        while(it.hasNext()){
            Item item = (Item)it.next();
            this.itens.remove(item);
        }
    }

    public double calculaValorTotal(){
        double total=0;
        Iterator it = this.itens.iterator();
        while(it.hasNext()){
            Item item = (Item)it.next();
            total = total + item.getValor();
        }
        //return this.getItem().getValor()*this.getItem().getQuantidade();
        return total;
    }

    public String listaItens(){
        ProdutoJpaController produtoJpa = new ProdutoJpaController();
        String lista = "";
        Iterator it = this.getItens().iterator();
        while(it.hasNext()){
            Item item = (Item)it.next();
            lista = lista + "   " + produtoJpa.findProduto(item.getId_produto()).getNome() + "/n";
        }
        return lista;
    }

    public Pedido finalizarCarrinho(Usuario usuario){
        Pedido pedido = Fabrica.getInstancia().criaPedido(this, this.calculaValorTotal(), usuario.getId());
        //this.itens = null;
        return pedido;
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
        if (!(object instanceof Carrinho)) {
            return false;
        }
        Carrinho other = (Carrinho) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "aplicacao.Carrinho[id=" + id + "]";
    }

}
