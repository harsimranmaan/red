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

    public TermPK()
    {
    }

    public TermPK(int termYear, int sessionId)
    {
        this.termYear = termYear;
        this.sessionId = sessionId;
    }

    public int getTermYear()
    {
        return termYear;
    }

    public void setTermYear(int termYear)
    {
        this.termYear = termYear;
    }

    public int getSessionId()
    {
        return sessionId;
    }

    public void setSessionId(int sessionId)
    {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += termYear;
        hash += sessionId;
        return hash;
    }

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

    @Override
    public String toString()
    {
        return "adg.red.models.TermPK[ termYear=" + termYear + ", sessionId=" + sessionId + " ]";
    }
}
