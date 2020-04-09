package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Produttore;
import model.ProduttoreDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.List;


@WebServlet(name="MyInit",urlPatterns = "/MyInit",loadOnStartup = 0)
public class InitServlet extends HttpServlet {

       @Override
        public void init() throws ServletException {
            CategoriaDAO categoriaDAO = new CategoriaDAO();
            List<Categoria> categorie = categoriaDAO.doRetrieveAll();
            getServletContext().setAttribute("categorie", categorie);
           ProduttoreDAO pDAO = new ProduttoreDAO();
           List<Produttore> produttori = pDAO.doRetrieveAll();
           getServletContext().setAttribute("produttori", produttori);
            super.init();


}
}
