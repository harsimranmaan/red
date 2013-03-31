/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class GlossaryPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "pageId")
    private int pageId;
    @Basic(optional = false)
    @Column(name = "term")
    private String term;

    public GlossaryPK()
    {
    }

    public GlossaryPK(int pageId, String term)
    {
        this.pageId = pageId;
        this.term = term;
    }

    public int getPageId()
    {
        return pageId;
    }

    public void setPageId(int pageId)
    {
        this.pageId = pageId;
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) pageId;
        hash += (term != null ? term.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlossaryPK))
        {
            return false;
        }
        GlossaryPK other = (GlossaryPK) object;
        if (this.pageId != other.pageId)
        {
            return false;
        }
        if ((this.term == null && other.term != null) || (this.term != null && !this.term.equals(other.term)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.GlossaryPK[ pageId=" + pageId + ", term=" + term + " ]";
    }
}
