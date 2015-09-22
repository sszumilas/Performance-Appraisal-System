package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.SOPJavaDB_PU.Account_;

@Stateless
@LocalBean
@Interceptors({LoggingInterceptor.class, PerformanceInterceptor.class})
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
            if (ex.getCause() instanceof DatabaseException && ex.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
                throw AccountException.createWithDbCheckConstraintKey(entity, ex);
            } else {
                throw ex;
            }
        }
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

    public List<Account> matchAccounts(String loginModel, String nameModel, String surnameModel, String emailModel) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Account> query = cb.createQuery(Account.class);
        Root<Account> from = query.from(Account.class);
        query = query.select(from);
        Predicate criteria = cb.conjunction();
        if (null != loginModel && !(loginModel.isEmpty())) {
            criteria = cb.and(criteria, cb.like(from.get(Account_.login), '%' + loginModel + '%'));
        }
        if (null != nameModel && !(nameModel.isEmpty())) {
            criteria = cb.and(criteria, cb.like(from.get(Account_.name), '%' + nameModel + '%'));
        }
        if (null != surnameModel && !(surnameModel.isEmpty())) {
            criteria = cb.and(criteria, cb.like(from.get(Account_.surname), '%' + surnameModel + '%'));
        }
        if (null != emailModel && !(emailModel.isEmpty())) {
            criteria = cb.and(criteria, cb.like(from.get(Account_.email), '%' + emailModel + '%'));
        }

        query = query.where(criteria);
        TypedQuery<Account> tq = em.createQuery(query);
        return tq.getResultList();
    }
}
