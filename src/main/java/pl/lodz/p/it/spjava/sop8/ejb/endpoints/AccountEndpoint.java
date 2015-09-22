
package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import javax.interceptor.Interceptors;
import pl.lodz.p.it.spjava.sop8.ejb.facades.AdminFacade;
import pl.lodz.p.it.spjava.sop8.ejb.facades.EmployeeFacade;
import pl.lodz.p.it.spjava.sop8.ejb.facades.AccountFacade;
import pl.lodz.p.it.spjava.sop8.ejb.facades.ManagerFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.managers.AccountsManager;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.web.utils.AccountUtils;

/**
 *
 * @author java
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountEndpoint extends AbstractEndpoint implements SessionSynchronization {
    @EJB
    private AccountsManager accountsManager;
    
    @EJB
    private AccountFacade accountFacade;
    
    @EJB
    private EmployeeFacade employeeFacade;
    
    @EJB
    private ManagerFacade managerFacade;
    
    @EJB
    private AdminFacade adminFacade;
    
    @Resource
    private SessionContext sctx;
    
    private Account accountState;

    public Account getMyAccount() {
        return findLogin(sctx.getCallerPrincipal().getName());
    }

    public void createAccount(Account account) throws AppBaseException {
        account.setActive(true);
        account.setConfirmed(true);
        // Konto ma hasło jawne podane w formularzu, należy je przeliczyć na skrót
        account.setPassword(AccountUtils.wyliczSkrotHasla(account.getPassword()));
        accountFacade.create(account);
    }

    public void registerEmployee(Employee employee) throws AppBaseException {
        employee.setActive(true);
        employee.setConfirmed(false);
        employee.setPassword(AccountUtils.wyliczSkrotHasla(employee.getPassword()));
        employeeFacade.create(employee);
    }
    
    public void activateAccount(Account account){
        Account a = accountFacade.find(account.getId());
        a.setActive(true);
    }
    
    public void deactivateAccount(Account account){
        Account a = accountFacade.find(account.getId());
        a.setActive(false);
    }
    
    public void confirmAccount(Account account){
        Account a = accountFacade.find(account.getId());
        a.setConfirmed(true);
    }
    
    public List<Account> getAllAccounts() {
        return accountFacade.findAll();
    }
    
    public List<Account> matchAccounts(String loginSample, String nameSample, String surnameSample, String emailSample) {
        return accountFacade.matchAccounts(loginSample, nameSample, surnameSample, emailSample);
    }
    
    public Account findLogin(String login) {
        return accountFacade.findLogin(login);
    }
    
    public Account getAccountToEdit(Account account) {
        accountState = findLogin(account.getLogin());
        return accountState;
    }
    
    public void saveAccountAfterEdit(Account account) throws AppBaseException {
        if (null == accountState) {
            throw new IllegalArgumentException("Brak wczytanego konta do modyfikacji");
        }
        if (!accountState.equals(account)) {
            throw new IllegalArgumentException("Modyfikowane konto niezgodne z wczytanym");
        }
        // Przepisz te dane konta, które podlegają edycji (sa dostepne na formularzu)
        AccountUtils.rewriteDataAfterEdit(account, accountState);
        //wykonej merge() na encji Konto, aby weszła ona w stan zarządzany przez obecny kontekst trwalości
        accountFacade.edit(accountState);
        //usuń stan konta po zakończonej operacji - unika błędnego wielokrotnego wykonania
        accountState=null;
    }
    
//    public void changeMyPassword(String old, String new) {
//        Account myAccount = getMyAccount();
//        if(!myAccount.getPassword().equals(AccountUtils.wyliczSkrotHasla(old)))
//            throw new IllegalArgumentException("Podane dotychczasowe hasło nie zgadza się");
//        myAccount.setPassword(AccountUtils.wyliczSkrotHasla(new));
//    }
//    
//    public void changePassword(Account account, String password) {
//        Account a = accountFacade.find(account.getId());
//        a.setPassword(AccountUtils.wyliczSkrotHasla(password));
//    }
}
