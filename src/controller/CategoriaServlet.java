package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var categorie=(ArrayList<Categoria>)getServletContext().getAttribute("categorie");
        Categoria oggetto=new Categoria();
        String c=req.getParameter("cat");
        int cat=Integer.parseInt(c);

        for(int i=0;i<categorie.size();i++){

            if(categorie.get(i).getId()==cat){
                oggetto=categorie.get(i);}
        }

        var cD=new CategoriaDAO();


        ArrayList<Prodotto> prodotti=new ArrayList<>();
        prodotti=(ArrayList<Prodotto>) cD.doRetrieveAllByCat(oggetto);

        req.setAttribute("prodotti",prodotti);
        req.setAttribute("categoria",oggetto);

        RequestDispatcher dispatcher=
                req.getRequestDispatcher("/WEB-INF/categoria.jsp");
        dispatcher.forward(req,resp);


    }

    }

