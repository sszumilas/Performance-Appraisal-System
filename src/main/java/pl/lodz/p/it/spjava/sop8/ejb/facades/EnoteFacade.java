
package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
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
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Interceptors(PerformanceInterceptor.class)
public class EnoteFacade extends AbstractFacade<Enote> {
    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;

    @Override
    
    public void create(Enote entity) throws AppBaseException {
        try {
            super.create(entity);
            em.flush();
        } catch (PersistenceException ex) {
            if (ex.getCause() instanceof DatabaseException && ex.getCause().getCause() instanceof SQLIntegrityConstraintViolationException) {
//                throw AccountException.createWithDbCheckConstraintKey(entity, ex);
            } else {
                throw ex;
            }
        }
    }
    
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnoteFacade() {
        super(Enote.class);
    }
    
    public List<Enote> findEnoteNotConfirmed() {
        TypedQuery<Enote> tq = em.createNamedQuery("Enote.findNotConfirmed", Enote.class);
        return tq.getResultList();
    }
//    
//    public List<Enote> znajdzZamowieniaDlaKlienta(String login) {
//        TypedQuery<Enote> tq = em.createNamedQuery("Enote.znajdzDlaKlienta", Enote.class);
//        tq.setParameter("login", login);
//        return tq.getResultList();
//    }
//    
//    public List<Enote> znajdzZamowieniaNieZatwierdzoneDlaKlienta(String login) {
//        TypedQuery<Enote> tq = em.createNamedQuery("Enote.znajdzNieZatwierdzoneDlaKlienta", Enote.class);
//        tq.setParameter("login", login);
//        return tq.getResultList();
//    }
//    
//    public void odswiezCenyProduktow(Enote enote) {
//        for (PositionEnote poz : enote.getPositionEnote()) {
//            poz.setProdukt(em.find(Produkt.class,poz.getProdukt().getId()));
//            em.refresh(poz.getProdukt()); // Musimy byc pewni ze stan produktow jest aktualny, pobrany w ramach tej samej transakcji. UWAGA teoretycznie moze rzucic EntityNotFound exception (o ile dopuszczamy usuwanie produktow)
//            poz.setCena(poz.getProdukt().getCena());
//        }
//    }

    public void createEnote(Enote enote) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
