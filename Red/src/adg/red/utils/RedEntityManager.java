/*
 * The RedEntityManager class manages all the entity of the application.
 *
 */
package adg.red.utils;

import adg.red.encryptor.Encryptor;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;

/**
 * The RedEntityManager class manages all the entity of the application.
 * <p/>
 * @author harsimran.maan
 */
public class RedEntityManager
{

    private static final EntityManagerFactory emf;
    private static final EntityManager em;

    static
    {
        Map<String, String> dbProperties = new HashMap<>();
        final ConfigManager config = ConfigManager.getInstance();
        dbProperties.put("javax.persistence.jdbc.url", config.getPropertyValue("dbConnection"));
        dbProperties.put("javax.persistence.jdbc.user", config.getPropertyValue("dbUserId"));
        dbProperties.put("javax.persistence.jdbc.password", Encryptor.decryptAES(config.getPropertyValue("dbUserToken")));
        emf = Persistence.createEntityManagerFactory("RedPU", dbProperties);
        em = emf.createEntityManager();

    }

    /**
     * The getter function for em.
     * <p/>
     * @return the em variable
     */
    public static EntityManager getEntityManager()
    {
        return em;
    }

    /**
     * The function to save an input object to the database.
     * <p/>
     * @param obj the object to be saved
     */
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
            throw (ex);
        }
    }

    /**
     * The function to get an entity by inputing String name
     * <p/>
     * @param name the name of the entity
     * <p/>
     * @return the EntityType of an input String name
     */
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

    /**
     * Removes an entry from the database
     * <p/>
     * @param obj The entity object to remove
     */
    public static void delete(Object obj)
    {
        em.getTransaction().begin();
        try
        {
            em.remove(obj);

            em.getTransaction().commit();
        }
        catch (Exception ex)
        {
            em.getTransaction().rollback();
            throw (ex);
        }
    }
}
