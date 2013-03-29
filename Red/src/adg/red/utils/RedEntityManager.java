/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author harsimran.maan
 */
public class RedEntityManager {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    static {
        emf = Persistence.createEntityManagerFactory("RedPU");
        em = emf.createEntityManager();

    }

    public static EntityManager getEntityManager() {

        return em;
    }

    public static void save(Object obj) {
        // begin transaction 
        em.getTransaction().begin();
        if (!em.contains(obj)) {
            // persist object - add to entity manager
            em.persist(obj);
            // flush em - save to DB
            em.flush();
        }
        // commit transaction at all
        em.getTransaction().commit();
    }
}
