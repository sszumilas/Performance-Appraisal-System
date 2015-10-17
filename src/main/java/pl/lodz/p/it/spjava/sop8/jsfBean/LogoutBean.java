/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.jsfBean;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author XXX
 */


@Named(value = "logoutBean")
@RequestScoped


public class LogoutBean {
    
    private static Logger log = Logger.getLogger(LogoutBean.class.getName());
    private String logout;
    
    public String logout() {
//        
        String destination = "/main/index.xhtml";
//        String destination = "main/index?faces-redirect=true";
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = 
                (HttpServletRequest) context.getExternalContext().getRequest();
        
        try {
            request.logout();
        } catch (ServletException e) {
            log.log(Level.SEVERE, "Failed to logout user!", e);
            destination = "/login/loginerror";
//            destination = "/login/loginerror?faces-redirect=true";
            
        }
        return destination;
    }
    
}

