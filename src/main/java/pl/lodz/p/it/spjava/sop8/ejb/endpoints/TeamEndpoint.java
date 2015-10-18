package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.facades.TeamFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.managers.TeamManager;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Team;

@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TeamEndpoint extends AbstractEndpoint implements SessionSynchronization {

    @EJB
    private TeamManager teamManager;
    @EJB
    private TeamFacade teamFacade;
    
    @Resource
    private SessionContext sctx;
    
    
    public void createTeam(Team team) throws AppBaseException {
        teamFacade.createTeam(team);
    }
        public List<Team> getAllTeam() {
        return teamFacade.findAll();
    }
}
