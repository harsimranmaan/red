/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Term")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Term.findAll", query = "SELECT t FROM Term t"),
    @NamedQuery(name = "Term.findByTermYear", query = "SELECT t FROM Term t WHERE t.termPK.termYear = :termYear"),
    @NamedQuery(name = "Term.findBySessionId", query = "SELECT t FROM Term t WHERE t.termPK.sessionId = :sessionId"),
    @NamedQuery(name = "Term.findByIsActive", query = "SELECT t FROM Term t WHERE t.isActive = :isActive")
})
public class Term implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TermPK termPK;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "sessionId", referencedColumnName = "sessionId", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Session session;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Section> sectionCollection;

    public Term()
    {
    }

    public Term(TermPK termPK)
    {
        this.termPK = termPK;
    }

    public Term(TermPK termPK, boolean isActive)
    {
        this.termPK = termPK;
        this.isActive = isActive;
    }

    public Term(Date termYear, int sessionId)
    {
        this.termPK = new TermPK(termYear, sessionId);
    }

    public TermPK getTermPK()
    {
        return termPK;
    }

    public void setTermPK(TermPK termPK)
    {
        this.termPK = termPK;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Session getSession()
    {
        return session;
    }

    public void setSession(Session session)
    {
        this.session = session;
    }

    @XmlTransient
    public Collection<Section> getSectionCollection()
    {
        return sectionCollection;
    }

    public void setSectionCollection(Collection<Section> sectionCollection)
    {
        this.sectionCollection = sectionCollection;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (termPK != null ? termPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Term))
        {
            return false;
        }
        Term other = (Term) object;
        if ((this.termPK == null && other.termPK != null) || (this.termPK != null && !this.termPK.equals(other.termPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Term[ termPK=" + termPK + " ]";
    }
}
