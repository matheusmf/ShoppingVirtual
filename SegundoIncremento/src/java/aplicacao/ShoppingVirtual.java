/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import controladoresJpa.*;
import controladoresJpa.exceptions.NonexistentEntityException;
import java.util.*;

/**
 *
 * @author matheusmf
 */
public class ShoppingVirtual {
    private static ShoppingVirtual sv = new ShoppingVirtual();
    LojaJpaController lojaJpa = new LojaJpaController();
    ItemJpaController itemJpa = new ItemJpaController();
    CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
    PedidoJpaController pedidoJpa = new PedidoJpaController();
    EnderecoJpaController enderecoJpa = new EnderecoJpaController();
    PessoaJpaController pessoaJpa = new PessoaJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();

    private ShoppingVirtual(){

    }

    public static ShoppingVirtual getInstancia(){
        return sv;
    }

    public void cadastraUsuario(String email, String senha, String telefone, String celular, String nome, String cpf, String dataNasc, String sexo, String rua, String numero, String bairro, String cidade, String estado, String cep, String pais){
        Pessoa pessoa = Fabrica.getInstancia().criaPessoa(nome, cpf, dataNasc, sexo);
        pessoaJpa.create(pessoa);
        Endereco endereco = Fabrica.getInstancia().criaEndereco(rua, numero, bairro, cidade, estado, cep, pais);
        enderecoJpa.create(endereco);
        Usuario usuario = Fabrica.getInstancia().criaUsuario(email, senha, telefone, celular, pessoa, endereco);
        usuarioJpa.create(usuario);
    }

    public void editaUsuario(Usuario usuario, String email, String senha, String telefone, String celular, String nome, String cpf, String dataNasc, String sexo, String rua, String numero, String bairro, String cidade, String estado, String cep, String pais) throws Exception{
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setTelefone(telefone);
        usuario.setCelular(celular);
        usuario.getPessoa().setNome(nome);
        usuario.getPessoa().setCpf(cpf);
        usuario.getPessoa().setDataNasc(dataNasc);
        usuario.getPessoa().setSexo(sexo);
        pessoaJpa.edit(usuario.getPessoa());
        usuario.getEndereco().setRua(rua);
        usuario.getEndereco().setNumero(numero);
        usuario.getEndereco().setBairro(bairro);
        usuario.getEndereco().setCidade(cidade);
        usuario.getEndereco().setEstado(estado);
        usuario.getEndereco().setPais(pais);
        usuario.getEndereco().setCep(cep);
        enderecoJpa.edit(usuario.getEndereco());
        usuarioJpa.edit(usuario);
    }

    public void cadastraLoja(String nome,String telefone, String descricao, String rua, String numero, String bairro, String cidade, String estado, String cep, String pais){
       Endereco endereco = Fabrica.getInstancia().criaEndereco(rua, numero, bairro, cidade, estado, cep, pais);
       enderecoJpa.create(endereco);
       Loja loja = Fabrica.getInstancia().criaLoja(nome, telefone, descricao, endereco);
       lojaJpa.create(loja);
    }

    public void editaLoja(Loja loja, String nome,String telefone, String descricao, String rua, String numero, String bairro, String cidade, String estado, String cep, String pais) throws Exception{
        loja.setNome(nome);
        loja.setTelefone(telefone);
        loja.setDescricao(descricao);
        loja.getEndereco().setRua(rua);
        loja.getEndereco().setNumero(numero);
        loja.getEndereco().setBairro(bairro);
        loja.getEndereco().setCidade(cidade);
        loja.getEndereco().setEstado(estado);
        loja.getEndereco().setPais(pais);
        loja.getEndereco().setCep(cep);
        enderecoJpa.edit(loja.getEndereco());
        lojaJpa.edit(loja);
    }

    public void adicionarItemCarrinho(Carrinho carrinho, int idItem, double valorItem) throws Exception{
        if(carrinhoJpa.findCarrinho(carrinho.getId()) == null){
            carrinhoJpa.create(carrinho);
        }
        Item item = carrinho.adicionarItem(idItem, 1, valorItem);
        itemJpa.create(item);
        carrinhoJpa.edit(carrinho);
    }

    public void finalizarCompra(Usuario usuario, Carrinho carrinho) throws Exception{
        Pedido pedido = carrinho.finalizarCarrinho(usuario);
        pedidoJpa.create(pedido);
        carrinhoJpa.edit(carrinho);
        pedido.finalizarPedido();
        //carrinho.limparCarrinho();
        carrinhoJpa.edit(carrinho);
    }

    public String listaPedidos(Usuario usuario){
        String lista = "Lista de Pedidos\n";
        List pedidos = pedidoJpa.findPedidoEntities();
        Iterator it = pedidos.iterator();
        while(it.hasNext()){
            Pedido pedido = (Pedido)it.next();
            if(pedido.getIdUsuario() == usuario.getId()){
                lista = lista + pedido + "\n" + carrinhoJpa.findCarrinho(pedido.getCarrinho().getId()).listaItens();
            }
        }
        return lista;
    }

}
