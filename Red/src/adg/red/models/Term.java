/*
 * 
 * 
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

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

    /**
     * Default constructor
     */
    public Term()
    {
    }

    /**
     * Constructor
     * @param termPK primary keys of term table
     */
    public Term(TermPK termPK)
    {
        this.termPK = termPK;
    }

    /**
     * Constructor
     * @param termPK primary keys of term table
     * @param isActive table attribute isActive
     */
    public Term(TermPK termPK, boolean isActive)
    {
        this.termPK = termPK;
        this.isActive = isActive;
    }

    /**
     * Constructor
     * @param termYear table attribute termYear
     * @param sessionId table attribute sessionId
     */
    public Term(int termYear, int sessionId)
    {
        this.termPK = new TermPK(termYear, sessionId);
    }

    /**
     * Get primary keys of term table
     * @return primary keys
     */
    public TermPK getTermPK()
    {
        return termPK;
    }

    /**
     * Set primary keys of term table
     * @param termPK primary keys
     */
    public void setTermPK(TermPK termPK)
    {
        this.termPK = termPK;
    }

    /**
     * Get table attributes isActive
     * @return isActive
     */
    public boolean getIsActive()
    {
        return isActive;
    }

    /**
     * Set table attribute isActive
     * @param isActive table attributes
     */
    public void setIsActive(boolean isActive)
    {
        this.isActive = isActive;
    }

    /**
     * Get table attribute session
     * @return session
     */
    public Session getSession()
    {
        return session;
    }

    /**
     * Set table attribute session
     * @param session table attribute
     */
    public void setSession(Session session)
    {
        this.session = session;
    }
    
    /**
     * Get record location
     * @return hash code 
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (termPK != null ? termPK.hashCode() : 0);
        return hash;
    }

     /**
     * Comparator
     * @param object object to be compared with
     * @return true if two object equal to each other, otherwise return false
     */  
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
    
    /**
     * print primary keys of term table
     * @return termPK
     */
    @Override
    public String toString()
    {
        return "adg.red.models.Term[ termPK=" + termPK + " ]";
    }
}
