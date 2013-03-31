/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @Basic(optional = false)
    @Column(name = "sessionId")
    private Integer sessionId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sessionId")
    private Collection<Term> termCollection;

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

    @XmlTransient
    public Collection<Term> getTermCollection()
    {
        return termCollection;
    }

    public void setTermCollection(Collection<Term> termCollection)
    {
        this.termCollection = termCollection;
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
}
