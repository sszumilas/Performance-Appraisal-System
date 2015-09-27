<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Account Detail</title>
            <link rel="stylesheet" type="text/css" href="SOP8/Bundle/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Account Detail</h1>
            <h:form>
                <h:panelGrid columns="2">
                    <h:outputText value="BusinessKey:"/>
                    <h:outputText value="#{account.account.businessKey}" title="BusinessKey" />
                    <h:outputText value="Email:"/>
                    <h:outputText value="#{account.account.email}" title="Email" />
                    <h:outputText value="Name:"/>
                    <h:outputText value="#{account.account.name}" title="Name" />
                    <h:outputText value="Surname:"/>
                    <h:outputText value="#{account.account.surname}" title="Surname" />
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{account.account.id}" title="Id" />
                    <h:outputText value="Login:"/>
                    <h:outputText value="#{account.account.login}" title="Login" />
                    <h:outputText value="Password:"/>
                    <h:outputText value="#{account.account.password}" title="Password" />
                    <h:outputText value="Telephone:"/>
                    <h:outputText value="#{account.account.telephone}" title="Telephone" />
                    <h:outputText value="Type:"/>
                    <h:outputText value="#{account.account.type}" title="Type" />
                    <h:outputText value="Personaldata:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.personaldata}"/>
                        <h:panelGroup rendered="#{account.account.personaldata != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{personaldata.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPersonaldata" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.personaldata][personaldata.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{personaldata.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPersonaldata" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.personaldata][personaldata.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{personaldata.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentPersonaldata" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.personaldata][personaldata.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Admindata:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.admindata}"/>
                        <h:panelGroup rendered="#{account.account.admindata != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{admin.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAdmin" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.admindata][admin.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{admin.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAdmin" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.admindata][admin.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{admin.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentAdmin" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.admindata][admin.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Managerdata:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.managerdata}"/>
                        <h:panelGroup rendered="#{account.account.managerdata != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{manager.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentManager" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.managerdata][manager.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{manager.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentManager" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.managerdata][manager.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{manager.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentManager" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.managerdata][manager.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Employeedata:"/>
                    <h:panelGroup>
                        <h:outputText value="#{account.account.employeedata}"/>
                        <h:panelGroup rendered="#{account.account.employeedata != null}">
                            <h:outputText value=" ("/>
                            <h:commandLink value="Show" action="#{employee.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployee" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.employeedata][employee.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{employee.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployee" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.employeedata][employee.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{employee.destroy}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.currentEmployee" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account.employeedata][employee.converter].jsfcrud_invoke}"/>
                                <f:param name="jsfcrud.relatedController" value="account"/>
                                <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController"/>
                            </h:commandLink>
                            <h:outputText value=" )"/>
                        </h:panelGroup>
                    </h:panelGroup>
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{account.account.id}" title="Id" />
                    <h:outputText value="BusinessKey:"/>
                    <h:outputText value="#{account.account.businessKey}" title="BusinessKey" />

                    <h:outputText value="EnoteList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.enoteList}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.enoteList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.enoteList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Id"/>
                                </f:facet>
                                <h:outputText value="#{item.id}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Achievements"/>
                                </f:facet>
                                <h:outputText value="#{item.achievements}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Aspiration"/>
                                </f:facet>
                                <h:outputText value="#{item.aspiration}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Date"/>
                                </f:facet>
                                <h:outputText value="#{item.date}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Improvement"/>
                                </f:facet>
                                <h:outputText value="#{item.improvement}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Mobility"/>
                                </f:facet>
                                <h:outputText value="#{item.mobility}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nactivity"/>
                                </f:facet>
                                <h:outputText value="#{item.nactivity}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Promises"/>
                                </f:facet>
                                <h:outputText value="#{item.promises}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Target"/>
                                </f:facet>
                                <h:outputText value="#{item.target}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Saved"/>
                                </f:facet>
                                <h:outputText value="#{item.saved}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EmployeeIdFk"/>
                                </f:facet>
                                <h:outputText value="#{item.employeeIdFk}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{enote.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][enote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{enote.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][enote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{enote.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentEnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][enote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="TeamList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.teamList}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.teamList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.teamList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Id"/>
                                </f:facet>
                                <h:outputText value="#{item.id}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TeamName"/>
                                </f:facet>
                                <h:outputText value="#{item.teamName}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="TeamManagerIdFk"/>
                                </f:facet>
                                <h:outputText value="#{item.teamManagerIdFk}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{team.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTeam" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][team.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{team.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTeam" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][team.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{team.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentTeam" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][team.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="MnoteList:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.mnoteList}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.mnoteList}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.mnoteList}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Id"/>
                                </f:facet>
                                <h:outputText value="#{item.id}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Achievements"/>
                                </f:facet>
                                <h:outputText value="#{item.achievements}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Aspiration"/>
                                </f:facet>
                                <h:outputText value="#{item.aspiration}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Date"/>
                                </f:facet>
                                <h:outputText value="#{item.date}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Improvement"/>
                                </f:facet>
                                <h:outputText value="#{item.improvement}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nactivity"/>
                                </f:facet>
                                <h:outputText value="#{item.nactivity}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Note"/>
                                </f:facet>
                                <h:outputText value="#{item.note}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Potent"/>
                                </f:facet>
                                <h:outputText value="#{item.potent}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Promises"/>
                                </f:facet>
                                <h:outputText value="#{item.promises}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Summary"/>
                                </f:facet>
                                <h:outputText value="#{item.summary}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Target"/>
                                </f:facet>
                                <h:outputText value="#{item.target}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Version"/>
                                </f:facet>
                                <h:outputText value="#{item.version}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Modification"/>
                                </f:facet>
                                <h:outputText value="#{item.modification}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Confirmation"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmation}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ModificationId"/>
                                </f:facet>
                                <h:outputText value="#{item.modificationId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ConfirmId"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EmployeeIdFk"/>
                                </f:facet>
                                <h:outputText value="#{item.employeeIdFk}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{mnote.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{mnote.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{mnote.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="MnoteList1:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.mnoteList1}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.mnoteList1}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.mnoteList1}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Id"/>
                                </f:facet>
                                <h:outputText value="#{item.id}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Achievements"/>
                                </f:facet>
                                <h:outputText value="#{item.achievements}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Aspiration"/>
                                </f:facet>
                                <h:outputText value="#{item.aspiration}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Date"/>
                                </f:facet>
                                <h:outputText value="#{item.date}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Improvement"/>
                                </f:facet>
                                <h:outputText value="#{item.improvement}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nactivity"/>
                                </f:facet>
                                <h:outputText value="#{item.nactivity}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Note"/>
                                </f:facet>
                                <h:outputText value="#{item.note}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Potent"/>
                                </f:facet>
                                <h:outputText value="#{item.potent}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Promises"/>
                                </f:facet>
                                <h:outputText value="#{item.promises}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Summary"/>
                                </f:facet>
                                <h:outputText value="#{item.summary}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Target"/>
                                </f:facet>
                                <h:outputText value="#{item.target}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Version"/>
                                </f:facet>
                                <h:outputText value="#{item.version}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Modification"/>
                                </f:facet>
                                <h:outputText value="#{item.modification}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Confirmation"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmation}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ModificationId"/>
                                </f:facet>
                                <h:outputText value="#{item.modificationId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ConfirmId"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EmployeeIdFk"/>
                                </f:facet>
                                <h:outputText value="#{item.employeeIdFk}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{mnote.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{mnote.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{mnote.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>
                    <h:outputText value="MnoteList2:" />
                    <h:panelGroup>
                        <h:outputText rendered="#{empty account.account.mnoteList2}" value="(No Items)"/>
                        <h:dataTable value="#{account.account.mnoteList2}" var="item" 
                                     border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px" 
                                     rendered="#{not empty account.account.mnoteList2}">
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Id"/>
                                </f:facet>
                                <h:outputText value="#{item.id}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Achievements"/>
                                </f:facet>
                                <h:outputText value="#{item.achievements}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Aspiration"/>
                                </f:facet>
                                <h:outputText value="#{item.aspiration}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Date"/>
                                </f:facet>
                                <h:outputText value="#{item.date}">
                                    <f:convertDateTime pattern="MM/dd/yyyy" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Improvement"/>
                                </f:facet>
                                <h:outputText value="#{item.improvement}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Nactivity"/>
                                </f:facet>
                                <h:outputText value="#{item.nactivity}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Note"/>
                                </f:facet>
                                <h:outputText value="#{item.note}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Potent"/>
                                </f:facet>
                                <h:outputText value="#{item.potent}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Promises"/>
                                </f:facet>
                                <h:outputText value="#{item.promises}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Summary"/>
                                </f:facet>
                                <h:outputText value="#{item.summary}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Target"/>
                                </f:facet>
                                <h:outputText value="#{item.target}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Version"/>
                                </f:facet>
                                <h:outputText value="#{item.version}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Modification"/>
                                </f:facet>
                                <h:outputText value="#{item.modification}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="Confirmation"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmation}">
                                    <f:convertDateTime pattern="MM/dd/yyyy HH:mm:ss" />
                                </h:outputText>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ModificationId"/>
                                </f:facet>
                                <h:outputText value="#{item.modificationId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="ConfirmId"/>
                                </f:facet>
                                <h:outputText value="#{item.confirmId}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText value="EmployeeIdFk"/>
                                </f:facet>
                                <h:outputText value="#{item.employeeIdFk}"/>
                            </h:column>
                            <h:column>
                                <f:facet name="header">
                                    <h:outputText escape="false" value="&nbsp;"/>
                                </f:facet>
                                <h:commandLink value="Show" action="#{mnote.detailSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Edit" action="#{mnote.editSetup}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                                <h:outputText value=" "/>
                                <h:commandLink value="Destroy" action="#{mnote.destroy}">
                                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.currentMnote" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][mnote.converter].jsfcrud_invoke}"/>
                                    <f:param name="jsfcrud.relatedController" value="account" />
                                    <f:param name="jsfcrud.relatedControllerType" value="pl.lodz.p.it.spjava.sop8.ejb.endpoints.AccountController" />
                                </h:commandLink>
                            </h:column>
                        </h:dataTable>
                    </h:panelGroup>

                </h:panelGrid>
                <br />
                <h:commandLink action="#{account.remove}" value="Destroy">
                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <br />
                <h:commandLink action="#{account.editSetup}" value="Edit">
                    <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][account.account][account.converter].jsfcrud_invoke}" />
                </h:commandLink>
                <br />
                <h:commandLink action="#{account.createSetup}" value="New Account" />
                <br />
                <h:commandLink action="#{account.listSetup}" value="Show All Account Items"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
