/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author harsimran.maan
 */
@Entity
@Table(name = "Glossary")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Glossary.findAll", query = "SELECT g FROM Glossary g"),
    @NamedQuery(name = "Glossary.findByPageId", query = "SELECT g FROM Glossary g WHERE g.glossaryPK.pageId = :pageId"),
    @NamedQuery(name = "Glossary.findByTerm", query = "SELECT g FROM Glossary g WHERE g.glossaryPK.term = :term"),
    @NamedQuery(name = "Glossary.findByDefinition", query = "SELECT g FROM Glossary g WHERE g.definition = :definition")
})
public class Glossary implements Serializable
{
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GlossaryPK glossaryPK;
    @Basic(optional = false)
    @Column(name = "definition")
    private String definition;

    public Glossary()
    {
    }

    public Glossary(GlossaryPK glossaryPK)
    {
        this.glossaryPK = glossaryPK;
    }

    public Glossary(GlossaryPK glossaryPK, String definition)
    {
        this.glossaryPK = glossaryPK;
        this.definition = definition;
    }

    public Glossary(int pageId, String term)
    {
        this.glossaryPK = new GlossaryPK(pageId, term);
    }

    public GlossaryPK getGlossaryPK()
    {
        return glossaryPK;
    }

    public void setGlossaryPK(GlossaryPK glossaryPK)
    {
        this.glossaryPK = glossaryPK;
    }

    public String getDefinition()
    {
        return definition;
    }

    public void setDefinition(String definition)
    {
        this.definition = definition;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (glossaryPK != null ? glossaryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Glossary))
        {
            return false;
        }
        Glossary other = (Glossary) object;
        if ((this.glossaryPK == null && other.glossaryPK != null) || (this.glossaryPK != null && !this.glossaryPK.equals(other.glossaryPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Glossary[ glossaryPK=" + glossaryPK + " ]";
    }
}
