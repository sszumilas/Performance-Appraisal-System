package pl.lodz.p.it.spjava.sop8.web.mnote;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.EnoteEndpoint;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.MnoteEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.*;
import pl.lodz.p.it.spjava.sop8.web.account.AccountSession;

@ManagedBean(name = "mnoteSession")
@SessionScoped
public class MnoteSession implements Serializable {

    private static final Logger logger = Logger.getLogger(MnoteSession.class.getSimpleName());
    @EJB
    private MnoteEndpoint mnoteEndpoint;
    
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
    private Account noteAccount;
    private Account searchedNotesAccount;
    private Mnote mnoteEdit;
    private Mnote mnoteView;
    private Mnote mnoteReport;

    public Mnote getMnoteReport() {
        return mnoteReport;
    }

    public void setMnoteReport(Mnote mnoteReport) {
        this.mnoteReport = mnoteReport;
    }
    
    public Account getSearchedNotesAccount() {
        return searchedNotesAccount;
    }

    public void setSearchedNotesAccount(Account searchedNotesAccount) {
        this.searchedNotesAccount = searchedNotesAccount;
    }

    public Account getNoteAccount() {
        return noteAccount;
    }

    public void setNoteAccount(Account noteAccount) {
        this.noteAccount = noteAccount;
    }
    
    public Account getUserAccount() {
        return userAccount;
    }

    public Mnote getMnoteEdit() {
        return mnoteEdit;
    }

    public void setMnoteEdit(Mnote mnoteEdit) {
        this.mnoteEdit = mnoteEdit;
    }

    public Mnote getMnoteView() {
        return mnoteView;
    }

    public void setMnoteView(Mnote mnoteView) {
        this.mnoteView = mnoteView;
    }

    public List<Mnote> pullMnoteList() {
        return mnoteEndpoint.pullMnoteList(searchedNotesAccount);
    }
    
    public List<Enote> pullEnoteList() {
        return enoteEndpoint.pullEnoteList(searchedNotesAccount);
    }

    public void createMnote(Mnote mnote) {
        try {
            Long year =(long) Calendar.getInstance().get(Calendar.YEAR);
            Enote enote = enoteEndpoint.findEnote(mnote.getEmployeeIdFk(), year).get(0);
            enote.setConfirmed(true);
            enoteEndpoint.editEnote(enote);
            mnoteEndpoint.createMnote(mnote);
        } catch (AppBaseException ex) {
            Logger.getLogger(MnoteSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editMnote(Mnote mnote) throws AppBaseException {
        mnoteEndpoint.editMnote(mnote);
    }
    
    public boolean isNoted(Account account, Long year){
       return mnoteEndpoint.isNoted(account, year);
    }
    
    public Enote findEnote(Account account, Long year){
        return enoteEndpoint.findEnote(account, year).get(0);
    }
    
}