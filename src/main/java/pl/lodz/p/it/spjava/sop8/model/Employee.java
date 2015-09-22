/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "EmployeeData")
//@XmlRootElement


@DiscriminatorValue("EMPLOYEE")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT d FROM Employee d"),
    @NamedQuery(name = "Employee.findByLogin", query = "SELECT d FROM Employee d WHERE d.login = :login")
})
public class Employee extends Account implements Serializable {


    
    
    
    
    @NotNull
    @Pattern(regexp="^[0-9]{10}$",message="{constraint.string.incorrectNIP}")
    @Column(name = "nip", unique=true, nullable=false, length=10)
    private String nip;
    
//    @OneToMany(mappedBy = "ktoZlozyl")
//    private List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();
//
//    public List<Zamowienie> getZamowienia() {
//        return zamowienia;
//    }

    
                @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Account account;
    
                    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
    
    
    
    
    
    public Employee() {
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
        
    }

    public Object getEnotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


//
//    public Employee(Long id) {
//        this.id = id;
//    }

//    public Employee(Long id, String intercom) {
//        this.id = id;
//        this.intercom = intercom;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getIntercom() {
//        return intercom;
//    }
//
//    public void setIntercom(String intercom) {
//        this.intercom = intercom;
//    }


//
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
//        if (!(object instanceof Employee)) {
//            return false;
//        }
//        Employee other = (Employee) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }
//
////    @Override
////    public String toString() {
////        return "pl.lodz.p.it.spjava.Employeedata[ id=" + id + " ]";
////    }
//    
//}
        
        
        

    
    
    
    
    
    
    
    
    
    
    
    
    
    

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
//    private String intercom;