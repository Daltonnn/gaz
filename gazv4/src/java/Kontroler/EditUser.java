package Kontroler;

import Model.TaryfaModel;
import Model.TypModel;
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

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        int id_uzytkownika = Integer.parseInt(req.getParameter("idUser"));
        String imie = req.getParameter("imie");
        String nazwisko = req.getParameter("nazwisko");
        String email = req.getParameter("email");
        String haslo = req.getParameter("haslo");
        String ulica = req.getParameter("ulica");
        String nrBud = req.getParameter("nrBud");
        String miasto = req.getParameter("miasto");
        String kodPoczt = req.getParameter("kodPoczt");
        Boolean potwierdz = Boolean.parseBoolean(req.getParameter("potwierdz"));

        String taryfaid = req.getParameter("taryfa");

        String type = req.getParameter("typ");

        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            UzytkownikModel user = em.find(UzytkownikModel.class, id_uzytkownika);
            user.setImie(imie);
            user.setNazwisko(nazwisko);
            user.setEmail(email);
            user.setHaslo(haslo);
            user.setUlica(ulica);
            user.setNrMiesz(nrBud);
            user.setMiasto(miasto);
            user.setKodPoczt(kodPoczt);

            if (potwierdz != null) {
                user.setPotwierdz(potwierdz);
            }

            if (taryfaid != null) {
                int idTaryfa = Integer.parseInt(taryfaid);
                TaryfaModel taryfa = em.find(TaryfaModel.class, idTaryfa);
                user.setTaryfa(taryfa);
            }

            if (type!= null) {
                int typid = Integer.parseInt(type);
                TypModel typ = em.find(TypModel.class, typid);
                user.setTyp(typ);
            }

            em.persist(user);

            em.getTransaction().commit();
            em.close();

            resp.sendRedirect("showuser.jsp");
        } catch (Exception e) {
            resp.sendRedirect("error.jsp");
            System.err.println(e);
        }
    }
}
