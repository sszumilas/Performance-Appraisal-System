/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "Account")

@SecondaryTable(name = "PersonalData")
@TableGenerator(name = "AccountIdGen", table = "GENERATOR", 
        pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", 
        pkColumnValue = "Account", initialValue = 100)
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("ACCOUNT")
//@XmlRootElement
public class Account extends AbstractEntity implements Serializable {

    public Account() {
    }

    @Override
    protected Object getBusinessKey() {
        return login;
    }
//    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue(strategy = GenerationType.TABLE, 
            generator = "AccountIdGen")
    private Long id;

    @NotNull(message = "{constraint.notnull}")
    @Size(min = 6, message = "{constraint.string.length.tooshort}")
    @Column(name = "login", length = 32, nullable = false, unique = true, 
            updatable = false)
    private String login;
    
    @NotNull(message = "{constraint.notnull}")
    @Size(min = 6, message = "{constraint.string.length.tooshort}")
    @Column(name = "password", length = 32, nullable = false)
    private String password;

    
    @Column(name = "confirmed", nullable = false)
    private boolean confirmed;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Column(name = "type", updatable = false)
    private String type;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Personaldata personaldata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Admin admindata;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Manager managerdata;
    @OneToMany(mappedBy = "employeeIdFk")
    private List<Enote> enoteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private Employee employeedata;
    @OneToMany(mappedBy = "teamManagerIdFk")
    private List<Team> teamList;
    @OneToMany(mappedBy = "modificationId")
    private List<Mnote> mnoteList;
    @OneToMany(mappedBy = "confirmId")
    private List<Mnote> mnoteList1;
    @OneToMany(mappedBy = "employeeIdFk")
    private List<Mnote> mnoteList2;
    
    
    @NotNull(message="{constraint.notnull}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    @Column(name = "name", table = "PersonalData", length = 32, nullable = false)
    private String name;

    @NotNull(message="{constraint.notnull}")
    @Size(min=3,max=32,message="{constraint.string.length.notinrange}")
    @Column(name = "surname", table = "PersonalData", length = 32, nullable = false)
    private String surname;

    @NotNull(message="{constraint.notnull}")
    @Size(min=6,max=64,message="{constraint.string.length.notinrange}")
    @Pattern(regexp="^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$",message="{constraint.string.incorrectemail}")
    @Column(name = "email", table = "PersonalData", length = 64, unique = true, nullable = false)
    private String email;
        
    @Size(max=12,message="{constraint.string.length.toolong}")
    @Column(name = "telephone", table = "PersonalData", length = 12, unique = true, nullable = true)
    private String telephone;
    
    
        public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getType() {
        return type;
    }

     
    
    
    
    

    public Account(Long id) {
        this.id = id;
    }


//    public void setId(Long id) {
//        this.id = id;
//    }

//    public void setType(String type) {
//        this.type = type;
//    }



    public Personaldata getPersonaldata() {
        return personaldata;
    }

    public void setPersonaldata(Personaldata personaldata) {
        this.personaldata = personaldata;
    }

    public Admin getAdmindata() {
        return admindata;
    }

    public void setAdmindata(Admin admindata) {
        this.admindata = admindata;
    }

    public Manager getManagerdata() {
        return managerdata;
    }

    public void setManagerdata(Manager managerdata) {
        this.managerdata = managerdata;
    }

    @XmlTransient
    public List<Enote> getEnoteList() {
        return enoteList;
    }

    public void setEnoteList(List<Enote> enoteList) {
        this.enoteList = enoteList;
    }

    public Employee getEmployeedata() {
        return employeedata;
    }

    public void setEmployeedata(Employee employeedata) {
        this.employeedata = employeedata;
    }

    @XmlTransient
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @XmlTransient
    public List<Mnote> getMnoteList() {
        return mnoteList;
    }

    public void setMnoteList(List<Mnote> mnoteList) {
        this.mnoteList = mnoteList;
    }

    @XmlTransient
    public List<Mnote> getMnoteList1() {
        return mnoteList1;
    }

    public void setMnoteList1(List<Mnote> mnoteList1) {
        this.mnoteList1 = mnoteList1;
    }

    @XmlTransient
    public List<Mnote> getMnoteList2() {
        return mnoteList2;
    }

    public void setMnoteList2(List<Mnote> mnoteList2) {
        this.mnoteList2 = mnoteList2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Account[ id=" + id + " ]";
    }

}
