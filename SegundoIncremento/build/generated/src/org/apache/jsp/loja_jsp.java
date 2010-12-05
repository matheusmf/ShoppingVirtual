package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import aplicacao.*;
import controladoresJpa.*;

public final class loja_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    LojaJpaController lojaJpa = new LojaJpaController();
    ProdutoJpaController produtoJpa = new ProdutoJpaController();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"estrutura.css\" rel=\"stylesheet\" type=\"text/css\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<title>Shopping Virtual - ");
 out.println(lojaJpa.findLoja(1).getNome()); 
      out.write("</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body> <div class=\"pagina\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("\r\n");
      out.write("<!-- MENU SUPERIOR XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("\r\n");
      out.write("    <div id=\"topo\">\r\n");
      out.write("        <div id=\"menuEsquerda\" class=\"menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("            \t<li><img class=\"imgLinha\" src=\"icones/16x16/home.png\" />\r\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                <li><img class=\"imgLinha\" src=\"icones/16x16/next.png\" />\r\n");
      out.write("                <li><a href=\"loja.jsp\">Loja</a></li>\r\n");
      out.write("                <li><img class=\"imgLinha\" src=\"icones/16x16/help.png\" />\r\n");
      out.write("                <li><a href=\"apresentacao.jsp\">Quem Somos?</a></li>\r\n");
      out.write("                <li><img class=\"imgLinha\" src=\"icones/16x16/comments.png\" />\r\n");
      out.write("                <li><a href=\"atendimento.jsp\">Atendimento</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"menuDireita\" class=\"menu\">\r\n");
      out.write("          <ul>\r\n");
      out.write("<li><a href=\"meuspedidos.jsp\">Meus Pedidos</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"carrinho.jsp\">Carrinho</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        \t<div class=\"clearFloat\"></div>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<!-- MENU DE BUSCA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("\r\n");
      out.write("        <div id=\"menuBusca\" class=\"menuBusca\">\r\n");
      out.write("            <div id=\"logo\"></div>\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><input type=\"text\" name=\"Buscar\" id=\"busca\" value=\"Buscar...\" onfocus=\"if(value == 'Buscar...'){value = ''}\" onblur=\"if(value == ''){value = 'Buscar...'}\"/></li>\r\n");
      out.write("                <li><a href=\"\"><img class=\"imgLinha\" src=\"icones/16x16/search.png\" /></a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("            <div class=\"clearFloat\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--MENU DA LOJA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("    \r\n");
      out.write("        <div id=\"loja\">\r\n");
      out.write("\t\t  <a href=\"Index.html\">\r\n");
      out.write("          <div class=\"lojalinha\">  \r\n");
      out.write("         \t    <div>\r\n");
      out.write("          \t        <img class=\"imgLoja\" src=\"imgLojas/testeloja.png\" />\r\n");
      out.write("         \t    </div>\r\n");
      out.write("\t\t\t<div id=\"tituloLoja\">\r\n");
      out.write("                            <label > ");
 out.println(lojaJpa.findLoja(1).getNome()); 
      out.write(" </label>\r\n");
      out.write("            \t</div>\r\n");
      out.write("                <div id=\"decritivoLoja\">\r\n");
      out.write("            \t\t<label > Descricao: descricao da loja aple </label>\r\n");
      out.write("            \t</div>\r\n");
      out.write("\t\t\t<div class=\"clearFloat\"></div>\r\n");
      out.write("         </div>\r\n");
      out.write("    \t </a>\r\n");
      out.write("\r\n");
      out.write("<!--MENU DE PRODUTOS DA LOJA XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("\r\n");
      out.write("    <div></div>\r\n");
      out.write("    <div id=\"produtos\">\r\n");
      out.write("        <div class=\"linha\">\r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(1).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/iphone3g100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/> ");
 out.print(produtoJpa.findProduto(1).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(1).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a> \r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(2).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/macbook100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(2).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(2).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a> \r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(3).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/ipodclassic100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(3).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(3).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a> \r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(4).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/macmini100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(4).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(4).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a> \r\n");
      out.write("                    <div class=\"clearFloat\"></div>\r\n");
      out.write("         </div>\r\n");
      out.write("         <div class=\"linha\">\r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(5).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/ipodnano100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/> ");
 out.print(produtoJpa.findProduto(5).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(5).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(6).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/macbookair100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(6).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(6).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(7).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/macpro100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(7).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(7).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <a href=\"produto.jsp?idProduto=");
      out.print(produtoJpa.findProduto(8).getId());
      out.write("\">\r\n");
      out.write("                        <div class=\"produtoContent\">\r\n");
      out.write("                            <img src=\"imgprodutos/");
      out.print(lojaJpa.findLoja(1).getNome());
      out.write("/imac100x100.png\"/>\r\n");
      out.write("                            <label id=\"tituloProduto\"><br/>");
 out.print(produtoJpa.findProduto(8).getNome()); 
      out.write("</label>\r\n");
      out.write("                            <label id=\"precoProduto\"><br/>Por: R$ ");
 out.print(produtoJpa.findProduto(8).getPreco()); 
      out.write("0</label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <div class=\"clearFloat\"></div>\r\n");
      out.write("         </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->    \r\n");
      out.write("\r\n");
      out.write("    <div id=\"footer\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--MENU DE CONTATO/INFORMAï¿½ï¿½O XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("\r\n");
      out.write("        <div id=\"menuInf\" class=\"menuInf\">\r\n");
      out.write("            <div class=\"menuInf\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"\">Mais Informacoes</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"\"></a>Formas de Pagamento</li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"\">Contato</a></li>\r\n");
      out.write("             </ul>\r\n");
      out.write("            </div> \r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"clearFloat\"></div>\r\n");
      out.write("\r\n");
      out.write("<!--MENU INFERIOR XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"topo\">\r\n");
      out.write("        <div id=\"menuEsquerda\" class=\"menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"index.jsp\">Home</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"lojas.jsp\">Loja</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"apresentacao.jsp\">Quem Somos?</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"atendimento.jsp\">Atendimento</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"menuDireita\" class=\"menu\">\r\n");
      out.write("            <ul>\r\n");
      out.write("                <li><a href=\"meuspedidos.jsp\">Meus Pedidos</a></li>\r\n");
      out.write("                <li>|</li>\r\n");
      out.write("                <li><a href=\"carrinho.jsp\">Carrinho</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"clearFloat\"></div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("<!--XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-->\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
