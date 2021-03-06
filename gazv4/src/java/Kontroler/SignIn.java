/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TypModel;
import Model.UzytkownikModel;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    public SignIn() {

    }

//    public SignIn(String imie, String nazwisko, String email, String haslo, String ulica, String nrBud, String miasto, String kodPoczt){
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//        
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//        UzytkownikModel user = new UzytkownikModel();
//        user.setImie(imie);
//        
//        em.getTransaction().commit();
//        em.close();
//        
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String imie = req.getParameter("imie");
        String nazwisko = req.getParameter("nazwisko");
        String email = req.getParameter("email");
        String haslo = req.getParameter("haslo");
        String ulica = req.getParameter("ulica");
        String nrBud = req.getParameter("nrBud");
        String miasto = req.getParameter("miasto");
        String kodPoczt = req.getParameter("kodPoczt");
        try{
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);        
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        UzytkownikModel user = new UzytkownikModel(imie, nazwisko, nrBud, ulica, miasto, kodPoczt, email, haslo);
        em.persist(user);
        Query q = em.createQuery("SELECT t FROM TypModel t WHERE t.idTyp ='"+1+"'");
        TypModel typ =(TypModel) q.getSingleResult();
        user.setTyp(typ);        
        em.getTransaction().commit();
        
        
        em.close();
        resp.sendRedirect("potwierdzenie.jsp");
        }catch(Exception e){
            resp.sendRedirect("error.jsp");
        }

    }

    public static void main(String[] args) {

    }
}
