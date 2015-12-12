package pl.lodz.p.it.spjava.sop8.web.enote;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.EnoteEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.*;
import pl.lodz.p.it.spjava.sop8.web.account.AccountSession;
//import sample.jee.shop.web.produkt.ListaProduktowKlientPageBean;


@ManagedBean(name = "enoteSession")
@SessionScoped
public class EnoteSession implements Serializable {

    private static final Logger logger = Logger.getLogger(EnoteSession.class.getSimpleName());

    @EJB
    private EnoteEndpoint enoteEndpoint;

    @ManagedProperty(value = "#{accountSession}")
    private AccountSession accountSession;

    public void setAccountSession(AccountSession accountSession) {
        this.accountSession = accountSession;
    }

    @PostConstruct
    public void init() {
        userAccount = accountSession.getUserAccount();
    }

    private Account userAccount;
    private Enote enoteEdit;
    private Enote enoteView;
    private Enote enoteReport;

    public Enote getEnoteReport() {
        return enoteReport;
    }

    public void setEnoteReport(Enote enoteReport) {
        this.enoteReport = enoteReport;
    }
    
    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }
    
    public Enote getEnoteEdit() {
        return enoteEdit;
    }

    public void setEnoteEdit(Enote enoteEdit) {
        this.enoteEdit = enoteEdit;
    }

    public Enote getEnoteView() {
        return enoteView;
    }

    public void setEnoteView(Enote enoteView) {
        this.enoteView = enoteView;
    }

    public List<Enote> pullEnoteList() {
        return enoteEndpoint.pullEnoteList(userAccount);
    }
    
    public void createEnote(Enote enote) {
        enote.setEmployeeIdFk(userAccount);
        enoteEndpoint.createEnote(enote);
    }

    public void editEnote(Enote enote) throws AppBaseException {
        enoteEndpoint.editEnote(enote);
    }

    public boolean renderEnote() {
        Long year =(long) Calendar.getInstance().get(Calendar.YEAR);
        List<Enote> list = enoteEndpoint.findEnote(userAccount, year);
        return list.isEmpty();
    }
    
    public boolean renderEnote(Account account) {
        Long year =(long) Calendar.getInstance().get(Calendar.YEAR);
        List<Enote> list = enoteEndpoint.findEnote(account, year);
        return list.isEmpty();
    }
    
    
    public void pullEnote(Account acc, Long year){
        Enote enote = enoteEndpoint.findEnote(acc,year).get(0);
        setEnoteReport(enote);
    }
}
