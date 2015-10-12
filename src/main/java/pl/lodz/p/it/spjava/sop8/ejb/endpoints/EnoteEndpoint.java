package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.facades.EnoteFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.managers.EnoteManager;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.EnoteException;
import pl.lodz.p.it.spjava.sop8.model.Enote;

/**
 *
 * @author JavaEE
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EnoteEndpoint extends AbstractEndpoint implements SessionSynchronization{
    @EJB
    private AccountEndpoint accountEndpoint;
    
    @EJB
    private EnoteManager enoteManager;
    @EJB
    private EnoteFacade enoteFacade;
    
    private Enote enoteState; //przechuwuje encję pobranego zamówenia na potrzeby przechowania jej wersji do czasu zatwierdzenia pobranego zamówienia
    
    public Enote getEnoteToChange(Long idEnote) {
        enoteState = enoteFacade.find(idEnote);
        return enoteState;
    }
    
    public void confirmEnote(Enote enote) throws AppBaseException {
        if (null == enoteState) {
            throw EnoteException.createWithNoStateInEJBEndpoint(enote);
        }
        if (!enoteState.equals(enote)) {
            throw EnoteException.createWithInvalidStateInEJBEndpoint(enote);
        }
        // Zamowienie otrzymane z warstwy widoku bylo prezentowane tylko do odczytu, sprawdzona zostala identycznosc obiektow
        // zatem zamowienieStan jest tozsame z tym co potwierdzil pracownik
        enoteManager.confirmEnote(enoteState); //encja  zamowienieStan jest w stanie niezarzadzalnym
    }
    
    public void removeEnote(Enote enote) {
        if (null == enoteState) {
            throw new IllegalArgumentException("Brak wczytanego zamowienia do usuniecia");
        }
        if (!enoteState.equals(enote)) {
            throw new IllegalArgumentException("Usuwane zamowienie niezgodne z wczytanym");
        }
        // Zamowienie otrzymane z warstwy widoku bylo prezentowane tylko do odczytu, sprawdzona zostala identycznosc obiektow
        // zatem zamowienieStan jest tozsame z tym co chce usunac klient
        if (enote.isConfirmed()) {
            throw new IllegalArgumentException("Usuwane zamowienie jest juz zatwierdzone");
        }
        enoteFacade.remove(enote);//ZamowienieFacade dziedziczy metodę remove() z AbstractFacade, metoda ta sama wywołuje merge() przed usunięciem, więc nie musimy dołączać encji do bieżącego kontekstu trwałości
    }
    
	@Interceptors(PerformanceInterceptor.class)
    public void createEnote(Enote enote) throws AppBaseException {
        enoteManager.createEnote(enote);
    }
    
//    public void odswiezCenyProduktow(Enote enote) {
//        enoteFacade.odswiezCenyProduktow(enote);
//    }
    
    public List<Enote> getAllEnote() {
        return enoteFacade.findAll();
    }
    
    public List<Enote> getEnoteNotConfirmed() {
        return enoteFacade.findEnoteNotConfirmed();
    }
    
//    public List<Enote> getMyEnote() {
//        return enoteFacade.findEnotes(accountEndpoint.getMyAccount().getLogin());
//    }
//
//    public List<Enote> pobierzMojeZamowieniaNieZatwierdzone() {
//        return enoteFacade.znajdzZamowieniaNieZatwierdzoneDlaKlienta(accountEndpoint.getMyAccount().getLogin());
//    }

//
//    public List<Enote> getMyEnotes() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public List<Enote> getMyEnoteNotConfirmed() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
}
