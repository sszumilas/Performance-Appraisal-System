package pl.lodz.p.it.spjava.sop8.web.team;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountEndpoint;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.TeamEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.*;


@ManagedBean(name = "teamSession")
@SessionScoped
public class TeamSession implements Serializable {

    private static final Logger logger = Logger.getLogger(TeamSession.class.getSimpleName());

    
    @EJB
    private TeamEndpoint teamEndpoint;

    @EJB
    private AccountEndpoint accountEndpoint;
    
    private Team teamEdit;

    public Team getTeamEdit() {
        return teamEdit;
    }

    public void setTeamEdit(Team teamEdit) {
        this.teamEdit = teamEdit;
    }
    
    public List<Account> getAllOfType(String type){
       return accountEndpoint.getAllOfType(type);
    }
    
    public void createTeam(Team team) throws AppBaseException{
        teamEndpoint.createTeam(team);
    }
    
    public List<Team> getAllTeam(){
        return teamEndpoint.getAllTeam();
    }
    
    public void editTeam(Team team) throws AppBaseException{
        teamEndpoint.editTeam(team);
    }
    
    public void deleteTeam(Team team){
        teamEndpoint.deleteTeam(team);
    }
}