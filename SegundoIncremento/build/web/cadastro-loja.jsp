<%-- 
    Document   : cadastro-loja
    Created on : 03/12/2010, 17:35:49
    Author     : matheusmf
--%>
<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    if((request.getParameter("nome") != null) && (request.getParameter("telefone") != null) && (request.getParameter("descricao") != null)
         && (request.getParameter("rua") != null) && (request.getParameter("num") != null) && (request.getParameter("bairro") != null)
         && (request.getParameter("cidade") != null) && (request.getParameter("estado") != null) && (request.getParameter("pais") != null) && (request.getParameter("cep") != null)){

        ShoppingVirtual.getInstancia().cadastraLoja(
        request.getParameter("nome"), request.getParameter("telefone"), request.getParameter("descricao"),
        request.getParameter("rua"), request.getParameter("num"), request.getParameter("bairro"), request.getParameter("cidade"), request.getParameter("estado"), request.getParameter("cep"), request.getParameter("pais"));

    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Loja</title>
    </head>
    <body>
        <form action="cadastro-loja.jsp" name="cadastro-cliente">
            Dados da Loja:<br>
            Nome: <input type="text" name="nome"><br>
            Telefone: <input type="text" name="telefone"><br>
            Descricao: <input type="text" name="descricao"><br>
            <br>
            Endereco:<br>
            Rua: <input type="text" name="rua"><br>
            Numero: <input type="text" name="num"><br>
            Bairro: <input type="text" name="bairro"><br>
            Cidade: <input type="text" name="cidade"><br>
            Estado: <input type="text" name="estado"><br>
            Pais: <input type="text" name="pais"><br>
            CEP: <input type="text" name="cep"><br>
            <br>
            <input type="submit" name="cadastrar" value="Cadastrar">
        </form>
    </body>
</html>
