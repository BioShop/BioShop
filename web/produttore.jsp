<%@ page import="model.Prodotto" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Produttore" %><%--
  Created by IntelliJ IDEA.
  User: lucia
  Date: 08/04/2020
  Time: 22:00
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
    Produttore produttore=(Produttore)request.getAttribute("produttore");
%>

<h1> <%=produttore.getNome()%></h1>  <br>
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
