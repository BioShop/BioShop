<%@ page import="model.Produttore" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.Categoria" %>
<%@ page import="model.ProdottoDAO" %><%--
  Created by IntelliJ IDEA.
  User: lucia
  Date: 09/04/2020
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
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
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
            </ul>
        </div>
    </div>
</nav>

<% ArrayList<Categoria> categorie=(ArrayList<Categoria>)getServletConfig().getServletContext().getAttribute("categorie");%>


<form action="CategoriaServlet">
    <select id="cat" name="cat">

        <% for(int i=0;i<categorie.size();i++)
        {
            int id=categorie.get(i).getId();
            String nome=categorie.get(i).getNome();%>
        <option value="<%=id%>">"<%=nome%>"</option>
        <% };%>

    </select>

    <input type="submit" value="cerca">

</form>


    <%  ProdottoDAO pD=new ProdottoDAO();
        ArrayList<Prodotto> prodotti=new ArrayList<>();
        prodotti=pD.doRetrieveAll();
        for(int i=0;i<prodotti.size();i++){%>
<div class="container-fluid">
    <div class="row">
            <div class="col-md-3">
                <div class="thumbnail">

                        <img src="<%=prodotti.get(i).getImmagine()%>"  style="width:25%">
                        <div class="caption">
                            <p><%= prodotti.get(i).getNome() %> <%= prodotti.get(i).getPrezzo()%>€</p>

                            <form action="Delete">
                                <input type="submit" value="delete" >
                            </form>
                        </div>
                    </a>
                </div>
            </div>

    </div>



    <% };%>



</body>
</html>
