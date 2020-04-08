package controller;

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

@WebServlet("/Prova")
public class Prova extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdottoDAO pD=new ProdottoDAO();
        ArrayList<Prodotto>prodotti =new ArrayList<>();
                prodotti=pD.doRetrieveAll();
                req.setAttribute("prodotti",prodotti);

        RequestDispatcher dispatcher=
                req.getRequestDispatcher("/WEB-INF/provaDoRetrieveAll.jsp");
        dispatcher.forward(req,resp);
    }
}
