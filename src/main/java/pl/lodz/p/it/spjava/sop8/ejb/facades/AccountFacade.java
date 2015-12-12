package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.SOPJavaDB_PU.Account_;
import pl.lodz.p.it.spjava.sop8.model.Team;

@Stateless
@PermitAll
@LocalBean
@Interceptors({LoggingInterceptor.class})
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    @Override
    public void create(Account entity) throws AppBaseException {
        try {
            super.create(entity);
            em.flush();
        } catch (PersistenceException ex) {
            if (ex.getCause() instanceof DatabaseException || ex.getCause() instanceof SQLIntegrityConstraintViolationException) {
                throw AccountException.createWithDbCheckConstraintKey(entity, ex);
            } else {
                throw ex;
            }
        }
    }

    public List<Account> getAllOfType(String type) {
        TypedQuery<Account> tq = em.createNamedQuery("Account.findByType", Account.class);
        tq.setParameter("x", type);
        return tq.getResultList();
    }

    public List<Account> findAccounts(Account account) {
        
        // jeżeli manager będzie miał więcej niż jeden zespół, to poniże pojawi się wyjątek nonUniqueResultException
        // w przypadku zmian pomysł: pobrać listę teamów zarządzanych przez managera,
        // przeiterować przez listę i wyniki z każdej iteracji zapisać do odrębnej listy
        // zwrócić listę
        Team team;
        try{
        TypedQuery<Team> tqt = em.createNamedQuery("Team.findManager", Team.class);
        tqt.setParameter("x", account.getId());// do sprawdzenia wyświetlania listy
        team = tqt.getSingleResult();
        }catch(NoResultException nre){
            return null;
        }
        TypedQuery<Account> tq = em.createNamedQuery("Account.findAccounts", Account.class);
        tq.setParameter("x", team.getId());// do sprawdzenia wyświetlania listy
        return tq.getResultList();
    }

    public Account findLogin(String login) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = cb.createQuery(Account.class);
        Root<Account> from = query.from(Account.class);
        query = query.select(from);
        query = query.where(cb.equal(from.get(Account_.login), login));
        TypedQuery<Account> tq = em.createQuery(query);
        return tq.getSingleResult();
    }

}
