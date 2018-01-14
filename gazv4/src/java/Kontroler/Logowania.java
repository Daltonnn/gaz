/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.UzytkownikModel;
import com.sun.org.apache.xerces.internal.xs.LSInputList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class Logowania extends HttpServlet implements java.io.Serializable {

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

    public List<UzytkownikModel> getUsers() {
        ArrayList<UzytkownikModel> usersArrayList = new ArrayList();

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            Query q = em.createQuery("SELECT u FROM UzytkownikModel u");
            List users = (List) q.getResultList();
            for (int i = 0; i < users.size(); i++) {
                UzytkownikModel user = (UzytkownikModel) users.get(i);
                if (user.getTyp().getIdTyp() != 3) {
                    usersArrayList.add(user);                     
                }
            }            
            List<UzytkownikModel> usersList = (List) usersArrayList;
            em.close();
            return usersList;
        } catch (Exception e) {
            System.err.println(e);
            usersArrayList.clear();
            List<UzytkownikModel> usersList = (List) usersArrayList;
            return usersList;
        }
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        // request.getRequestDispatcher("link.html").include(request, response);

        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        Logowania login = new Logowania();
        HttpSession session = request.getSession();

        if (login.checkUser(email, password) > 0) {
            session.setAttribute("IdUzytkownik", login.checkUser(email, password));
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    public static void main(String[] args) {
        Logowania log = new Logowania();

      
        for (UzytkownikModel user : log.getUsers()) {
            System.out.println(user.getImie());

        }

    }
}
