/*
 * 
 * 
 */
package adg.red.models;

import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    @NamedQuery(name = "Glossary.findByTerm", query = "SELECT g FROM Glossary g WHERE g.term = :term"),
    @NamedQuery(name = "Glossary.findByDefinition", query = "SELECT g FROM Glossary g WHERE g.definition = :definition"),
    @NamedQuery(name = "Glossary.findByTermBeginsWith", query = "SELECT g FROM Glossary g WHERE g.term LIKE  :keyWord")
})
public class Glossary implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "term")
    private String term;
    @Basic(optional = false)
    @Column(name = "definition")
    private String definition;

    public Glossary()
    {
    }

    public Glossary(String term)
    {
        this.term = term;
    }

    public Glossary(String term, String definition)
    {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm()
    {
        return term;
    }

    public void setTerm(String term)
    {
        this.term = term;
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
        hash += (term != null ? term.hashCode() : 0);
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
        if ((this.term == null && other.term != null) || (this.term != null && !this.term.equals(other.term)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Glossary[ term=" + term + " ]";
    }

    public static List<Glossary> getAllGlossary()
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Glossary.findAll").getResultList();
    }

    public static List<Glossary> getByTermBeginsWith(String beginsWith)
    {
        return RedEntityManager.getEntityManager().createNamedQuery("Glossary.findByTermBeginsWith").setParameter("keyWord", beginsWith + "%").getResultList();
    }
}
