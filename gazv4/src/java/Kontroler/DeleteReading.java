/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.LaczModel;
import Model.OdczytModel;
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

@WebServlet("/DeleteReading")
public class DeleteReading extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");

        int odczytId = Integer.parseInt(req.getParameter("odczytID"));
        String id = req.getParameter("userID");
        System.err.println("odczyt ID" + odczytId);

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            LaczModel lacz = em.find(LaczModel.class, odczytId);
            OdczytModel odczyt = em.find(OdczytModel.class, lacz.getIdOdczyt().getIdOdczyt());

            em.getTransaction().begin();

            em.remove(lacz);
            em.remove(odczyt);

            em.getTransaction().commit();
            em.close();
            HttpSession session = req.getSession();
            session.setAttribute("userID", id);
            resp.sendRedirect("showuser.jsp");
        } catch (Exception e) {
            resp.sendRedirect("error.jsp");
            System.err.println(e);
        }
    }
}
