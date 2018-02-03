/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.TaryfaModel;
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

@WebServlet("/ShowEditTariff")
public class ShowEditTariff extends HttpServlet {
    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";
    
     public TaryfaModel getTariff (String tariffId){
        int id = Integer.parseInt(tariffId);
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        Query q = em.createQuery("SELECT t FROM TaryfaModel t WHERE t.idTaryfa = '"+id+"'");
        TaryfaModel taryfa = (TaryfaModel) q.getSingleResult();        
        return taryfa;
    }
     
     protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        
        String id = request.getParameter("tariffID");
        int tariffID = Integer.parseInt(id);
        
        
        session.setAttribute("tariffID", id);       
        
        response.sendRedirect("showtarif.jsp");   
    }
    
}
