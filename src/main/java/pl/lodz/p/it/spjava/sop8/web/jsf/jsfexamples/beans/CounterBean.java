package pl.lodz.p.it.spjava.sop8.web.jsf.jsfexamples.beans;


/**
 * Ta klasa jest zarejestrowana jako ziarno zarzadzane przez JSF, pod trzema zasięgami (scope) i trzema nazwami.
 * @see faces-config.xml
 * Klasa implementuje prosty licznik wywołań, który powinien dawać różne wartości w zależności od zasięgu (scope) ziarna.
 * @author java
 */

public class CounterBean {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public CounterBean() {
    }
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void incrementCount(int factor) {
        this.count += 1;
    }

    public void incrementCount() {
        this.incrementCount(1);
    }
    
    @Override
    public String toString(){
        return (this.getClass().getName() + ": Stan licznika: " + count);
    }

}
