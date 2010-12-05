<%-- 
    Document   : cadastro-cliente
    Created on : 03/12/2010, 14:31:44
    Author     : matheusmf
--%>

<%@page import="aplicacao.*"%>
<%@page import="controladoresJpa.*"%>

<%
    if((request.getParameter("email") != null) && (request.getParameter("senha") != null) && (request.getParameter("nome") != null)
         && (request.getParameter("cpf") != null) && (request.getParameter("dataNasc") != null) && (request.getParameter("sexo") != null)
         && (request.getParameter("telefone") != null) && (request.getParameter("celular") != null) && (request.getParameter("rua") != null)
         && (request.getParameter("numero") != null) && (request.getParameter("bairro") != null) && (request.getParameter("cidade") != null)
         && (request.getParameter("estado") != null) && (request.getParameter("pais") != null) && (request.getParameter("cep") != null)){

        ShoppingVirtual.getInstancia().cadastraUsuario(
        request.getParameter("email"), request.getParameter("senha"), request.getParameter("telefone"), request.getParameter("celular"),
        request.getParameter("nome"), request.getParameter("cpf"), request.getParameter("dataNasc"), request.getParameter("sexo"),
        request.getParameter("rua"), request.getParameter("numero"), request.getParameter("bairro"), request.getParameter("cidade"), request.getParameter("estado"), request.getParameter("cep"), request.getParameter("pais"));

    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Usuario</title>
    </head>
    <body>
        <form action="cadastro-cliente.jsp" name="cadastro-cliente">
            Dados de Login:<br>
            Email: <input type="text" name="email"><br>
            Senha: <input type="text" name="senha"><br>
            Redigite a senha: <input type="text" name="resenha"><br>
            <br>
            Dados Pessoais:<br>
            Nome: <input type="text" name="nome"><br>
            CPF: <input type="text" name="cpf"><br>
            Data de Nascimento: <input type="text" name="dataNasc"><br>
            Sexo: <input type="text" name="sexo"><br>
            Telefone: <input type="text" name="telefone"><br>
            Celular: <input type="text" name="celular"><br>
            <br>
            Endereco:<br>
            Rua: <input type="text" name="rua"><br>
            Numero: <input type="text" name="numero"><br>
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
