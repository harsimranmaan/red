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
public class ResourceDictionaryPK implements Serializable
{
    @Basic(optional = false)
    @Column(name = "resourceId")
    private int resourceId;
    @Basic(optional = false)
    @Column(name = "localeId")
    private int localeId;

    public ResourceDictionaryPK()
    {
    }

    public ResourceDictionaryPK(int resourceId, int localeId)
    {
        this.resourceId = resourceId;
        this.localeId = localeId;
    }

    public int getResourceId()
    {
        return resourceId;
    }

    public void setResourceId(int resourceId)
    {
        this.resourceId = resourceId;
    }

    public int getLocaleId()
    {
        return localeId;
    }

    public void setLocaleId(int localeId)
    {
        this.localeId = localeId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (int) resourceId;
        hash += (int) localeId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceDictionaryPK))
        {
            return false;
        }
        ResourceDictionaryPK other = (ResourceDictionaryPK) object;
        if (this.resourceId != other.resourceId)
        {
            return false;
        }
        if (this.localeId != other.localeId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.ResourceDictionaryPK[ resourceId=" + resourceId + ", localeId=" + localeId + " ]";
    }
}
