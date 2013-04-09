/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author harsimran.maan
 */
public class RedEntityManager
{

    private static final EntityManagerFactory emf;
    private static final EntityManager em;

    static
    {
        emf = Persistence.createEntityManagerFactory("RedPU");
        em = emf.createEntityManager();
    }

    public static EntityManager getEntityManager()
    {

        return em;
    }

    public static void save(Object obj)
    {
        // begin transaction
        em.getTransaction().begin();
        try
        {
            if (!em.contains(obj))
            {
                // persist object - add to entity manager
                em.persist(obj);
                // flush em - save to DB
                em.flush();
            }
            // commit transaction at all
            em.getTransaction().commit();
        }
        catch (Exception ex)
        {
            em.getTransaction().rollback();
        }
    }

    public static EntityType<?> getEntityByName(String name)
    {
        for (EntityType<?> entity : em.getMetamodel().getEntities())
        {
            if (entity.getName().contains(name))
            {
                try
                {
                    return entity;
                }
                catch (IllegalArgumentException e)
                {
                    // log failure ... typically complains entity is not managed
                }
            }
        }
        return null;
    }
}
