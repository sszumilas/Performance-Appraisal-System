
package pl.lodz.p.it.spjava.sop8.web.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
/**
 * Ta klasa używana jest do zmiany haseł zapisanych w bazie danych na hasla kodowane.
 * Jest to droga w jedną stronę, tak więc raz zakodowane hasla nie mogę zostać ponownie odkodowane.
 * Użyj tej klasy do zakodowania haseł przy użyciu SHA-256, który jest skomplikowanym i trudnym do złamania systemem kodującym.
 * @author XXX
 */
public class HashedPasswordGenerator {


    public static void calculateHashPassword(String passwordVisible) {
        //To jest właśnie jednostronny generator haseł. Użyte zostały metody Google Guava project. Niestety lokalnie dostępna zależność
        //guava-14.0.1 generuje problem z tworzeniem aplikacji - konieczne jest zainstalowanie wersji nowszej niż 15.0.
        //ja ściągnąłem wersję stabilną guava-18.0.
        
        
        String output = 
                Hashing.sha256()
                        .hashString(passwordVisible, Charsets.UTF_8).toString();
        System.out.println(output);
    }
    
    
    public static void main(String[] args) {
        // można wygenerować dowolną liczbę haseł
    calculateHashPassword("hasmanager");
    calculateHashPassword("hasadmin");
    calculateHashPassword("hasemployee");
    
    
    }
    
}
