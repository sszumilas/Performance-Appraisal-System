
package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Mnote;
import pl.lodz.p.it.spjava.sop8.model.Team;

@Stateless
@RolesAllowed({"Manager","Admin"})
@Interceptors({LoggingInterceptor.class})
@LocalBean
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MnoteFacade extends AbstractFacade<Mnote> {
    
    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MnoteFacade() {
        super(Mnote.class);
    }
    
    public List<Mnote> pullMnoteList(Account account){
        TypedQuery<Mnote> tq = em.createNamedQuery("Mnote.findByUser", Mnote.class);
        tq.setParameter("x", account.getId());
        return tq.getResultList();
    }
    
    public void createMnote(Mnote entity) {
        getEntityManager().persist(entity);
    }
    
    public boolean isNoted(Account account,Long year){
        try{
        TypedQuery<Mnote> tq = em.createNamedQuery("Mnote.isNoted", Mnote.class);
        tq.setParameter("x", account.getId());
        tq.setParameter("y", year);
        Mnote mnote = tq.getSingleResult();
        return false;
        }catch(NoResultException nre){
            return true;
        }
    }
    
    
}
