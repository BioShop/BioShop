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
</head>
<body>


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
            <option value="<%=pIva%>">"<%=nome%>"</option>
            <% };%>

        </select>
        <input type="submit" value="Visualizza">  <br>
    </form>


</body>
</html>
