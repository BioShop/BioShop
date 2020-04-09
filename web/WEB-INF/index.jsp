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
<div class="container-fluid">
    <% ArrayList<Prodotto> offerte= (ArrayList<Prodotto>) request.getAttribute("offerte");%>

    <%for(int i=0;i<offerte.size();i++){%>
    <%= offerte.get(i).getNome() %>
    <form action="Delete">
        <input type="submit" value="delete" >
    </form>
    <% };%>


    <% ArrayList<Categoria>categorie=(ArrayList<Categoria>)getServletConfig().getServletContext().getAttribute("categorie");%>
    <form action="CategoriaServlet">
        <select id="cat" name="cat">

            <% for(int i=0;i<categorie.size();i++)
            {
                int id=categorie.get(i).getId();
                String nome=categorie.get(i).getNome();%>
            <option value="<%=id%>">"<%=nome%>"</option>
            <% };%>

        </select>
        <input type="submit" value="Visualizza"> <br>
    </form>


    <% ArrayList<Produttore>produttori=(ArrayList<Produttore>)getServletConfig().getServletContext().getAttribute("produttori");%>
    <form action="ProduttoriServlet">
        <select id="produttor" name="prod">

            <% for(int i=0;i<produttori.size();i++)
            {
                String pIva=produttori.get(i).getpIva();
                String nome=produttori.get(i).getNome();%>
            <option value="<%=pIva%>">"<%=nome%>" </option>
            <% };%>

        </select>
        <input type="submit" value="Visualizza">  <br>
    </form>

</div>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">BioShop</a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <form action="CategoriaServlet">
                        <li>Page 1-1</li>
                        <li><a href="#" type="submit" value="1"> frutta</a></li>
                        <li><a href="#">Page 1-3</a></li>
                        </form>
                    </ul>
                </li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>






</body>
</html>
