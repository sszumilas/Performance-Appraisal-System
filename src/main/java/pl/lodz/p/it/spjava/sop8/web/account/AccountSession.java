package pl.lodz.p.it.spjava.sop8.web.account;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.model.Admin;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Manager;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "accountSession")
@SessionScoped
public class AccountSession implements Serializable {

    @EJB
    private AccountEndpoint accountEndpoint;

    public String resetSession() {
        ContextUtils.invalidateSession();
        /* Poprawne zakończenie sesji wymaga wymuszenia nowego żądania na przeglądarce, stąd metoda ta
         * prowadzi do przypadku nawigacji z elementem <redirect />.
         * UWAGA: integracja logowania typu BASIC z przeglądarką powoduje, że czasem mimo to "wylogowanie" jest nieskuteczne - 
         * powstaje nowa sesja już zalogowanego użytkownika. Dlatego bezpieczniej jest stosować uwierzytelnianie przez formularz (FORM).
         */
        return "cancelAction";
    }

    public String getMyLogin() {
        return ContextUtils.getUserName();
    }
    private Employee employeeRegistration;
    private Employee employeeCreate;
    private Manager managerCreate;
    private Admin adminCreate;
    private Account accountEdit;
    private Account accountChangePassword;

    public Account getAccountChangePassword() {
        return accountChangePassword;
    }

    public Account getAccountEdit() {
        return accountEdit;
    }

    public Employee getEmployeeRegistration() {
        return employeeRegistration;
    }

    public AccountSession() {
    }

    public String createEmployee(Employee employee) {
        try {
            employeeCreate = employee;
            accountEndpoint.createAccount(employeeCreate);
            employeeCreate = null;
            return "success";
        } catch (AccountException ae) {
            if (AccountException.KEY_DB_CONSTRAINT.equals(ae.getMessage())) {
                ContextUtils.emitInternationalizedMessage("login", AccountException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            } else {
                Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzKlienta wyjatku: ", ae);               
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzKlienta wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }

    public String createManager(Manager manager) {
        try {
            managerCreate = manager;
            accountEndpoint.createAccount(managerCreate);
            managerCreate = null;
            return "success";
        } catch (AccountException ae) {
            if (AccountException.KEY_DB_CONSTRAINT.equals(ae.getMessage())) {
                ContextUtils.emitInternationalizedMessage("login", AccountException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            } else {
                Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku: ", ae);               
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }

    public String createAdmin(Admin admin) {
        try {
            adminCreate = admin;
            accountEndpoint.createAccount(adminCreate);
            adminCreate = null;
            return "success";
        } catch (AccountException ae) {
            if (AccountException.KEY_DB_CONSTRAINT.equals(ae.getMessage())) {
                ContextUtils.emitInternationalizedMessage("login", AccountException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            } else {
                Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzAdministratora wyjatku: ", ae);               
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzAdministratora wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }

    public String confirmRegistrationEmployee(Employee employee) {
        this.employeeRegistration = employee;
        return "confirmRegister";
    }

    public String beginChangePassword(Account account) {
        this.accountChangePassword = account;
        return "changePassword";
    }

    public String registerEmployee() {
        try {
            accountEndpoint.registerEmployee(employeeRegistration);
            employeeRegistration = null;
            return "success";
        } catch (AccountException ae) {
            if (AccountException.KEY_DB_CONSTRAINT.equals(ae.getMessage())) {
                ContextUtils.emitInternationalizedMessage("login", AccountException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            } else {
                Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji rejestrujKlienta wyjatku: ", ae);               
            }
            return null;
        } catch (AppBaseException abe) {
            Logger.getLogger(AccountSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji rejestrujKlienta wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }

    public void activateAccount(Account Account) {
        accountEndpoint.activateAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public void deactivateAccount(Account Account) {
        accountEndpoint.deactivateAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public void confirmAccount(Account Account) {
        accountEndpoint.confirmAccount(Account);
        ContextUtils.emitSuccessMessage(AccountsListPageBean.GENERAL_MSG_ID);
    }

    public String getAccountToEdit(Account Account) {
        accountEdit = accountEndpoint.getAccountToEdit(Account);
        return "editAccount";
    }

    public String saveAccountAfterEdit(Account Account) throws AppBaseException {
        accountEndpoint.saveAccountAfterEdit(Account);
        return "success";
    }

//    public String changePasswordAccount(String password) {
//        accountEndpoint.changePassword(accountChangePassword, password);
//        return "success";
//    }

//    public String changeMyPassword(String old, String new) {
//        accountEndpoint.changeMyPassword(old, new);
//        return "success";
//    }

    public List<Account> getAllAccounts() {
        return accountEndpoint.getAllAccounts();
    }

    public List<Account> matchAccounts(String loginSample, String nameSample, String surnameSample, String emailSample) {
        return accountEndpoint.matchAccounts(loginSample, nameSample, surnameSample, emailSample);
    }

    public Account getMyAccount() {
        return accountEndpoint.getMyAccount();
    }
}
