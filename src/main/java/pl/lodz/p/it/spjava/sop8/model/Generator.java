/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XXX
 */
@MappedSuperclass
@Table(catalog = "", schema = "SOP")
@XmlRootElement
public class Generator implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ENTITY_NAME", nullable = false, length = 255)
    private String entityName;
    @Column(name = "ID_RANGE")
    private BigInteger idRange;

    public Generator() {
    }

    public Generator(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public BigInteger getIdRange() {
        return idRange;
    }

    public void setIdRange(BigInteger idRange) {
        this.idRange = idRange;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entityName != null ? entityName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Generator)) {
            return false;
        }
        Generator other = (Generator) object;
        if ((this.entityName == null && other.entityName != null) || (this.entityName != null && !this.entityName.equals(other.entityName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Generator[ entityName=" + entityName + " ]";
    }
    
}
