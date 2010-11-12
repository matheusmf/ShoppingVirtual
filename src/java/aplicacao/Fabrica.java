package aplicacao;

import controladoresJpa.*;
import controladoresJpa.exceptions.*;
import java.util.HashMap;
import java.util.Map;

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

    public Usuario criaUsuario(String nomeUsuario, String senha, String email, Pessoa pessoa, Carrinho carrinho){
        Usuario usuario = new Usuario();
        usuario.setNomeUsuario(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setEmail(email);
        usuario.setPessoa(pessoa);
        usuario.setCarrinho(carrinho);

        return usuario;
    }

    public Pessoa criaPessoa(String nome, String rg, String cpf, String dataNascimento, int sexo, String tel, String cel, Endereco endereco){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setRg(rg);
        pessoa.setCpf(cpf);
        pessoa.setDataNascimento(dataNascimento);
        pessoa.setSexo(sexo);
        pessoa.setTel(tel);
        pessoa.setCel(cel);
        pessoa.setEndereco(endereco);

        return pessoa;
    }

    public Endereco criaEndereco(String pais, String estado, String cidade, String endereco_, String num, String complemento, String cep){
        Endereco endereco = new Endereco();
        endereco.setPais(pais);
        endereco.setEstado(estado);
        endereco.setCidade(cidade);
        endereco.setEndereco(endereco_);
        endereco.setNum(num);
        endereco.setComplemento(complemento);
        endereco.setCep(cep);

        return endereco;
    }

    public Loja criaLoja(String nome, Categoria categoria, String descricao, Endereco endereco, Locatario donoLoja){
        Loja loja = new Loja();
        loja.setNome(nome);
        loja.setCategoria(categoria);
        loja.setDescricao(descricao);
        loja.setDonoLoja(donoLoja);

        return loja;
    }

    public Locatario criaLocatario(Loja loja){
        Locatario locatario = new Locatario();
        locatario.setLoja(loja);

        return locatario;
    }

    public Carrinho criaCarrinho(Usuario usuario){
        Carrinho carrinho = new Carrinho();
        carrinho.setUsuario(usuario);

        return carrinho;
    }

    public Categoria criaCategoria(String nome){
        Categoria categoria = new Categoria();
        categoria.setNome(nome);

        return categoria;
    }

    public Produto criaProduto(String nome, Categoria categoria, double preco, int quantidade, String descricao, Loja loja){
        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setCategoria(categoria);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        produto.setDescricao(descricao);
        produto.setLoja(loja);

        return produto;
    }

    public Pedido criaPedido(Map listaCompra, String status, String dataPedido, double valorTotal){
        Pedido pedido = new Pedido();
        pedido.setDataPedido(dataPedido);
        pedido.setListaCompra(listaCompra);
        pedido.setStatus(status);
        pedido.setValorTotal(valorTotal);

        return pedido;
    }

    public static void main(String[] args) throws NonexistentEntityException, PreexistingEntityException, Exception {
        Fabrica fabrica = Fabrica.getInstancia();


        Produto p1 = fabrica.criaProduto("computador", null, 1000, 5, "computador pessoal", null);

        ProdutoJpaController produtoJpa = new ProdutoJpaController();

        produtoJpa.create(p1);

        UsuarioJpaController usuarioJpa = new UsuarioJpaController();
        Usuario u1 = fabrica.criaUsuario("matheus", "123", "email", null, null);
        usuarioJpa.create(u1);

        Carrinho c1 = fabrica.criaCarrinho(usuarioJpa.findUsuario(1));

        CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
        carrinhoJpa.create(c1);

        c1.adicionarProdutoCarrinho(produtoJpa.findProduto(1), 1);

        c1.finalizarCompra();

        /*PedidoJpaController pedidoJpa = new PedidoJpaController();

        Pedido ped1 = pedidoJpa.findPedido(1);
        System.out.println(ped1);

        ped1.finalizarPedido();*/



    }

}

