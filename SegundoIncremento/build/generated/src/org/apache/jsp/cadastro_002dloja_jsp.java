package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import aplicacao.*;
import controladoresJpa.*;

public final class cadastro_002dloja_jsp extends org.apache.jasper.runtime.HttpJspBase
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

    if((request.getParameter("nome") != null) && (request.getParameter("telefone") != null) && (request.getParameter("descricao") != null)
         && (request.getParameter("rua") != null) && (request.getParameter("num") != null) && (request.getParameter("bairro") != null)
         && (request.getParameter("cidade") != null) && (request.getParameter("estado") != null) && (request.getParameter("pais") != null) && (request.getParameter("cep") != null)){

        ShoppingVirtual.getInstancia().cadastraLoja(
        request.getParameter("nome"), request.getParameter("telefone"), request.getParameter("descricao"),
        request.getParameter("rua"), request.getParameter("num"), request.getParameter("bairro"), request.getParameter("cidade"), request.getParameter("estado"), request.getParameter("cep"), request.getParameter("pais"));

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
      out.write("        <title>Cadastro Loja</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"cadastro-loja.jsp\" name=\"cadastro-cliente\">\n");
      out.write("            Dados da Loja:<br>\n");
      out.write("            Nome: <input type=\"text\" name=\"nome\"><br>\n");
      out.write("            Telefone: <input type=\"text\" name=\"telefone\"><br>\n");
      out.write("            Descricao: <input type=\"text\" name=\"descricao\"><br>\n");
      out.write("            <br>\n");
      out.write("            Endereco:<br>\n");
      out.write("            Rua: <input type=\"text\" name=\"rua\"><br>\n");
      out.write("            Numero: <input type=\"text\" name=\"num\"><br>\n");
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
