/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TypModel;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTyp")
public class EditTyp extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        int id_typ = Integer.parseInt(req.getParameter("typID"));
        String nazwa = req.getParameter("nazwa");
        

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
//            Query q = em.createQuery("SELECT t FROM TaryfaModel t WHERE t.idTaryfa = '" + id_taryfa + "'");
            TypModel typ = em.find(TypModel.class, id_typ);
            typ.setNazwa(nazwa);
            
            em.persist(typ);
            em.getTransaction().commit();
            em.close();
            resp.sendRedirect("showtyp.jsp");
        } catch (Exception e) {
            resp.sendRedirect("error.jsp");
        }
    }
    
}
