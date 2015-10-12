package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.facades.TeamFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Team;

@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TeamEndpoint extends AbstractEndpoint implements SessionSynchronization{

    @EJB
    private TeamFacade teamFacade;

//    public List<Team> znajdzBedaceNaStanie() {
//        return produktFacade.znajdzBedaceNaStanie();

    public void createTeam(Team team)throws AppBaseException {
    teamFacade.create(team);
    }
}
