/*
 * 
 * 
 */
package adg.red.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "GradingScheme")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "GradingScheme.findAll", query = "SELECT g FROM GradingScheme g"),
    @NamedQuery(name = "GradingScheme.findByGradingSchemeId", query = "SELECT g FROM GradingScheme g WHERE g.gradingSchemeId = :gradingSchemeId"),
    @NamedQuery(name = "GradingScheme.findByName", query = "SELECT g FROM GradingScheme g WHERE g.name = :name")
})
public class GradingScheme implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gradingSchemeId")
    private Integer gradingSchemeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public GradingScheme()
    {
    }

    public GradingScheme(Integer gradingSchemeId)
    {
        this.gradingSchemeId = gradingSchemeId;
    }

    public GradingScheme(Integer gradingSchemeId, String name)
    {
        this.gradingSchemeId = gradingSchemeId;
        this.name = name;
    }

    public Integer getGradingSchemeId()
    {
        return gradingSchemeId;
    }

    public void setGradingSchemeId(Integer gradingSchemeId)
    {
        this.gradingSchemeId = gradingSchemeId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (gradingSchemeId != null ? gradingSchemeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GradingScheme))
        {
            return false;
        }
        GradingScheme other = (GradingScheme) object;
        if ((this.gradingSchemeId == null && other.gradingSchemeId != null) || (this.gradingSchemeId != null && !this.gradingSchemeId.equals(other.gradingSchemeId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.GradingScheme[ gradingSchemeId=" + gradingSchemeId + " ]";
    }
}
