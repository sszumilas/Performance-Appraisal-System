package pl.lodz.p.it.spjava.sop8.web.mnote;

import pl.lodz.p.it.spjava.sop8.web.mnote.*;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.MnoteEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.MnoteException;
import pl.lodz.p.it.spjava.sop8.model.*;
//import sample.jee.shop.web.produkt.ListaProduktowKlientPageBean;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "mnoteSession")
@SessionScoped
public class MnoteSession implements Serializable {

    private static final Logger loger = Logger.getLogger(MnoteSession.class.getSimpleName());
    @EJB
    private MnoteEndpoint mnoteEndpoint;
//    private Mnote zamowienieZmiana;
    private Mnote mnoteCreate;
    private Mnote mnoteChange;

    public void resetCreateMnote() {
        mnoteCreate = new Mnote();
    }

//    public void dodajPozycjeDoZamowienia(Produkt p) {
        // Zapewnienie unikatowości produktów na liście zamówienia
        // Gwarantuje to równiez baza danych, ale chcemy uniknąć tego problemu jak najwcześniej

//        for (PozycjaZamowienia poz : zamowienieSkladanie.getPozycjeZamowienia()) {
//            if (poz.getProdukt().equals(p)) {
//                poz.setIlosc(poz.getIlosc() + 1);
//                ContextUtils.emitInternationalizedMessage(ListaProduktowKlientPageBean.GENERAL_MSG_ID, "product.increased.in.order");
//                return;
//            }
//        }
//        PozycjaZamowienia poz = new PozycjaZamowienia();
//        poz.setProdukt(p);
//        poz.setIlosc(1);
//        poz.setCena(p.getCena());
//        // Pamietaj o obustronnym składaniu relacji!
//        poz.setZamowienie(zamowienieSkladanie);
//        zamowienieSkladanie.getPozycjeZamowienia().add(poz);
//        ContextUtils.emitInternationalizedMessage(ListaProduktowKlientPageBean.GENERAL_MSG_ID, ("product.added.to.order"));
//    }
//
//    public boolean isZamowienieSkladanieNiepuste() {
//        return (zamowienieSkladanie.getLiczbaPozycji() > 0);
//
//    }
//
//    public void odswiezCenyProduktow() {
//        zamowienieEndpoint.odswiezCenyProduktow(zamowienieSkladanie);
//    }

    public Mnote getMnoteCreate() {
        return mnoteCreate;
    }

//    public void setZamowienieSkladanie(Zamowienie zamowienieSkladanie) {
//        this.zamowienieSkladanie = zamowienieSkladanie;
//    }
//    public Zamowienie getZamowienieZmiana() {
//        return zamowienieZmiana;
//    }

//    public void setZamowienieZatwierdzanie(Zamowienie zamowienieZatwierdzanie) {
//        this.zamowienieZatwierdzanie = zamowienieZatwierdzanie;
//    }
//    public EnoteSession() {
//        resetCreateEnote();
//    }

    public String getMnoteToConfirm(Mnote mnote) {
        this.mnoteChange = mnoteEndpoint.getMnoteToChange(mnote.getId());
        return "confirmMnote";
    }

//    public String pobierzZamowienieDoUsuniecia(Zamowienie zam) {
//        this.zamowienieZmiana = zamowienieEndpoint.pobierzZamowienieDoZmian(zam.getId());
//        return "deleteOrder";
//    }

    public String confirmUploadMnote() {
        try {
            mnoteEndpoint.confirmMnote(mnoteChange);
            return "success";
        } catch (AppBaseException abe) {
            Logger.getLogger(MnoteSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji zatwierdzPobraneZamowienie wyjatku typu: ", abe.getClass());
            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
            }
            return null;
        }
    }

    public String createMnote() {
        try {
            mnoteEndpoint.createMnote(mnoteCreate);
            resetCreateMnote();
            return "success";
        } catch (AppBaseException ex) {
            Logger.getLogger(MnoteSession.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public String usunPobraneZamowienie(Enote enote) {
//        zamowienieEndpoint.usunZamowienie(zamowienieZmiana);
//        return "success";
//    }

//    public List<Enote> getAllEnotes() {
//        return enoteEndpoint.getAllEnotes();
//    }
//
//    public List<Enote> getEnotesNotConfirmed() {
//        return enoteEndpoint.getEnotesNotConfirmed();
//    }
//
//    public List<Enote> getMyEnotes() {
//        return enoteEndpoint.getMyEnotes();
//    }
//
//    public List<Enote> getMyEnotesNotConfirmed() {
//        return enoteEndpoint.getMyEnoteNotConfirmed();
//    }

    Mnote getMnoteChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void confirmMnote(Mnote rowData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Mnote> matchMnotes(String requestAchievements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
