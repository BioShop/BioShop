<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page import="model.Produttore" %><%--
  Created by IntelliJ IDEA.
  User: lucia
  Date: 08/04/2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


<nav class="navbar navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">BioShop</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="">Home</a></li>
            <li><a href="Prodotti.jsp">Prodotti</a></li>
            <li><a href="#">Page 3</a></li>
        </ul>
    </div>
</nav>

<% ArrayList<Prodotto> offerte= (ArrayList<Prodotto>) request.getAttribute("offerte");%>

<%for(int i=0;i<offerte.size();i++){%>

<img src="<%=offerte.get(i).getImmagine()%>">
<li>
<%= offerte.get(i).getNome() %>
<%=offerte.get(i).getPrezzo()%>€
<form action="Delete">

    <input type="submit" value="delete" >
</form>
</li>
<% };%>





</body>
</html>
