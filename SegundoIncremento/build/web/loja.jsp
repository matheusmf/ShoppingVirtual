<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    LojaJpaController lojaJpa = new LojaJpaController();
    ProdutoJpaController produtoJpa = new ProdutoJpaController();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="estrutura.css" rel="stylesheet" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Shopping Virtual - <% out.println(lojaJpa.findLoja(1).getNome()); %></title>
</head>

<body> <div class="pagina">

<div class="content">

<!-- MENU SUPERIOR XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

    <div id="topo">
        <div id="menuEsquerda" class="menu">
            <ul>
            	<li><img class="imgLinha" src="icones/16x16/home.png" />
                <li><a href="index.jsp">Home</a></li>
                <li><img class="imgLinha" src="icones/16x16/next.png" />
                <li><a href="loja.jsp">Loja</a></li>
                <li><img class="imgLinha" src="icones/16x16/help.png" />
                <li><a href="apresentacao.jsp">Quem Somos?</a></li>
                <li><img class="imgLinha" src="icones/16x16/comments.png" />
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
    
<!-- MENU DE BUSCA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

        <div id="menuBusca" class="menuBusca">
            <div id="logo"></div>
            <ul>
                <li><input type="text" name="Buscar" id="busca" value="Buscar..." onfocus="if(value == 'Buscar...'){value = ''}" onblur="if(value == ''){value = 'Buscar...'}"/></li>
                <li><a href=""><img class="imgLinha" src="icones/16x16/search.png" /></a></li>
            </ul>
            <div class="clearFloat"></div>
        </div>


<!--MENU DA LOJA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
    
        <div id="loja">
		  <a href="Index.html">
          <div class="lojalinha">  
         	    <div>
          	        <img class="imgLoja" src="imgLojas/testeloja.png" />
         	    </div>
			<div id="tituloLoja">
                            <label > <% out.println(lojaJpa.findLoja(1).getNome()); %> </label>
            	</div>
                <div id="decritivoLoja">
            		<label > Descricao: descricao da loja aple </label>
            	</div>
			<div class="clearFloat"></div>
         </div>
    	 </a>

<!--MENU DE PRODUTOS DA LOJA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

    <div></div>
    <div id="produtos">
        <div class="linha">
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(1).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/iphone3g100x100.png"/>
                            <label id="tituloProduto"><br/> <% out.print(produtoJpa.findProduto(1).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(1).getPreco()); %>0</label>
                        </div>
                    </a> 
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(2).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/macbook100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(2).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(2).getPreco()); %>0</label>
                        </div>
                    </a> 
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(3).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/ipodclassic100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(3).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(3).getPreco()); %>0</label>
                        </div>
                    </a> 
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(4).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/macmini100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(4).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(4).getPreco()); %>0</label>
                        </div>
                    </a> 
                    <div class="clearFloat"></div>
         </div>
         <div class="linha">
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(5).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/ipodnano100x100.png"/>
                            <label id="tituloProduto"><br/> <% out.print(produtoJpa.findProduto(5).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(5).getPreco()); %>0</label>
                        </div>
                    </a>
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(6).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/macbookair100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(6).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(6).getPreco()); %>0</label>
                        </div>
                    </a>
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(7).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/macpro100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(7).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(7).getPreco()); %>0</label>
                        </div>
                    </a>
                    <a href="produto.jsp?idProduto=<%=produtoJpa.findProduto(8).getId()%>">
                        <div class="produtoContent">
                            <img src="imgprodutos/<%=lojaJpa.findLoja(1).getNome()%>/imac100x100.png"/>
                            <label id="tituloProduto"><br/><% out.print(produtoJpa.findProduto(8).getNome()); %></label>
                            <label id="precoProduto"><br/>Por: R$ <% out.print(produtoJpa.findProduto(8).getPreco()); %>0</label>
                        </div>
                    </a>
                    <div class="clearFloat"></div>
         </div>
    </div>
    
<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->    

    <div id="footer"></div>
</div>

<!--MENU DE CONTATO/INFORMA��O XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->

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

<!--MENU INFERIOR XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->
    
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
