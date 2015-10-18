
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
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
//import pl.lodz.p.it.spjava.sop8.model.PositionEnote;
//import pl.lodz.p.it.spjava.sop8.model.Produkt;
import pl.lodz.p.it.spjava.sop8.model.Enote;

@Stateless
@LocalBean
@Interceptors(PerformanceInterceptor.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EnoteFacade extends AbstractFacade<Enote> {
    
    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;

    
//    public void create(Enote entity) throws AppBaseException {
//        try {
//            super.create(entity);
//            em.flush();
//        } catch (PersistenceException ex) {
//            if (ex.getCause() instanceof DatabaseException && ex.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
////                throw AccountException.createWithDbCheckConstraintKey(entity, ex);
//            } else {
//                throw ex;
//            }
//        }
//    }
    
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnoteFacade() {
        super(Enote.class);
    }
    
    public void createEnote(Enote entity) {
    }
    
}
//    public List<Enote> findEnoteNotConfirmed() {
//        TypedQuery<Enote> tq = em.createNamedQuery("Enote.findNotConfirmed", Enote.class);
//        return tq.getResultList();
//    }
