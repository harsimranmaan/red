/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Session")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Session.findAll", query = "SELECT s FROM Session s"),
    @NamedQuery(name = "Session.findBySessionId", query = "SELECT s FROM Session s WHERE s.sessionId = :sessionId"),
    @NamedQuery(name = "Session.findByName", query = "SELECT s FROM Session s WHERE s.name = :name")
})
public class Session implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sessionId")
    private Integer sessionId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Session()
    {
    }

    public Session(Integer sessionId)
    {
        this.sessionId = sessionId;
    }

    public Session(Integer sessionId, String name)
    {
        this.sessionId = sessionId;
        this.name = name;
    }

    public Integer getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(Integer sessionId)
    {
        this.sessionId = sessionId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Session))
        {
            return false;
        }
        Session other = (Session) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Session[ sessionId=" + sessionId + " ]";
    }

    public static Session getBySessionId(int id)
    {
        return (Session) RedEntityManager.getEntityManager().createNamedQuery("Session.findBySessionId").setParameter("sessionId", id).getSingleResult();
    }
}
