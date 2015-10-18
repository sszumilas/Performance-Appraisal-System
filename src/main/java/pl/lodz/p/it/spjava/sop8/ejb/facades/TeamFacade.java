/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.it.spjava.sop8.ejb.facades;

import java.sql.SQLIntegrityConstraintViolationException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import org.eclipse.persistence.exceptions.DatabaseException;
import pl.lodz.p.it.spjava.sop8.ejb.endpoints.AbstractFacade;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.LoggingInterceptor;
import pl.lodz.p.it.spjava.sop8.ejb.interceptor.PerformanceInterceptor;
import pl.lodz.p.it.spjava.sop8.exception.AccountException;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Team;

/**
 *
 * @author XXX
 */
@Stateless
@LocalBean
@Interceptors({LoggingInterceptor.class, PerformanceInterceptor.class})
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class TeamFacade extends AbstractFacade<Team> {

    @PersistenceContext(unitName = "SOPJavaDB_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeamFacade() {
        super(Team.class);
    }

    @Override
    public void createTeam(Team entity){
        }
    }

