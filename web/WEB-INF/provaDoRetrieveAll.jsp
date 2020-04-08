<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: lucia
  Date: 08/04/2020
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%ArrayList<Prodotto> prodotti= new ArrayList<>();
     prodotti= (ArrayList<Prodotto>) request.getAttribute("prodotti");
     for(int i=0;i<prodotti.size();i++){%>
      <%=prodotti.get(i).getNome()%> <form action="Delete">
        <input type="submit" value="delete" >
    </form>

   <%  };
    %>
</body>
</html>
