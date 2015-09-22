package pl.lodz.p.it.spjava.sop8.web.jsf.jsfexamples.beans;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import pl.lodz.p.it.spjava.sop8.web.utils.ContextUtils;

/**
 * Ziarno używane w przykładach dot. ziaren i atrybutów w poszczególnych zasięgach.
 * @author java
 */
@ManagedBean
@RequestScoped
public class BeansBean {

    /**
     * Creates a new instance of BeansBean
     */
    public BeansBean() {
    }
    
    /**
     * Zamyka sesję HTTP (odwołanie do klasy narzędziowej ContextUtils).
     */
    public void closeSession() {
        ContextUtils.invalidateSession();
    }

    /**
     * Zwraca identyfikator sesji HTTP (odwołanie do klasy narzędziowej ContextUtils).
     */
    public String getSessionID() {
        return ContextUtils.getSessionID();
    }

    /** 
     * Zwraca opisy liczników (wynik wywołania metody toString()) we wszystkich zasięgach. 
     */
    public String getCountersDescription() {
        StringBuilder sb = new StringBuilder(new Date().toString()).append("\n");
        sb.append("Licznik w zasięgu żądania: ").append(ContextUtils.getRequestAttribute("counterBeanRequestScope")).append("\n");
        sb.append("Licznik w zasięgu sesji: ").append(ContextUtils.getSessionAttribute("counterBeanSessionScope")).append("\n");
        sb.append("Licznik w zasięgu aplikacji: ").append(ContextUtils.getApplicationAttribute("counterBeanApplicationScope")).append("\n");
        return sb.toString();
    }

    /** 
     * Zwraca wartość parametru application.description zgodnie z wartością parametru skonfigurowanego w deskryptorze web.xml. 
     */
    public String getApplicationDescriptionParam() {
        return ContextUtils.getContextParameter("application.description");
    }
}
