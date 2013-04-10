/*
 * 
 * 
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class TermPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "termYear")
    private int termYear;
    @Basic(optional = false)
    @Column(name = "sessionId")
    private int sessionId;

    /**
     * Default constructor
     */
    public TermPK()
    {
    }

    /**
     * Constructor
     * @param termYear table attribute termYear
     * @param sessionId table attribute sessionId
     */
    public TermPK(int termYear, int sessionId)
    {
        this.termYear = termYear;
        this.sessionId = sessionId;
    }

    /**
     * Get table attribute termYear
     * @return termYear
     */
    public int getTermYear()
    {
        return termYear;
    }

    /**
     * Set table attribute termYear
     * @param termYear 
     */
    public void setTermYear(int termYear)
    {
        this.termYear = termYear;
    }

    /**
     * Get table attribute sessionId
     * @return sessionId
     */
    public int getSessionId()
    {
        return sessionId;
    }

    /**
     * Set table attribute sessionId
     * @param sessionId 
     */
    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }
    
    /**
     * Get record location
     * @return hash code 
     */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += termYear;
        hash += sessionId;
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
        if (!(object instanceof TermPK))
        {
            return false;
        }
        TermPK other = (TermPK) object;
        if (this.termYear != other.termYear)
        {
            return false;
        }
        if (this.sessionId != other.sessionId)
        {
            return false;
        }
        return true;
    }

    /**
     * print termYear
     * @return termYear as a string
     */
    @Override
    public String toString()
    {
        return "adg.red.models.TermPK[ termYear=" + termYear + ", sessionId=" + sessionId + " ]";
    }
}
