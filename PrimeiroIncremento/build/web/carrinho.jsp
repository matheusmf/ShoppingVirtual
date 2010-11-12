<%@page import="java.util.Iterator"%>
<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();

    Carrinho carrinho = (Carrinho)pageContext.getAttribute("carrinho",pageContext.SESSION_SCOPE);

	if(carrinho == null){
		carrinho = carrinhoJpa.findCarrinho(1);
		pageContext.setAttribute("carrinho",carrinho,pageContext.SESSION_SCOPE);
	}

    ProdutoJpaController produtoJpa = new ProdutoJpaController();
    
    if((request.getParameter("idProduto") != null) && (request.getParameter("valor") != null)){
        int cod_produto = new Integer(request.getParameter("idProduto")).intValue();
        double valor_item = new Double(request.getParameter("valor")).doubleValue();
        ShoppingVirtual.getInstancia().adicionarItemCarrinho(carrinho, cod_produto, valor_item);
    }
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="estrutura.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping Virtual - Carrinho</title>
</head>

<body> <div class="pagina">

<div class="content">
    <div id="topo">
        <div id="menuEsquerda" class="menu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li>|</li>
                <li><a href="loja.jsp">Loja</a></li>
                <li>|</li>
                <li><a href="apresentacao.jsp">Quem Somos?</a></li>
                <li>|</li>
                <li><a href="atendimento.jsp">Atendimento</a></li>
            </ul>
        </div>
        <div id="menuDireita" class="menu">
            <ul>
                <li><a href="meuspedidos.jsp">Meus Pedidos</a></li>
                <li>|</li>
                <li><a href="carrinho.jsp">Carrinho</a></li>
            </ul>
        </div>
        <div class="clearFloat"></div>
    </div>
    </div>
    
<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <div id="menuBusca" class="menuBusca">
            <div class="menuBusca">
            <ul>
                <li><input type="text" name="Buscar" id="Busca" /></li>
                <li><a href="">Buscar</a></li>
            </ul>
          </div>
        </div> 
        <div class="clearFloat"></div>

<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
    
        <div id="Carrinho">
          <div>  
			<div>
           	  <label > Carrinho </label>
              	<div id="CarrinhoContent">
                                  <div id="CarrinhoContentTable">
                                  <table class="carrinho">
                                            <tr>
                                                <th width="180" rowspan="2">Nome Produto</th>
                                                <th width="180" rowspan="2">Quantidade</th>
                                                <th width="180" rowspan="2">Preco Unitario</th>
                                                <th width="180" rowspan="2">Preco total</th>
                                            </tr>
                                        </table>
                                  </div>
                                  <div class="clearFloat"></div>
                                  <div id="CarrinhoContent">
                                            <table class="carrinho">
                                                <%
                                                    Iterator it = carrinho.getItens().iterator();
                                                    while(it.hasNext()){
                                                        Item item = (Item)it.next();
                                                %>
                                            <tr>
                                                <td width="180"><%=produtoJpa.findProduto(item.getId_produto()).getNome()%></td>
                                                <td width="180"><%=item.getQuantidade()%></td>
                                                <td width="180"><%=item.getValor()%></td>                                         
                                              <td width="180"><%=item.getValor()*item.getQuantidade()%></td>
                                              <% } %>
                                            </tr>
                                            </table>
                                  </div>                                 
           	</div>
                       <a href="pedido.jsp?idCarrinho=<%=carrinho.getId()%>&idCarrinho=<%=carrinho.getId()%>&valorT=<%=carrinho.calculaValorTotal()%>">
			<div class="clearFloat"></div>
            			<div class="CarrinhoFinCompra">
                                    <input type="button" value="Finalizar Compra"></input>
                        </div>
                       </a>
              </div>
         </div>

<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

    <div id="footer"></div> 
</div> 
<div><p></p></div>

<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <div id="menuInf" class="menuInf">
            <div class="menuInf">
            <ul>
                <li><a href="">Mais Informações</a></li>
                <li>|</li>
                <li><a href=""></a>Formas de Pagamento</li>
                <li>|</li>
                <li><a href="">Contato</a></li>
             </ul>
            </div> 
        </div>
        <div class="clearFloat"></div>
		

<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
    
    <div id="topo">
        <div id="menuEsquerda" class="menu">
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li>|</li>
                <li><a href="lojas.jsp">Loja</a></li>
                <li>|</li>
                <li><a href="apresentacao.jsp">Quem Somos?</a></li>
                <li>|</li>
                <li><a href="atendimento.jsp">Atendimento</a></li>
            </ul>
        </div>
        <div id="menuDireita" class="menu">
            <ul>
                <li><a href="meuspedidos.jsp">Meus Pedidos</a></li>
                <li>|</li>
                <li><a href="carrinho.jsp">Carrinho</a></li>
            </ul>
        </div>
        <div class="clearFloat"></div>
    </div>
    
<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

</div>
</body>
</html>
