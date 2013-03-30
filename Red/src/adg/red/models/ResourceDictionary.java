/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.controllers.LoginController;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Table(name = "ResourceDictionary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourceDictionary.findAll", query = "SELECT r FROM ResourceDictionary r"),
    @NamedQuery(name = "ResourceDictionary.findByResourceId", query = "SELECT r FROM ResourceDictionary r WHERE r.resourceDictionaryPK.resourceId = :resourceId"),
    @NamedQuery(name = "ResourceDictionary.findByLocaleId", query = "SELECT r FROM ResourceDictionary r WHERE r.resourceDictionaryPK.localeId = :localeId"),
    @NamedQuery(name = "ResourceDictionary.findByTextString", query = "SELECT r FROM ResourceDictionary r WHERE r.textString = :textString")})
public class ResourceDictionary implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourceDictionaryPK resourceDictionaryPK;
    @Basic(optional = false)
    @Column(name = "textString")
    private String textString;
    @JoinColumn(name = "localeId", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Locale locale;

    public ResourceDictionary() {
    }

    public ResourceDictionary(ResourceDictionaryPK resourceDictionaryPK) {
        this.resourceDictionaryPK = resourceDictionaryPK;
    }

    public ResourceDictionary(ResourceDictionaryPK resourceDictionaryPK, String textString) {
        this.resourceDictionaryPK = resourceDictionaryPK;
        this.textString = textString;
    }

    public ResourceDictionary(int resourceId, int localeId) {
        this.resourceDictionaryPK = new ResourceDictionaryPK(resourceId, localeId);
    }

    public ResourceDictionaryPK getResourceDictionaryPK() {
        return resourceDictionaryPK;
    }

    public void setResourceDictionaryPK(ResourceDictionaryPK resourceDictionaryPK) {
        this.resourceDictionaryPK = resourceDictionaryPK;
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourceDictionaryPK != null ? resourceDictionaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceDictionary)) {
            return false;
        }
        ResourceDictionary other = (ResourceDictionary) object;
        if ((this.resourceDictionaryPK == null && other.resourceDictionaryPK != null) || (this.resourceDictionaryPK != null && !this.resourceDictionaryPK.equals(other.resourceDictionaryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "adg.red.models.ResourceDictionary[ resourceDictionaryPK=" + resourceDictionaryPK + " ]";
    }
    
    public List<ResourceDictionary> getResourceByLocaleId(int localeId) {
        List<ResourceDictionary> resources = null;
        try {
             resources = RedEntityManager.getEntityManager().createNamedQuery("ResourceDictionary.findByLocaleId").setParameter("localeId", localeId).getResultList();
        }
        catch (Exception ex){
                    Logger.getLogger(ResourceDictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
        return resources;
    }
}
