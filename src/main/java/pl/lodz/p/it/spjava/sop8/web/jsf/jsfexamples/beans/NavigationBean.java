package pl.lodz.p.it.spjava.sop8.web.jsf.jsfexamples.beans;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Ziarno używane przez stronę navigation.xml dla zaprezentowania metod obsługi akcji.
 * @author java
 */
@ManagedBean
@RequestScoped
public class NavigationBean {
    public static final Logger logger = Logger.getLogger(NavigationBean.class.getName());

    /**
     * Creates a new instance of navigationBean
     */
    public NavigationBean() {
    }
    
    //Właściwość połączona z wyborem typu RadioButton na stronie navigation.
    //Na podstawie tej wartości metoda akcji performNavigation zwraca odpowiedni wynik (outcome) do nawigacji.
    private String selectedValue = "";

    public String getSelectedValue() {
        return selectedValue;
    }

    public void setSelectedValue(String value) {
        this.selectedValue = value;
    }

    public String performNavigation() {
        return selectedValue;
    }
    
    //Właściwość połączona z elementem outputText na stronie navigation.
    //Metoda setCustomValue jest używana jako przykład metody akcji z parametrem na tej stronie
    private String customValue = "";

    public String getCustomValue() {
        return customValue;
    }

    public void setCustomValue(String value) {
        logger.log(Level.INFO, "Ustawienie CustomValue: {0}", value);
        this.customValue = value;
    }
}
