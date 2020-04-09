package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/ProduttoriServlet")
public class ProduttoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var produttori=(ArrayList<Produttore>)getServletContext().getAttribute("produttori");
        Produttore oggetto=new Produttore();
        String c=req.getParameter("prod");


        for(int i=0;i<produttori.size();i++){

            if(produttori.get(i).getpIva().compareTo(c)==0){
                oggetto=produttori.get(i);}
        }

        var pD=new ProduttoreDAO();


         ArrayList<Prodotto> prodotti=new ArrayList<>();
        prodotti=(ArrayList<Prodotto>) pD.doRetrieveAllByProduttore(oggetto);

        req.setAttribute("prodotti",prodotti);
        req.setAttribute("produttore",oggetto);

        RequestDispatcher dispatcher=
                req.getRequestDispatcher("/WEB-INF/produttore.jsp");
        dispatcher.forward(req,resp);

    }
}
