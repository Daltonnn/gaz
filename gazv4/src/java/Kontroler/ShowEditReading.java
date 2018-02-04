/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.OdczytModel;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowEditReading")
public class ShowEditReading extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    public OdczytModel getReading(String odczytId) {
        try {
            int id = Integer.parseInt(odczytId);            
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            OdczytModel odczyt = em.find(OdczytModel.class, id);
            em.close();
            return odczyt;
            
        } catch (Exception e) {
            return null;
        }
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String id = request.getParameter("odczytIDd");

        session.setAttribute("odczytIDd", id);

        response.sendRedirect("editreading.jsp");
    }

}
