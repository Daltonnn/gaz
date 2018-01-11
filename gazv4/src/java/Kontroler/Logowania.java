/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.UzytkownikModel;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian
 */
@WebServlet("/Logowania")
public class Logowania extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    public int checkUser(String email, String password) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        try {
            Query q = em.createQuery("SELECT u FROM UzytkownikModel u WHERE u.email = '" + email + "'");
            UzytkownikModel user = (UzytkownikModel) q.getSingleResult();
            user.getHaslo().equals(password);
            em.close();

            if (user.getHaslo().equals(password) && user.getPotwierdz() == true) {
                return user.getIdUzytkownik();
            } else {
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // request.getRequestDispatcher("link.html").include(request, response);

        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        Logowania login = new Logowania();

        if (login.checkUser(email, password) > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("IdUzytkownik", login.checkUser(email, password));
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    public static void main(String[] args) {
        String login = "admin@admin.com";
        String haslo = "admin";
        Logowania logowania = new Logowania();
        if (logowania.checkUser(login, haslo) > 0) {
            System.out.println("Zalogowany");
        } else {
            System.out.println("Nie zalogowany");
        }

    }
}
