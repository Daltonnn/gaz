/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TaryfaModel;
import Model.TypModel;
import Model.UzytkownikModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addtariff")
public class AddTariff extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        String nazwa = req.getParameter("nazwa");
        BigDecimal cenaJed = new BigDecimal(req.getParameter("cena_sta"));
        BigDecimal cenaSta = new BigDecimal(req.getParameter("cena_jed"));

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            TaryfaModel taryfa = new TaryfaModel(nazwa, cenaJed , cenaSta);
            em.persist(taryfa);          
            em.getTransaction().commit();

            em.close();
            resp.sendRedirect("potwierdzenie.jsp");
        } catch (Exception e) {
            
            
        }
    }
    
    public List<TaryfaModel> getTaryfa(){
        ArrayList<TaryfaModel> taryfaarylist = new ArrayList();

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            Query q = em.createQuery("SELECT t FROM TaryfaModel t");
            List taryfaList = (List) q.getResultList();          
            
            em.close();
            return taryfaList;
        } catch (Exception e) {
          List cos = (List) taryfaarylist;
          return cos;
        }
    }
}
