<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    CarrinhoJpaController carrinhoJpa = new CarrinhoJpaController();
    UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    //Carrinho carrinho = carrinhoJpa.findCarrinho(new Integer(request.getParameter("idCarrinho")).intValue());

    Carrinho carrinho = (Carrinho)pageContext.getAttribute("carrinho",pageContext.SESSION_SCOPE);
	
	if(carrinho == null){
		carrinho = carrinhoJpa.findCarrinho(1);
		pageContext.setAttribute("carrinho",carrinho,pageContext.SESSION_SCOPE);
	}

    Usuario usuario = usuarioJpa.findUsuario(1);
    ShoppingVirtual.getInstancia().finalizarCompra(usuario, carrinho);
    session.invalidate();
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Pedido Finalizado!</h1>
        <a href="index.jsp">Continuar Comprando</a>
    </body>
</html>
