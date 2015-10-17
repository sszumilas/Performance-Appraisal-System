package pl.lodz.p.it.spjava.sop8.web.mnote;

import pl.lodz.p.it.spjava.sop8.web.mnote.*;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Mnote;
import pl.lodz.p.it.spjava.sop8.web.account.AccountSession;

/**
 *
 * @author java
 */
@ManagedBean(name = "mnotesListPageBean")
@RequestScoped
public class MnotesListPageBean {

    public static final String GENERAL_MSG_ID = "mnotesListForm:mnotesList";
//    private DataModel<Mnote> mnoteDataModel;

    public MnotesListPageBean() {
    }

    private String requestAchievements = "";
    
    

//        public String getRequestEmail() {
//        return requestEmail;
//    }
//
//    public void setRequestEmail(String requestEmail) {
//        this.requestEmail = requestEmail;
//    }
//
//    public String getRequestName() {
//        return requestName;
//    }
//
//    public void setRequestName(String requestName) {
//        this.requestName = requestName;
//    }
//
//    public String getRequestSurname() {
//        return requestSurname;
//    }
//
//    public void setRequestSurname(String requestSurname) {
//        this.requestSurname = requestSurname;
//    }
//
    public String getRequestAchievements() {
        return requestAchievements;
    }

    public void setRequestAchievements(String requestAchievements) {
        this.requestAchievements = requestAchievements;
    }

    public void refresh() {
        initModel();
    }

    public void clear() {
        requestAchievements = "";
//        requestName = "";
//        requestSurname = "";
//        requestEmail = "";
    }

    @PostConstruct
    private void initModel() {
        mnotes = mnoteSession.matchMnotes(requestAchievements);
        mnotesDataModel = new ListDataModel<Mnote>(mnotes);
    }
    @ManagedProperty(value = "#{mnoteSession}")
    private MnoteSession mnoteSession;

    public void setMnoteSession(MnoteSession mnoteSession) {
        this.mnoteSession = mnoteSession;
    }
    private List<Mnote> mnotes;
    private DataModel<Mnote> mnotesDataModel;

    public DataModel<Mnote> getMnotesDataModel() {
        return mnotesDataModel;
    }

//    public void activateAccount() {
//        accountSession.activateAccount(accountsDataModel.getRowData());
//        initModel();
//    }
//
//    public void deactivateAccount() {
//        accountSession.deactivateAccount(accountsDataModel.getRowData());
//        initModel();
//    }

    public void confirmMnote() {
        mnoteSession.confirmMnote(mnotesDataModel.getRowData());
        initModel();
    }
//
//    public String editEnote() {
//        return enoteSession.getEnoteToEdit(enotesDataModel.getRowData());
//    }
//
//    public String beginChangePassword() {
//        return accountSession.beginChangePassword(accountsDataModel.getRowData());
//    }
//    public String createEnote() {
//        return accountSession.createEnote(accountsDataModel.getRowData());
//    }
}
    
    
    

//    private boolean onlyNotConfirmed = false;
//    private List<Enote> enotes;
//    private DataModel<Enote> enotesDataModel;
//
//
//    @PostConstruct
//    private void initModel() {
//        if (onlyNotConfirmed) {
//            enotes = enoteSession.getMyEnotesNotConfirmed();
//        } else {
//            enotes = enoteSession.getMyEnotes();
//        }
//        enotesDataModel = new ListDataModel<Enote>(enotes);
//    }
//    @ManagedProperty(value = "#{enoteSession}")
//    private EnoteSession enoteSession;
//
//    public boolean isOnlyNotConfirmed() {
//        return onlyNotConfirmed;
//    }
//
//    public void setOnlyNotConfirmed(boolean onlyNotConfirmed) {
//        this.onlyNotConfirmed = onlyNotConfirmed;
//    }
//
//    public void setEnoteSession(EnoteSession enoteSession) {
//        this.enoteSession = enoteSession;
//    }
//
//    public DataModel<Enote> getEnoteDataModel() {
//        return enoteDataModel;
//    }
//
////    public String usunWybraneZamowienie() {
////        return zamowienieSession.pobierzZamowienieDoUsuniecia(zamowieniaDataModel.getRowData());
////    }
//
//    public void refresh() {
//        initModel();


