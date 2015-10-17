package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.facades.MnoteFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.managers.MnoteManager;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.MnoteException;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

/**
 *
 * @author JavaEE
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MnoteEndpoint extends AbstractEndpoint implements SessionSynchronization{
    @EJB
    private AccountEndpoint accountEndpoint;
    
    @EJB
    private MnoteManager mnoteManager;
    @EJB
    private MnoteFacade mnoteFacade;
    
    private Mnote mnoteState; //przechuwuje encję pobranego zamówenia na potrzeby przechowania jej wersji do czasu zatwierdzenia pobranego zamówienia
    
    public Mnote getMnoteToChange(Long idMnote) {
        mnoteState = mnoteFacade.find(idMnote);
        return mnoteState;
    }
    
    public void confirmMnote(Mnote mnote) throws AppBaseException {
        if (null == mnoteState) {
            throw MnoteException.createWithNoStateInEJBEndpoint(mnote);
        }
        if (!mnoteState.equals(mnote)) {
            throw MnoteException.createWithInvalidStateInEJBEndpoint(mnote);
        }
        // Zamowienie otrzymane z warstwy widoku bylo prezentowane tylko do odczytu, sprawdzona zostala identycznosc obiektow
        // zatem zamowienieStan jest tozsame z tym co potwierdzil pracownik
//        mnoteManager.confirmMnote(mnoteState); //encja  zamowienieStan jest w stanie niezarzadzalnym
    }
    
//    public void removeMnote(Mnote mnote) {
//        if (null == mnoteState) {
//            throw new IllegalArgumentException("Brak wczytanego zamowienia do usuniecia");
//        }
//        if (!mnoteState.equals(mnote)) {
//            throw new IllegalArgumentException("Usuwane zamowienie niezgodne z wczytanym");
//        }
        // Zamowienie otrzymane z warstwy widoku bylo prezentowane tylko do odczytu, sprawdzona zostala identycznosc obiektow
        // zatem zamowienieStan jest tozsame z tym co chce usunac klient
//        if (mnote.isConfirmed()) {
//            throw new IllegalArgumentException("Usuwane zamowienie jest juz zatwierdzone");
//        }
//        mnoteFacade.remove(mnote);//ZamowienieFacade dziedziczy metodę remove() z AbstractFacade, metoda ta sama wywołuje merge() przed usunięciem, więc nie musimy dołączać encji do bieżącego kontekstu trwałości
//    }
    
	@Interceptors(PerformanceInterceptor.class)
    public void createMnote(Mnote mnote) throws AppBaseException {
        mnoteManager.createMnote(mnote);
    }
    
//    public void odswiezCenyProduktow(Enote enote) {
//        enoteFacade.odswiezCenyProduktow(enote);
//    }
    
    public List<Mnote> getAllMnote() {
        return mnoteFacade.findAll();
    }
    
    public List<Mnote> getMnoteNotConfirmed() {
        return mnoteFacade.findMnoteNotConfirmed();
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
