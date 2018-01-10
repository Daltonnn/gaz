/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kontroler;

import Model.UzytkownikModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;
import javax.script.ScriptEngine;

public class Test {

    private static final String PERSISTENCE_UNIT_NAME = "gazv4PU";
    //private EntityManagerFactory factory;

    public String getUserList() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("SELECT u FROM UzytkownikModel u");

        List list = (List) q.getResultList();
        String personList = new String();
        for (int i = 0; i < list.size(); i++) {
            UzytkownikModel user = (UzytkownikModel) list.get(i);
            String imie = user.getImie();
            String nazwisko = user.getNazwisko();           

            personList = personList + imie + " " + nazwisko + "|";
        }
        em.close();
        return personList;
    }

 

    public static void main(String[] args) {
        try {
            System.out.println("*** Demonstracja JPA ***");
            Test test = new Test();
            System.out.println(test.getUserList());
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
