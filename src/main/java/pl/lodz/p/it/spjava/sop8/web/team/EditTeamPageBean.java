package pl.lodz.p.it.spjava.sop8.web.team;

import pl.lodz.p.it.spjava.sop8.web.account.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Admin;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "editTeamPageBean")
@RequestScoped
public class EditTeamPageBean {
    
    public EditTeamPageBean() {
    }
    
    @ManagedProperty(value="#{teamSession}")
    private TeamSession teamSession;

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }
    
    @PostConstruct
    private void init() {
        team = teamSession.getTeamEdit();
    }

    private Team team =  new Team();

    public Team getTeam() {
        return team;
    }
    
//    public boolean isEmployee() {
//        return TeamUtils.isEmployee(team);
//    }
//
//    public boolean isManager() {
//        return TeamUtils.isManager(team);
//    }
//
//    public boolean isAdmin() {
//        return TeamUtils.isAdmin(team);
//    }
    
    public String saveTeam() {
        return TeamSession.saveTeamEdit(team);
    }

}
