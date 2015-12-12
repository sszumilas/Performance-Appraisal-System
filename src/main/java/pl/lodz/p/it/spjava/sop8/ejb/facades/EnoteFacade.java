
package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Enote;

@Stateless
@RolesAllowed({"Employee", "Manager","Admin"})
@Interceptors({LoggingInterceptor.class})
@LocalBean
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EnoteFacade extends AbstractFacade<Enote> {
    
    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnoteFacade() {
        super(Enote.class);
    }
    
    public List<Enote> pullEnoteList(Account account){
        TypedQuery<Enote> tq = em.createNamedQuery("Enote.findByUser", Enote.class);
        tq.setParameter("x", account.getId());
        return tq.getResultList();
    }
    
    public void createEnote(Enote entity) {
        getEntityManager().persist(entity);
    }
    
    public List<Enote> findEnote(Account account, Long year){
        TypedQuery<Enote> tq = em.createNamedQuery("Enote.findByYear", Enote.class);
        tq.setParameter("x", account.getId());
        tq.setParameter("y", year);
        return tq.getResultList();
        
    }
    
}
