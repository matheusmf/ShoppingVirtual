/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.*;

/**
 *
 * @author matheusmf
 */
public class ShoppingVirtual {
    private static ShoppingVirtual sv = new ShoppingVirtual();
    ItemJpaController itemJpa = new ItemJpaController();
    CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
    PedidoJpaController pedidoJpa = new PedidoJpaController();

    private ShoppingVirtual(){

    }

    public static ShoppingVirtual getInstancia(){
        return sv;
    }

    public void adicionarItemCarrinho(Carrinho carrinho, int idItem, double valorItem) throws Exception{
        if(carrinhoJpa.findCarrinho(carrinho.getId()) == null){
            carrinhoJpa.create(carrinho);
        }
        Item item = carrinho.adicionarItem(idItem, 1, valorItem);
        itemJpa.create(item);
        carrinhoJpa.edit(carrinho);
    }

    public void finalizarCompra(Carrinho carrinho) throws Exception{
        Pedido pedido = carrinho.finalizarCarrinho();
        pedidoJpa.create(pedido);
        carrinhoJpa.edit(carrinho);
        pedido.finalizarPedido();
        carrinho.limparCarrinho();
        carrinhoJpa.edit(carrinho);
    }

}
