/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ManagerData")
//@XmlRootElement

@DiscriminatorValue("MANAGER")
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT d FROM Manager d"),
    @NamedQuery(name = "Manager.findByIntercom", query = "SELECT d FROM Manager d WHERE d.intercom = :intercom")
})




public class Manager extends Account implements Serializable {
    
    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(nullable = false)
//    private Long id;
//    @Basic(optional = false)
//    @NotNull
//    @Size(min = 1, max = 12)
//    @Column(nullable = false, length = 12)
    
    
    @NotNull
    @Size(max=12,message="{constraint.string.length.toolong}")
    @Column(name = "intercom", unique=true, nullable=false, length=12)
    private String intercom;
    
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public Manager() {
    }

//    public Manager(Long id) {
//        this.id = id;
//    }

//    public Manager(Long id, String intercom) {
//        this.id = id;
//        this.intercom = intercom;
//    }
//
//    public Long getId() {
//        return id;
//    }

//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getIntercom() {
        return intercom;
    }

    public void setIntercom(String intercom) {
        this.intercom = intercom;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Manager)) {
//            return false;
//        }
//        Manager other = (Manager) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "pl.lodz.p.it.spjava.Managerdata[ id=" + id + " ]";
//    }
    
//}
