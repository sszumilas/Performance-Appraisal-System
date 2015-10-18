package pl.lodz.p.it.spjava.sop8.web.team;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.TeamEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import  pl.lodz.p.it.spjava.sop8.model.Team;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;

/**
 *
 * @author java
 */
@ManagedBean(name = "teamSession")
@SessionScoped
public class TeamSession implements Serializable{

    static String saveTeamEdit(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @EJB
    private TeamEndpoint teamEndpoint;
    private Team teamCreate;
    

//    public List<Team> znajdzBedaceNaStanie() {
//        return produktEndpoint.znajdzBedaceNaStanie();
//    }

    public Team getTeamCreate(){
        return teamCreate;
    }
    
    
    public String createTeam() throws AppBaseException {
        teamEndpoint.createTeam(teamCreate);
//        resetCreateTeam();
        return "success";
}

//    private void resetCreateTeam() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    Team getTeamEdit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Team getTeam() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void createTeam(Team team) {
        
    }

    List<Team> matchTeam(String requestTeamName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}