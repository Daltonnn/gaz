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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowEdit")
public class ShowEditUser extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    public UzytkownikModel getUser(String userId) {
        int id = Integer.parseInt(userId);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT u FROM UzytkownikModel u WHERE u.idUzytkownik = '" + id + "' ORDER BY u.nazwisko ASC");
        UzytkownikModel user = (UzytkownikModel) q.getSingleResult();
        return user;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String id = null;
        if (request.getParameter("userID") == null) {
            id = request.getSession(true).getAttribute("userID").toString();
            System.err.println(id);
        } else {
            id = request.getParameter("userID");
        }

        int userid = Integer.parseInt(id);
        ShowEditUser cos = new ShowEditUser();

        session.setAttribute("userID", id);

        response.sendRedirect("showuser.jsp");
    }

    public static void main(String[] args) {
        ShowEditUser cos = new ShowEditUser();
        UzytkownikModel user = cos.getUser("2");
        System.out.println(user.getImie());
    }

}
