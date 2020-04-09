package controller;

import model.Carrello;
import model.CarrelloDAO;
import model.Utente;
import model.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/registrazione")
public class RegistrazioneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("pwd");
        String email=request.getParameter("email");
        String citta=request.getParameter("citta");
        String ddn=request.getParameter("date");

        //data dobbiamo decidere come trattarla come verificare l'eta ,se fare il calcolo istantaneo tramite javascript oppure tramite java
        Utente utente = new Utente();

        utente.setUsername(username);
        utente.setPassword(password);
        utente.setDdn(ddn);
        utente.setEmail(email);
        utente.setCitta(citta);

        //solo un amministratore può modificare gli altri utenti quindi mettiamo che tutti i nuovi registrati saranna utenti
        utente.setAdmin(false);

        //Creo un nuovo carrello del cliente
        CarrelloDAO cD=new CarrelloDAO();
        //il carrello è vuoto
        double prezzo=0;
        Carrello carrello=new Carrello(prezzo);
        cD.doSave(carrello);
        utente.setCarrello(carrello.getId());

        //memorizzo l'utente nel db
        UtenteDAO utenteDAO=new UtenteDAO();
        utenteDAO.doSave(utente);



        request.getSession().setAttribute("utente", utente);
        response.sendRedirect("index.html");

    }
}
