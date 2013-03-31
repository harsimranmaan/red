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
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Term.findByTermId", query = "SELECT t FROM Term t WHERE t.termId = :termId"),
    @NamedQuery(name = "Term.findByYear", query = "SELECT t FROM Term t WHERE t.year = :year"),
    @NamedQuery(name = "Term.findByIsActive", query = "SELECT t FROM Term t WHERE t.isActive = :isActive")
})
public class Term implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "termId")
    private String termId;
    @Basic(optional = false)
    @Column(name = "year")
    @Temporal(TemporalType.DATE)
    private Date year;
    @Basic(optional = false)
    @Column(name = "isActive")
    private boolean isActive;
    @JoinColumn(name = "sessionId", referencedColumnName = "sessionId")
    @ManyToOne(optional = false)
    private Session sessionId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "term")
    private Collection<Section> sectionCollection;

    public Term()
    {
    }

    public Term(String termId)
    {
        this.termId = termId;
    }

    public Term(String termId, Date year, boolean isActive)
    {
        this.termId = termId;
        this.year = year;
        this.isActive = isActive;
    }

    public String getTermId()
    {
        return termId;
    }

    public void setTermId(String termId)
    {
        this.termId = termId;
    }

    public Date getYear()
    {
        return year;
    }

    public void setYear(Date year)
    {
        this.year = year;
    }

    public boolean getIsActive()
    {
        return isActive;
    }

    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    public Session getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(Session sessionId)
    {
        this.sessionId = sessionId;
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
        hash += (termId != null ? termId.hashCode() : 0);
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
        if ((this.termId == null && other.termId != null) || (this.termId != null && !this.termId.equals(other.termId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Term[ termId=" + termId + " ]";
    }
}
