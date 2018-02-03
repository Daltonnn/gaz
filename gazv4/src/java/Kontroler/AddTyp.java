/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TaryfaModel;
import Model.TypModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddTyp extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";
    
    public List<TypModel> getTypes(){
        ArrayList<TaryfaModel> typesArrayList = new ArrayList();

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();

            Query q = em.createQuery("SELECT t FROM TypModel t WHERE t.idTyp !="+3);
            List typeList = (List) q.getResultList();          
            
            em.close();
            return typeList;
        } catch (Exception e) {          
          return null;
        }
    }
    
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        String nazwa = req.getParameter("nazwa");        

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            TypModel typ = new TypModel(nazwa);
            em.persist(typ);          
            em.getTransaction().commit();

            em.close();
            resp.sendRedirect("showtypes.jsp");
        } catch (Exception e) {            
            resp.sendError(0, e.getMessage());
        }
    }
    
}
