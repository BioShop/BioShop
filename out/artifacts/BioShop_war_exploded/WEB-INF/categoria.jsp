<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lucia
  Date: 08/04/2020
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ArrayList<Prodotto> prodotti=(ArrayList<Prodotto>) request.getAttribute("prodotti");
    Categoria categoria=(Categoria)request.getAttribute("categoria");
%>

<h1> <%=categoria.getNome()%></h1> <h4>Descrizione:<%=categoria.getDescrizione()%></h4> <br>
<% for(int i=0;i<prodotti.size();i++){%>


     <img src="<%=prodotti.get(i).getImmagine()%>"><br>
<li>
        <%=prodotti.get(i).getNome()%>
        <%=prodotti.get(i).getPrezzo()%>€
</li>
<br>
<% };%>
<a href="index.html">Home</a>
</body>
</html>
