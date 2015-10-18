package pl.lodz.p.it.spjava.sop8.web.enote;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.EnoteEndpoint;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.exception.EnoteException;
import pl.lodz.p.it.spjava.sop8.model.*;
//import sample.jee.shop.web.produkt.ListaProduktowKlientPageBean;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "enoteSession")
@SessionScoped
public class EnoteSession implements Serializable {

    private static final Logger loger = Logger.getLogger(EnoteSession.class.getSimpleName());
    @EJB
    private EnoteEndpoint enoteEndpoint;
//    private Enote zamowienieZmiana;
    private Enote enoteCreate;
    private Enote enoteChange;

    public void resetCreateEnote() {
        enoteCreate = new Enote();
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

    public Enote getEnoteCreate() {
        return enoteCreate;
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

//    public String getEnoteToConfirm(Enote enote) {
//        this.enoteChange = enoteEndpoint.getEnoteToChange(enote.getId());
//        return "confirmEnote";
//    }
//
////    public String pobierzZamowienieDoUsuniecia(Zamowienie zam) {
////        this.zamowienieZmiana = zamowienieEndpoint.pobierzZamowienieDoZmian(zam.getId());
////        return "deleteOrder";
////    }
//
//    public String confirmUploadEnote() {
//        try {
//            enoteEndpoint.confirmEnote(enoteChange);
//            return "success";
//        } catch (AppBaseException abe) {
//            Logger.getLogger(EnoteSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji zatwierdzPobraneZamowienie wyjatku typu: ", abe.getClass());
//            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
//                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            }
//            return null;
//        }
//    }

    public String createEnote() {
        try {
            enoteEndpoint.createEnote(enoteCreate);
            resetCreateEnote();
            return "success";
        } catch (AppBaseException ex) {
            Logger.getLogger(EnoteSession.class.getName()).log(Level.SEVERE, null, ex);
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

    Enote getEnoteChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void confirmEnote(Enote rowData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    List<Enote> matchEnotes(String requestAchievements) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
