 package pl.lodz.p.it.spjava.sop8.ejb.managers;

import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountEndpoint;
import pl.lodz.p.it.spjava.sop8.ejb.facades.EnoteFacade;
import pl.lodz.p.it.spjava.sop8.ejb.facades.EnoteFacade_Serializable;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.EnoteException;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Account;
//import pl.lodz.p.it.spjava.sop8.model.PozycjaZamowienia;
import pl.lodz.p.it.spjava.sop8.model.Manager;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;

/**
 *
 * @author java
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EnoteManager {

    @EJB
    private AccountEndpoint accountEndpoint;
    @EJB
    private EnoteFacade enoteFacade;
    @EJB
    private EnoteFacade_Serializable enoteFacade_Serializable;

    public void createEnote(Enote enote) throws AppBaseException {
        Account myAccount = accountEndpoint.getMyAccount();
        if (!(AccountUtils.isEmployee(myAccount))) {
            throw new IllegalArgumentException("Tylko klient może składać nowe zamowienia");
        }
        Employee myAccountEmployee = (Employee) myAccount;
        enote.setWhoCreate(myAccountEmployee);
//        myAccountEmployee.getEnotes().add(enote);
        enoteFacade.create(enote);//dzięki kaskadzie PERSIST powinny być utworzone także pozycje zamówienia
    }

    public void confirmEnote(Enote enote) throws AppBaseException { // Ta metoda posluguje sie fasada, ktora uzywa jednostki skladowania opartej na puli polaczen z poziomem izolacji transakcji 'serializable'
        if (enote.isConfirmed()) {
            throw EnoteException.createWithAproveOfAproved(enote);
        }
//        enoteFacade_Serializable.odswiezStanProduktow(enote);
//        for (PositionEnote pos : enote.getPositionEnote()) {
//            if (pos.getIlosc() <= pos.getProdukt().getStan()) {
//                pos.getProdukt().setStan(pos.getProdukt().getStan() - pos.getIlosc());
//            } else {
//                throw EnoteException.createWithInsufficientProductAmount(enote);
//            }
//        }
        Account myAccount = accountEndpoint.getMyAccount();
        if (!(AccountUtils.isManager(myAccount))) {
            throw new IllegalArgumentException("Tylko manager może zatwierdzać nowe oceny");
        }
        Manager myAccountManager = (Manager) myAccount;
        //Relacja miedzy zamowieniem a zatwierdzajacym je pracownikiem jest jednokierunkowa
        enote.setWhoConfirmed(myAccountManager);
        enote.setConfirmed(true); 
        enoteFacade_Serializable.edit(enote); //utworzenie kopii encji ze stanem zarzadzalnym, dlatego metoda edit jest ostatnia w bloku
    }
}
