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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author XXX
 */
@Entity
@Table(name = "AdminData")

@DiscriminatorValue("ADMIN")
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT d FROM Admin d"),
    @NamedQuery(name = "Admin.findByAlarmNumber", query = "SELECT d FROM Admin d WHERE d.alarmNumber = :alarmNumber")
})

public class Admin extends Account implements Serializable {

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
    @Size(max = 12, message = "{constraint.string.length.toolong}")
    @Column(name = "AlarmNumber", unique = true, nullable = false, length = 12)
    private String alarmNumber;
    
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;

    public Admin() {
    }

//    public Admin(Long id) {
//        this.id = id;
//    }
//
//    public Admin(Long id, String alarmnumber) {
//        this.id = id;
//        this.alarmnumber = alarmnumber;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
    public String getAlarmNumber() {
        return alarmNumber;
    }

    public void setAlarmNumber(String number) {
        this.alarmNumber = number;
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
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Admin)) {
//            return false;
//        }
//        Admin other = (Admin) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "pl.lodz.p.it.spjava.Admindata[ id=" + id + " ]";
//    }
//    
//}
