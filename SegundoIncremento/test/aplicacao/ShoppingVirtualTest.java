/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicacao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author matheusmf
 */
public class ShoppingVirtualTest {

    public ShoppingVirtualTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        System.out.println("Iniciando Teste");
    }

    @After
    public void tearDown() {
        System.out.println("Finalizando Teste");
    }

    /**
     * Test of getInstancia method, of class ShoppingVirtual.
     */
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        ShoppingVirtual expResult = ShoppingVirtual.getInstancia();
        ShoppingVirtual result = ShoppingVirtual.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarItemCarrinho method, of class ShoppingVirtual.
     */
    @Test
    public void testAdicionarItemCarrinho() throws Exception {
        System.out.println("adicionarItemCarrinho");
        Carrinho carrinho = Fabrica.getInstancia().criaCarrinho();
        Produto produto = Fabrica.getInstancia().criaProduto("teste", 3, 100, null, null);
        //Item item = carrinho.adicionarItem(produto.getId(), 1, produto.getPreco());

        ShoppingVirtual.getInstancia().adicionarItemCarrinho(carrinho, produto.getId(), produto.getPreco());

        assertEquals(carrinho.getItens().isEmpty(), false);
        assertEquals(carrinho.calculaValorTotal(), 100, 1);
        assertEquals(carrinho.getItens().size(), 1);



        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of finalizarCompra method, of class ShoppingVirtual.
     */
    @Test
    public void testFinalizarCompra() throws Exception {
        System.out.println("finalizarCompra");
        Carrinho carrinho = Fabrica.getInstancia().criaCarrinho();
        Produto produto = Fabrica.getInstancia().criaProduto("teste", 3, 100, null, null);
        Item item = carrinho.adicionarItem(produto.getId(), 1, produto.getPreco());
        assertEquals(item.getId_produto(), produto.getId());
        assertEquals(item.getQuantidade(), 1);
        assertEquals(item.getValor(), 100, 1);
        Pedido pedido = carrinho.finalizarCarrinho();

        ShoppingVirtual instance = ShoppingVirtual.getInstancia();
        //instance.finalizarCompra(carrinho);
        assertEquals(pedido.getValorTotal(), 100, 1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

}