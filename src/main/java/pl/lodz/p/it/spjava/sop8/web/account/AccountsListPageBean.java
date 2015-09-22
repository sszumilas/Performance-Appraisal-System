package pl.lodz.p.it.spjava.sop8.web.account;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import pl.lodz.p.it.spjava.sop8.model.Account;

/**
 *
 * @author java
 */
@ManagedBean(name = "accountsListPageBean")
@RequestScoped
public class AccountsListPageBean {

    public static final String GENERAL_MSG_ID = "accountsListForm:accountsList";

    public AccountsListPageBean() {
    }
    private String requestLogin = "";
    private String requestName = "";
    private String requestSurname = "";
    private String requestEmail = "";

    public String getRequestEmail() {
        return requestEmail;
    }

    public void setRequestEmail(String requestEmail) {
        this.requestEmail = requestEmail;
    }

    public String getRequestName() {
        return requestName;
    }

    public void setRequestName(String requestName) {
        this.requestName = requestName;
    }

    public String getRequestSurname() {
        return requestSurname;
    }

    public void setRequestSurname(String requestSurname) {
        this.requestSurname = requestSurname;
    }

    public String getRequestLogin() {
        return requestLogin;
    }

    public void setRequestLogin(String requestLogin) {
        this.requestLogin = requestLogin;
    }

    public void refresh() {
        initModel();
    }

    public void clear() {
        requestLogin = "";
        requestName = "";
        requestSurname = "";
        requestEmail = "";
    }

    @PostConstruct
    private void initModel() {
        accounts = accountSession.matchAccounts(requestLogin, requestName, requestSurname, requestEmail);
        accountsDataModel = new ListDataModel<Account>(accounts);
    }
    @ManagedProperty(value = "#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }
    private List<Account> accounts;
    private DataModel<Account> accountsDataModel;

    public DataModel<Account> getAccountsDataModel() {
        return accountsDataModel;
    }

    public void activateAccount() {
        accountSession.activateAccount(accountsDataModel.getRowData());
        initModel();
    }

    public void deactivateAccount() {
        accountSession.deactivateAccount(accountsDataModel.getRowData());
        initModel();
    }

    public void confirmAccount() {
        accountSession.confirmAccount(accountsDataModel.getRowData());
        initModel();
    }

    public String editAccount() {
        return accountSession.getAccountToEdit(accountsDataModel.getRowData());
    }

    public String beginChangePassword() {
        return accountSession.beginChangePassword(accountsDataModel.getRowData());
    }
}
