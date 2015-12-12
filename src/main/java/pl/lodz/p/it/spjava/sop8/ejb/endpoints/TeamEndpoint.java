package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import pl.lodz.p.it.spjava.sop8.ejb.facades.TeamFacade;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Team;

@Stateless
@LocalBean
@PermitAll
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class TeamEndpoint extends AbstractEndpoint {

    @EJB
    private TeamFacade teamFacade;

    @Resource
    private SessionContext sctx;

    @RolesAllowed({"Admin"})
    public void createTeam(Team team) throws AppBaseException {
        teamFacade.create(team);
    }

    @PermitAll
    public List<Team> getAllTeam() {
        return teamFacade.findAll();
    }

    @RolesAllowed({"Admin"})
    public void editTeam(Team team) throws AppBaseException {
        teamFacade.edit(team);
    }

    @RolesAllowed({"Admin"})
    public void deleteTeam(Team team) {
        teamFacade.remove(team);
    }
}
