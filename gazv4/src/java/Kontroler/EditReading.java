/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.LaczModel;
import Model.OdczytModel;
import Model.UzytkownikModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditReading")
public class EditReading  extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        

        try {
            Date data_od = df.parse(req.getParameter("data_od"));
            Date data_do = df.parse(req.getParameter("data_do"));
            BigDecimal wartosc = new BigDecimal(req.getParameter("wartosc")); 
            int id_odczyt = Integer.parseInt(req.getParameter("odczytIDd"));

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();        
                      
           
            OdczytModel odczyt = em.find(OdczytModel.class, id_odczyt) ;
            odczyt.setDataDo(data_do);
            odczyt.setDataOd(data_od);
            odczyt.setWartosc(wartosc);
           

            em.persist(odczyt);           
            em.getTransaction().commit();

            em.close();
            resp.sendRedirect("showuser.jsp");
        } catch (Exception e) {
            resp.sendRedirect("error.jsp");
        }
    }
    
}
