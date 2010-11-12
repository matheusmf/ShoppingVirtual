/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.*;
import controladoresJpa.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

/**
 *
 * @author matheusmf
 */
@Entity
public class Carrinho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_carrinho")
    private int id;
    @OneToOne
    private Usuario usuario;
    @OneToMany(mappedBy="carrinho")  //o nome da propriedade de "value" que liga a esta classe
    @MapKey(name="id")  //a "key" do mapa, pode ser qualquer propriedade
    public Map<Integer,Produto> getProdutos() { return produtos; }
    public void setProdutos(Map<Integer,Produto> produtos) { this.produtos = produtos; }
    private Map<Integer,Produto> produtos;

    /*public HashMap getListaProduto() {
        return listaProduto;
    }*/

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void adicionarProdutoCarrinho(Produto produto, int quantidade) throws Exception{
        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        if(this.produtos.containsKey(produto.getId())){
            this.editarProdutoCarrinho(produto, ((Produto)this.produtos.get(produto.getId())).getQuantidade()+quantidade);
        }else{
            produto.setQuantidade(quantidade);
            this.produtos.put(produto.getId(), produto);
        }
        carrinhoJpa.edit(this);
    }

    public void editarProdutoCarrinho(Produto produto, int quantidade) throws Exception{
        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        Iterator it = this.produtos.values().iterator();
        while(it.hasNext()){
            Produto produto2 = (Produto)it.next();
            if(produto2.equals(produto)){
                produto2.setQuantidade(quantidade);
            }
        }
        carrinhoJpa.edit(this);
    }

    public void removerProdutoCarrinho(Produto produto) throws Exception{
        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        this.produtos.remove(produto);
        carrinhoJpa.edit(this);
    }

    public double calculaValorTotal(){
        double total = 0;
        Iterator it = this.produtos.values().iterator();
        while(it.hasNext()){
            Produto produto = (Produto)it.next();
            total = total + produto.getPreco()*produto.getQuantidade();
        }
        return total;
    }

    public void limparCarrinho() throws Exception{
        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        Iterator it = this.produtos.values().iterator();
        while(it.hasNext()){
            Produto produto = (Produto)it.next();
            this.removerProdutoCarrinho(produto);
        }
        carrinhoJpa.edit(this);
    }

    public void finalizarCompra() throws Exception{
        Pedido pedido = Fabrica.getInstancia().criaPedido(produtos, "Pendente", null, this.calculaValorTotal());
        this.limparCarrinho();
        PedidoJpaController pedidoJpa = new PedidoJpaController();

        pedidoJpa.create(pedido);
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
