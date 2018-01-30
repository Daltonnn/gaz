/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TaryfaModel;
import Model.UzytkownikModel;
import java.io.IOException;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditTariff")
public class EditTariff extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        int id_taryfa = Integer.parseInt(req.getParameter("tariffID"));
        String nazwa = req.getParameter("nazwa");
        BigDecimal cenaJed = new BigDecimal(req.getParameter("cena_sta"));
        BigDecimal cenaSta = new BigDecimal(req.getParameter("cena_jed"));

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            Query q = em.createQuery("SELECT t FROM TaryfaModel t WHERE t.idTaryfa = '" + id_taryfa + "'");
            TaryfaModel taryfa = (TaryfaModel) q.getSingleResult();
            taryfa.setNazwa(nazwa);
            taryfa.setCenaJed(cenaJed);
            taryfa.setCenaLicz(cenaSta);
            em.persist(taryfa);

            em.getTransaction().commit();

            em.close();
            resp.sendRedirect("showtariff.jsp");
        } catch (Exception e) {

        }
    }
}
