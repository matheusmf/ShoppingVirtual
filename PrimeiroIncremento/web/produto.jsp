<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    LojaJpaController lojaJpa = new LojaJpaController();
    ProdutoJpaController produtoJpa = new ProdutoJpaController();
    int cod = (new Integer(request.getParameter("idProduto")).intValue());
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="estrutura.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping Virtual - <% out.println(lojaJpa.findLoja(1).getNome()); %> - <% out.print(produtoJpa.findProduto(cod).getNome()); %></title>
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
    
        <div id="cProduto">
          <div class="cProdutoLinha">  
         	    <div>
          	        <img class="imgcProduto" src="<%=produtoJpa.findProduto(cod).getImagem()%>" />
         	    </div>
			<div id="ctituloProduto">
            		<label > <% out.print(produtoJpa.findProduto(cod).getNome()); %> </label>
            	</div>
                <div id="cdecritivoProduto">
                        <label> Por: R$ <% out.print(produtoJpa.findProduto(cod).getPreco()); %>0 </label>
            	</div>
                <div id="cdecritivoProduto">
                    <a href="carrinho.jsp?idProduto=<%=produtoJpa.findProduto(cod).getId()%>&valor=<%=produtoJpa.findProduto(cod).getPreco()%>">
                        <input type="button" value="Comprar"></input>
                    </a>
                </div>
			<div class="clearFloat"></div>
         </div>
    	 

<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

    <div></div>
    <div id="produtos">
        <div class="linha">
            <div class="cdescritivoContent">
            	<div><h4>Descricao:</h4>Sem informacao.</div>
            </div>
         	<div class="clearFloat"></div>
         </div>

    </div> <!-- fechamento da div produto -->
    <div id="footer"></div>
</div>
<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <div id="menuInf" class="menuInf">
            <div class="menuInf">
            <ul>
                <li><a href="">Mais Informacoes</a></li>
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
