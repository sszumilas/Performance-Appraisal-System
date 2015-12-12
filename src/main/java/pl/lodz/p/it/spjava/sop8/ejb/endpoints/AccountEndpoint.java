package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import pl.lodz.p.it.spjava.sop8.ejb.facades.AccountFacade;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;

/**
 *
 * @author Szymek
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class AccountEndpoint extends AbstractEndpoint implements SessionSynchronization {

    @EJB
    private AccountFacade accountFacade;

    @Resource
    private SessionContext sctx;

    private Account accountState;

    @PermitAll
    public Account getMyAccount() {
        return findLogin(sctx.getCallerPrincipal().getName());
    }

    public void createAccount(Account account) throws AppBaseException {
        account.setActive(false);
        account.setConfirmed(false);
        accountFacade.create(account);
    }

    @RolesAllowed("Admin")
    public void activateAccount(Account account) {
        Account a = accountFacade.find(account.getId());
        a.setActive(true);
    }

    public void deactivateAccount(Account account) {
        Account a = accountFacade.find(account.getId());
        a.setActive(false);
    }

    public void confirmAccount(Account account) {
        Account a = accountFacade.find(account.getId());
        a.setConfirmed(true);
    }

    public void edit(Account account) throws AppBaseException {
        accountFacade.edit(account);
    }

    public List<Account> getAllAccounts() {
        return accountFacade.findAll();
    }

    public List<Account> getAllOfType(String type) {
        return accountFacade.getAllOfType(type);
    }

    public Account findLogin(String login) {
        return accountFacade.findLogin(login);
    }

    public Account getAccountToEdit(Account account) {
        accountState = findLogin(account.getLogin());
        return accountState;
    }

    public List<Account> getAccounts(Account account) {
        return accountFacade.findAccounts(account);
    }

}
