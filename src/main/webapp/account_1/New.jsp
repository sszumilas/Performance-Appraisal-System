<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>New Account</title>
            <link rel="stylesheet" type="text/css" href="SOP8/Bundle/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>New Account</h1>
            <h:form>
                <h:inputHidden id="validateCreateField" validator="#{account.validateCreate}" value="value"/>
                <h:panelGrid columns="2">
                    <h:outputText value="BusinessKey:"/>
                    <h:outputText value="#{account.account.businessKey}" title="BusinessKey" />
                    <h:outputText value="Email:"/>
                    <h:inputText id="email" value="#{account.account.email}" title="Email" required="true" requiredMessage="The email field is required." />
                    <h:outputText value="Name:"/>
                    <h:inputText id="name" value="#{account.account.name}" title="Name" required="true" requiredMessage="The name field is required." />
                    <h:outputText value="Surname:"/>
                    <h:inputText id="surname" value="#{account.account.surname}" title="Surname" required="true" requiredMessage="The surname field is required." />
                    <h:outputText value="Login:"/>
                    <h:inputText id="login" value="#{account.account.login}" title="Login" required="true" requiredMessage="The login field is required." />
                    <h:outputText value="Password:"/>
                    <h:inputText id="password" value="#{account.account.password}" title="Password" required="true" requiredMessage="The password field is required." />
                    <h:outputText value="Telephone:"/>
                    <h:inputText id="telephone" value="#{account.account.telephone}" title="Telephone" />
                    <h:outputText value="Type:"/>
                    <h:outputText value="#{account.account.type}" title="Type" />
                    <h:outputText value="Personaldata:"/>
                    <h:selectOneMenu id="personaldata" value="#{account.account.personaldata}" title="Personaldata" >
                        <f:selectItems value="#{personaldata.personaldataItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Admindata:"/>
                    <h:selectOneMenu id="admindata" value="#{account.account.admindata}" title="Admindata" >
                        <f:selectItems value="#{admin.adminItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="Managerdata:"/>
                    <h:selectOneMenu id="managerdata" value="#{account.account.managerdata}" title="Managerdata" >
                        <f:selectItems value="#{manager.managerItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="EnoteList:"/>
                    <h:selectManyListbox id="enoteList" value="#{account.account.jsfcrud_transform[jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.arrayToList].enoteList}" title="EnoteList" size="6" converter="#{enote.converter}" >
                        <f:selectItems value="#{enote.enoteItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="Employeedata:"/>
                    <h:selectOneMenu id="employeedata" value="#{account.account.employeedata}" title="Employeedata" >
                        <f:selectItems value="#{employee.employeeItemsAvailableSelectOne}"/>
                    </h:selectOneMenu>
                    <h:outputText value="TeamList:"/>
                    <h:selectManyListbox id="teamList" value="#{account.account.jsfcrud_transform[jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.arrayToList].teamList}" title="TeamList" size="6" converter="#{team.converter}" >
                        <f:selectItems value="#{team.teamItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="MnoteList:"/>
                    <h:selectManyListbox id="mnoteList" value="#{account.account.jsfcrud_transform[jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.arrayToList].mnoteList}" title="MnoteList" size="6" converter="#{mnote.converter}" >
                        <f:selectItems value="#{mnote.mnoteItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="MnoteList1:"/>
                    <h:selectManyListbox id="mnoteList1" value="#{account.account.jsfcrud_transform[jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.arrayToList].mnoteList1}" title="MnoteList1" size="6" converter="#{mnote.converter}" >
                        <f:selectItems value="#{mnote.mnoteItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="MnoteList2:"/>
                    <h:selectManyListbox id="mnoteList2" value="#{account.account.jsfcrud_transform[jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.collectionToArray][jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method.arrayToList].mnoteList2}" title="MnoteList2" size="6" converter="#{mnote.converter}" >
                        <f:selectItems value="#{mnote.mnoteItemsAvailableSelectMany}"/>
                    </h:selectManyListbox>
                    <h:outputText value="Id:"/>
                    <h:outputText value="#{account.account.id}" title="Id" />
                    <h:outputText value="BusinessKey:"/>
                    <h:outputText value="#{account.account.businessKey}" title="BusinessKey" />

                </h:panelGrid>
                <br />
                <h:commandLink action="#{account.create}" value="Create"/>
                <br />
                <br />
                <h:commandLink action="#{account.listSetup}" value="Show All Account Items" immediate="true"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />

            </h:form>
        </body>
    </html>
</f:view>
