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

@WebServlet("/AddReading")
public class AddReading extends HttpServlet {

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
            int id_uzytkownika = Integer.parseInt(req.getParameter("UserId"));

            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();

            Query q = em.createQuery("SELECT u FROM UzytkownikModel u WHERE u.idUzytkownik = '" + id_uzytkownika + "'");
            UzytkownikModel user = (UzytkownikModel) q.getSingleResult();

            
            //suma = wartosc * user.getTaryfa().getCenaJed() + user.getTaryfa().getCenaLicz();
//            suma.add(user.getTaryfa().getCenaJed());
//            System.err.println(suma.toString());
//            System.err.println(user.getTaryfa().getCenaJed().toString());
//            suma.multiply(wartosc);            
//            System.err.println(suma.toString());
//            System.err.println(wartosc.toString());
//            suma.add(user.getTaryfa().getCenaLicz());
//            System.err.println(user.getTaryfa().getCenaLicz().toString());
            
            BigDecimal suma = user.getTaryfa().getCenaJed().multiply(wartosc).add(user.getTaryfa().getCenaLicz());
            
            System.err.println(suma.toString());
            OdczytModel odczyt = new OdczytModel(data_od, data_do, suma);
            LaczModel lacz = new LaczModel();
            lacz.setIdOdczyt(odczyt);
            lacz.setIdUzytkownik(user);

            em.persist(odczyt);
            em.persist(lacz);
            em.getTransaction().commit();

            em.close();
            resp.sendRedirect("potwierdzenie.jsp");
        } catch (Exception e) {
            resp.sendRedirect("error.jsp");
        }
    }

}
