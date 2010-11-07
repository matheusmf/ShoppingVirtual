<! Para rodar, tem que mudar o nome do arquivo para index.jsp e montar a estrura de pastas na pasta webapps do tomcat>
<%@page import="java.util.*"%>

<html>
<head><title>Hello World JSP</title>
</head>
<body>

<%
	ArrayList lista = new ArrayList();
	
	lista.add("Hello World JSP!");
	
	Iterator it = lista.iterator();
	while(it.hasNext()){
		String s = (String)it.next();
		out.println("<TR><TD>"+s.toString()+"</TD></TR>");
	}
    
%>

</body>
</html>