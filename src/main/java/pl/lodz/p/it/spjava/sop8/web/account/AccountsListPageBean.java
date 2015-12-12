package pl.lodz.p.it.spjava.sop8.web.account;

import java.util.Calendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.web.enote.EnoteSession;
import pl.lodz.p.it.spjava.sop8.web.mnote.MnoteSession;

@ManagedBean(name = "accountsListPageBean")
@RequestScoped
public class AccountsListPageBean {

    public static final String GENERAL_MSG_ID = "accountsListForm:accountsList";

    @ManagedProperty(value = "#{accountSession}")
    private AccountSession accountSession;

    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;

    @ManagedProperty(value = "#{enoteSession}")
    private EnoteSession enoteSession;

    @PostConstruct
    private void initModel() {
        userAccount = accountSession.getMyAccount();
        if ((accountSession.getUserAccount().getType()).equals("Admin")) {
            accounts = accountSession.getAllAccounts();
        } else {
            accounts = accountSession.getAccounts();
        }
    }

    public AccountsListPageBean() {
    }

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }

    public void setEnoteSession(EnoteSession enoteSession) {
        this.enoteSession = enoteSession;
    }

    private Account userAccount;
    private List<Account> accounts;

    public Account getUserAccount() {
        return userAccount;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void activateAccount(Account acc) {
        accountSession.activateAccount(acc);
        initModel();
    }

    public void deactivateAccount(Account acc) {
        accountSession.deactivateAccount(acc);
        initModel();
    }

    public void confirmAccount(Account acc) {
        accountSession.confirmAccount(acc);
        initModel();
    }

    public String editAccount(Account acc) {
        return accountSession.getAccountToEdit(acc);
    }

    public String createMnote(Account account) {
        mnoteSession.setNoteAccount(account);
        return "createMnote";
    }

    public String mnoteList(Account account) {
        mnoteSession.setSearchedNotesAccount(account);
        return "mnoteList";
    }

    public boolean renderCreateMnote(Account account) {
        Long currentYear = (long) Calendar.getInstance().get(Calendar.YEAR);
        return mnoteSession.isNoted(account, currentYear);
    }

    public boolean disabledCreateMnote(Account account) {
        return enoteSession.renderEnote(account);
    }

}
