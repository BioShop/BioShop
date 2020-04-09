package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/index.html")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //prendo i prodotti
        ArrayList<Prodotto>prodotti=new ArrayList<>();
        ProdottoDAO pD=new ProdottoDAO();
        prodotti=pD.doRetrieveAll();

        //vedo quali prodotti sono in offerta e li aggiungo al db
        ArrayList<Prodotto> offerte=new ArrayList<>();
        for(int i=0;i<prodotti.size();i++){
            if(prodotti.get(i).isOfferta()){
                offerte.add(prodotti.get(i));
            }
        }
         req.setAttribute("offerte",offerte);


         RequestDispatcher dispatcher=
                req.getRequestDispatcher("/WEB-INF/index.jsp");
        dispatcher.forward(req,resp);


    }
}
