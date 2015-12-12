package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.TeamException;
import pl.lodz.p.it.spjava.sop8.model.Team;

/**
 *
 * @author Szymek
 */
@Stateless
@RolesAllowed({"Admin"})
@LocalBean
@Interceptors({LoggingInterceptor.class})
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class TeamFacade extends AbstractFacade<Team> {

    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }

    @Override
    public void create(Team entity) throws AppBaseException {
        try {
            super.create(entity);
            em.flush();
        } catch (PersistenceException ex) {
            if (ex.getCause() instanceof DatabaseException || ex.getCause() instanceof SQLIntegrityConstraintViolationException) {
                throw TeamException.createWithDbCheckConstraintKey(entity, ex);
            } else {
                throw ex;
            }
        }
    }
    
    @Override
    public void edit(Team entity) throws AppBaseException{
        try{
            getEntityManager().merge(entity);
            em.flush();
            } catch (PersistenceException ex) {
            if (ex.getCause() instanceof DatabaseException || ex.getCause() instanceof SQLIntegrityConstraintViolationException) {
                throw TeamException.createWithDbCheckConstraintKey(entity, ex);
            } else {
                throw ex;
            }
        }
    }
}
