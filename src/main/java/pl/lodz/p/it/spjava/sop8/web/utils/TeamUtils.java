package pl.lodz.p.it.spjava.sop8.web.utils;

import pl.lodz.p.it.spjava.sop8.model.Admin;
import pl.lodz.p.it.spjava.sop8.model.Employee;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Manager;
import pl.lodz.p.it.spjava.sop8.model.Team;

/**
 *
 */
public class TeamUtils {

    /**
     *
     * @param team
     * @return
     */
//    public static boolean isAdmin(Team team) {
//        return (team instanceof Admin);
//    }
//
//    /**
//     *
//     * @param team
//     * @return
//     */
//    public static boolean isManager(Team team) {
//        return (team instanceof Manager);
//    }
//
//    /**
//     *
//     * @param team
//     * @return
//     */
//    public static boolean isEmployee(Team team) {
//        return (team instanceof Employee);
//    }

    /**
     * Przepisuje do przekazanej encji dane z formularza edycji konta.
     * Uwzględnione są klasy rozszerzające Konto (Administrator, Menadżer,
     * Pracownik), przy czym tylko dane występujące na formularzu sa przepisywane.
     * Pomijane są: login, hasło, id, wersja.
     *
     * @param source encja zawierająca dane z formularza edycji
     * @param target encja docelowa
     */
    public static void rewriteDataAfterEdit(Team source, Team target) {

        if (null == source || null == target) {
            return;
        }

        target.setTeamName(target.getTeamName());
//        target.setSurname(target.getSurname());
//        target.setEmail(target.getEmail());
//        target.setTelephone(target.getTelephone());

//        if (isAdmin(source) && isAdmin(target)) {
//            Admin sourceAdmin = (Admin) source;
//            Admin targetAdmin = (Admin) target;
//            targetAdmin.setAlarmNumber(sourceAdmin.getAlarmNumber());
//        }
//
//        if (isManager(source) && isManager(target)) {
//            Manager sourceManager = (Manager) source;
//            Manager targetManager = (Manager) target;
//            targetManager.setIntercom(sourceManager.getIntercom());
//        }
//
//        if (isEmployee(source) && isEmployee(target)) {
//            Employee sourceEmployee = (Employee) source;
//            Employee targetEmployee = (Employee) target;
//            targetEmployee.setNip(sourceEmployee.getNip());
        }
    }

//    public static String calculateHashPassword(String passwordVisible) {
//        //TODO: wstawić algorytm skrótu hasła
//        return passwordVisible;
//    }

//}
