
package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
//import pl.lodz.p.it.spjava.sop8.model.PositionEnote;
//import pl.lodz.p.it.spjava.sop8.model.Produkt;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Interceptors(PerformanceInterceptor.class)
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
    
    public List<Mnote> findMnoteNotConfirmed() {
        TypedQuery<Mnote> tq = em.createNamedQuery("Mnote.findNotConfirmed", Mnote.class);
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
    
}
