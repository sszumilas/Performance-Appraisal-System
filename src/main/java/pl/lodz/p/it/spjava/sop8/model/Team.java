/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author XXX
 */
@Entity
//@MappedSuperclass
@Table(name = "TEAM", schema = "SOP")
@TableGenerator(name = "TeamIdGen", table = "GENERATOR", pkColumnName = "ENTITY_NAME", valueColumnName = "ID_RANGE", pkColumnValue = "Team", initialValue = 100)
//@XmlRootElement
public class Team implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
//    @Column(nullable = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "TeamIdGen")
    private Long id;
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @Column(nullable = false)
//    private Long id;
//    @Basic(optional = false)
//    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "TEAMNAME", nullable = false, length = 255)
    private String teamName;
    @OneToMany(mappedBy = "teamIdFk")
    private List<Personaldata> personaldataList;
    @JoinColumn(name = "TEAM_MANAGER_ID_FK", referencedColumnName = "ID")
    @ManyToOne
    private Account teamManagerIdFk;

    public Team() {
    }

    public Team(Long id) {
        this.id = id;
    }

    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }


//    public Long getId() {
//        return id;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @XmlTransient
    public List<Personaldata> getPersonaldataList() {
        return personaldataList;
    }

    public void setPersonaldataList(List<Personaldata> personaldataList) {
        this.personaldataList = personaldataList;
    }

    public Account getTeamManagerIdFk() {
        return teamManagerIdFk;
    }

    public void setTeamManagerIdFk(Account teamManagerIdFk) {
        this.teamManagerIdFk = teamManagerIdFk;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
//    @PostConstruct
//public void init() {
//    teamName = new Team();
//}

    @Override
    public String toString() {
        return "pl.lodz.p.it.spjava.Team[ id=" + id + " ]";
    }
    
}
