package controller;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UtenteDAO utenteDAO=new UtenteDAO();
        String username=(String)req.getParameter("username");
        String password=(String)req.getParameter("pwd");

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        //codifico la password
        digest.reset();
        digest.update(password.getBytes(StandardCharsets.UTF_8));


        Utente u=utenteDAO.doRetrieveByUsernamePassword(username,password);
        if(u!=null)
        {
            resp.sendRedirect("index.html");
        }
        else
        {
            RequestDispatcher dispatcher=
                    req.getRequestDispatcher("AccountNonPresente.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
