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

<div class="jumbotron text-center" margin-bottom="0" >
    <h1>BioShop</h1>
    <p>Compra bio direttamente da casa tua!</p>

</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid" >
        <div class="navbar-header" margin-top="0">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">WebSiteName</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index.html">Home</a></li>
                <li><a href="Prodotti.jsp">Prodotti</a></li>
                <li><a href="ShowAllProduttori.jsp">Produttori</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="registrazione.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
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
