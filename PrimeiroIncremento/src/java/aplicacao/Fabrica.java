
package aplicacao;

import controladoresJpa.*;
import controladoresJpa.exceptions.NonexistentEntityException;

/**
 *
 * @author matheusmf
 */
public class Fabrica {
    private static Fabrica f = new Fabrica();

    private Fabrica(){

    }

    public static Fabrica getInstancia(){
        return f;
    }

    public Loja criaLoja(String nome){
        Loja loja = new Loja();
        loja.setNome(nome);
        return loja;
    }

    public Produto criaProduto(String nome, int quantidade, double preco, String imagem, Loja loja){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setQuantidade(quantidade);
        produto.setPreco(preco);
        produto.setImagem(imagem);
        produto.setLoja(loja);

        return produto;
    }

    public Carrinho criaCarrinho(){
        return new Carrinho();
    }

    public Pedido criaPedido(Carrinho carrinho, double valorTotal){
        Pedido pedido = new Pedido();
        pedido.setCarrinho(carrinho);
        pedido.setValorTotal(valorTotal);

        return pedido;
    }

    public Item criaItem(){
        return new Item();
    }

    public static void main(String[] args) throws NonexistentEntityException, Exception{
        LojaJpaController lojaJpa = new LojaJpaController();
        ProdutoJpaController produtoJpa = new ProdutoJpaController();
        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        PedidoJpaController pedidoJpa = new PedidoJpaController();

        Loja loja = Fabrica.getInstancia().criaLoja("Apple");
        lojaJpa.create(loja);

        Produto produto1 = Fabrica.getInstancia().criaProduto("Iphone 3G", 10, 1299, "imgprodutos/Apple/iphone3g300x300.png", loja);
        produtoJpa.create(produto1);
        Produto produto2 = Fabrica.getInstancia().criaProduto("Macbook Pro", 5, 3799, "imgprodutos/Apple/macbook300x300.png", loja);
        produtoJpa.create(produto2);
        Produto produto3 = Fabrica.getInstancia().criaProduto("Ipod Classic", 8, 899, "imgprodutos/Apple/ipodclassic300x300.png", loja);
        produtoJpa.create(produto3);
        Produto produto4 = Fabrica.getInstancia().criaProduto("Mac Mini", 7, 2699, "imgprodutos/Apple/macmini300x300.png", loja);
        produtoJpa.create(produto4);
        Produto produto5 = Fabrica.getInstancia().criaProduto("Ipod Nano", 20, 549, "imgprodutos/Apple/ipodnano300x300.png", loja);
        produtoJpa.create(produto5);
        Produto produto6 = Fabrica.getInstancia().criaProduto("Macbook Air", 3, 3199, "imgprodutos/Apple/macbookair300x300.png", loja);
        produtoJpa.create(produto6);
        Produto produto7 = Fabrica.getInstancia().criaProduto("Mac Pro", 3, 8299, "imgprodutos/Apple/macpro300x300.png", loja);
        produtoJpa.create(produto7);
        Produto produto8 = Fabrica.getInstancia().criaProduto("Imac", 4, 4999, "imgprodutos/Apple/imac300x300.png", loja);
        produtoJpa.create(produto8);

        Carrinho carrinho = Fabrica.getInstancia().criaCarrinho();
        carrinhoJpa.create(carrinho);

        /*ShoppingVirtual.getInstancia().adicionarItemCarrinho(carrinho, produto1.getId(), produto1.getPreco());
        ShoppingVirtual.getInstancia().adicionarItemCarrinho(carrinho, produto2.getId(), produto2.getPreco());

        ShoppingVirtual.getInstancia().finalizarCompra(carrinho);*/

        //carrinho.adicionarItem(produto1.getId(), 1, produto1.getPreco());
        //carrinhoJpa.edit(carrinho);

        //carrinho.finalizarCarrinho();

        //Pedido pedido = pedidoJpa.findPedido(1);
        //pedido.finalizarPedido();
        

    }

}
