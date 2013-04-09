/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.models;

import adg.red.utils.LocaleManager;
import adg.red.utils.RedEntityManager;
import java.io.Serializable;
import java.util.List;
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
 * @author jayzt_000
 */
@Entity
@Table(name = "Grade")
@XmlRootElement
@NamedQueries(
        {
    @NamedQuery(name = "Grade.findAll", query = "SELECT g FROM Grade g"),
    @NamedQuery(name = "Grade.findByGradeId", query = "SELECT g FROM Grade g WHERE g.gradeId = :gradeId"),
    @NamedQuery(name = "Grade.findByName", query = "SELECT g FROM Grade g WHERE g.name = :name")
})
public class Grade implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gradeId")
    private Integer gradeId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public Grade()
    {
    }

    public Grade(Integer gradeId)
    {
        this.gradeId = gradeId;
    }

    public Grade(Integer gradeId, String name)
    {
        this.gradeId = gradeId;
        this.name = name;
    }

    public Integer getGradeId()
    {
        return gradeId;
    }

    public void setGradeId(Integer gradeId)
    {
        this.gradeId = gradeId;
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
        hash += (gradeId != null ? gradeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grade))
        {
            return false;
        }
        Grade other = (Grade) object;
        if ((this.gradeId == null && other.gradeId != null) || (this.gradeId != null && !this.gradeId.equals(other.gradeId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "adg.red.models.Grade[ gradeId=" + gradeId + " ]";
    }

    public static Grade getByName(String name) throws Exception
    {
        List<Grade> gradeList = RedEntityManager.getEntityManager().createNamedQuery("Grade.findByName").setParameter("name", name).getResultList();
        if (gradeList.size() == 1)
        {
            return gradeList.get(0);
        }
        else
        {
            throw new Exception(LocaleManager.get(100));
        }
    }
}
