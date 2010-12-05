package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import aplicacao.*;
import controladoresJpa.*;

public final class cadastro_002dcliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Cadastro Usuario</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"cadastro-cliente.jsp\" name=\"cadastro-cliente\">\n");
      out.write("            Dados de Login:<br>\n");
      out.write("            Email: <input type=\"text\" name=\"email\"><br>\n");
      out.write("            Senha: <input type=\"text\" name=\"senha\"><br>\n");
      out.write("            Redigite a senha: <input type=\"text\" name=\"resenha\"><br>\n");
      out.write("            <br>\n");
      out.write("            Dados Pessoais:<br>\n");
      out.write("            Nome: <input type=\"text\" name=\"nome\"><br>\n");
      out.write("            CPF: <input type=\"text\" name=\"cpf\"><br>\n");
      out.write("            Data de Nascimento: <input type=\"text\" name=\"dataNasc\"><br>\n");
      out.write("            Sexo: <input type=\"text\" name=\"sexo\"><br>\n");
      out.write("            Telefone: <input type=\"text\" name=\"telefone\"><br>\n");
      out.write("            Celular: <input type=\"text\" name=\"celular\"><br>\n");
      out.write("            <br>\n");
      out.write("            Endereco:<br>\n");
      out.write("            Rua: <input type=\"text\" name=\"rua\"><br>\n");
      out.write("            Numero: <input type=\"text\" name=\"numero\"><br>\n");
      out.write("            Bairro: <input type=\"text\" name=\"bairro\"><br>\n");
      out.write("            Cidade: <input type=\"text\" name=\"cidade\"><br>\n");
      out.write("            Estado: <input type=\"text\" name=\"estado\"><br>\n");
      out.write("            Pais: <input type=\"text\" name=\"pais\"><br>\n");
      out.write("            CEP: <input type=\"text\" name=\"cep\"><br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" name=\"cadastrar\" value=\"Cadastrar\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
