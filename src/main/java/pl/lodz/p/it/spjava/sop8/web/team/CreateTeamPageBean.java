package pl.lodz.p.it.spjava.sop8.web.team;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.TeamException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.account.AccountSession;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

@ManagedBean(name = "createTeamPageBean")
@RequestScoped
public class CreateTeamPageBean {

    public CreateTeamPageBean() {
    }

    
    @ManagedProperty(value="#{teamSession}")
    private TeamSession teamSession;

    @PostConstruct
    public void construct(){
        accountList = teamSession.getAllOfType("Manager");
        team = new Team();
    }
    
    private List<Account> accountList;
    
    private Team team;
    
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    public List<Account> getAccountList() {
        return accountList;
    }

    public TeamSession getTeamSession() {
        return teamSession;
    }

    public void setTeamSession(TeamSession teamSession) {
        this.teamSession = teamSession;
    }
    
    public String createTeam() {
        try {
            teamSession.createTeam(team);
            return "success";
        } catch (AppBaseException ex) {
            if (TeamException.KEY_DB_CONSTRAINT.equals(ex.getMessage())) {
                ContextUtils.emitInternationalizedMessage("teamName", TeamException.KEY_DB_CONSTRAINT);
            } else {
                Logger.getLogger(TeamSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji createTeam wyjatku: ", ex);
            }
            return null;
        }
    }
}

