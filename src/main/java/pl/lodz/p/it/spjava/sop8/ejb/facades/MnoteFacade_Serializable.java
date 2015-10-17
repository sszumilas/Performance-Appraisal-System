package pl.lodz.p.it.spjava.sop8.ejb.facades;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.MnoteException;
//import pl.lodz.p.it.spjava.sop8.model.PositionEnote;
//import pl.lodz.p.it.spjava.sop8.model.Produkt;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Interceptors(PerformanceInterceptor.class)
public class MnoteFacade_Serializable extends AbstractFacade<Mnote> {

    @PersistenceContext(unitName = "SOPJavaDB_PU_Serializable")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MnoteFacade_Serializable() {
        super(Mnote.class);
    }

//    public void odswiezStanProduktow(Enote enote) {
//        for (PozycjaZamowienia poz : zam.getPozycjeZamowienia()) {
//            poz.setProdukt(em.find(Produkt.class, poz.getProdukt().getId())); //nie używamy merge, aby mieć pewność że nie dojdzie do próby nadpisania produktów stanem z zamówienia
//            em.refresh(poz.getProdukt()); // Musimy byc pewni ze stan produktow jest aktualny, pobrany w ramach tej samej transakcji. UWAGA teoretycznie moze rzucic EntityNotFound exception (o ile dopuszczamy usuwanie produktow)
//        }
//    }

    @Override
    public void edit(Mnote entity) throws AppBaseException {
        try {
            super.edit(entity);
            em.flush();
        } catch (OptimisticLockException oe) {
            throw MnoteException.createWithOptimisticLockKey(entity, oe);
        }
    }
}
