/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author harsimran.maan
 */
@Embeddable
public class TermPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "termYear")
    @Temporal(TemporalType.DATE)
    private Date termYear;
    @Basic(optional = false)
    @Column(name = "sessionId")
    private int sessionId;

    public TermPK()
    {
    }

    public TermPK(Date termYear, int sessionId)
    {
        this.termYear = termYear;
        this.sessionId = sessionId;
    }

    public Date getTermYear()
    {
        return termYear;
    }

    public void setTermYear(Date termYear)
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
        hash += (termYear != null ? termYear.hashCode() : 0);
        hash += (int) sessionId;
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
        if ((this.termYear == null && other.termYear != null) || (this.termYear != null && !this.termYear.equals(other.termYear)))
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
