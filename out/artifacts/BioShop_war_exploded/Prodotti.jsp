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





    <%  ProdottoDAO pD=new ProdottoDAO();
        ArrayList<Prodotto> prodotti=new ArrayList<>();
        prodotti=pD.doRetrieveAll();
        for(int i=0;i<prodotti.size();i++){%>


    <div class="row">
        <div class="col-md-4">
            <div class="thumbnail">
                <a href="<%=prodotti.get(i).getImmagine()%>">
                    <img src="<%=prodotti.get(i).getImmagine()%>" alt="Lights" style="width:100%">
                    <div class="caption">
                        <p><%= prodotti.get(i).getNome() %> <%= prodotti.get(i).getPrezzo()%>€</p>

                        <form action="Delete">
                            <input type="submit" value="delete" >
                        </form>
                    </div>
                </a>
            </div>
        </div>



    <% };%>



</body>
</html>
