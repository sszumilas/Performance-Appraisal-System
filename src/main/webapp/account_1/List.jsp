<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
            <title>Listing Account Items</title>
            <link rel="stylesheet" type="text/css" href="SOP8/Bundle/jsfcrud.css" />
        </head>
        <body>
            <h:panelGroup id="messagePanel" layout="block">
                <h:messages errorStyle="color: red" infoStyle="color: green" layout="table"/>
            </h:panelGroup>
            <h1>Listing Account Items</h1>
            <h:form styleClass="jsfcrud_list_form">
                <h:outputText escape="false" value="(No Account Items Found)<br />" rendered="#{account.pagingInfo.itemCount == 0}" />
                <h:panelGroup rendered="#{account.pagingInfo.itemCount > 0}">
                    <h:outputText value="Item #{account.pagingInfo.firstItem + 1}..#{account.pagingInfo.lastItem} of #{account.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{account.prev}" value="Previous #{account.pagingInfo.batchSize}" rendered="#{account.pagingInfo.firstItem >= account.pagingInfo.batchSize}"/>&nbsp;
                    <h:commandLink action="#{account.next}" value="Next #{account.pagingInfo.batchSize}" rendered="#{account.pagingInfo.lastItem + account.pagingInfo.batchSize <= account.pagingInfo.itemCount}"/>&nbsp;
                    <h:commandLink action="#{account.next}" value="Remaining #{account.pagingInfo.itemCount - account.pagingInfo.lastItem}"
                                   rendered="#{account.pagingInfo.lastItem < account.pagingInfo.itemCount && account.pagingInfo.lastItem + account.pagingInfo.batchSize > account.pagingInfo.itemCount}"/>
                    <h:dataTable value="#{account.accountItems}" var="item" border="0" cellpadding="2" cellspacing="0" rowClasses="jsfcrud_odd_row,jsfcrud_even_row" rules="all" style="border:solid 1px">
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="BusinessKey"/>
                            </f:facet>
                            <h:outputText value="#{item.businessKey}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Email"/>
                            </f:facet>
                            <h:outputText value="#{item.email}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Name"/>
                            </f:facet>
                            <h:outputText value="#{item.name}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Surname"/>
                            </f:facet>
                            <h:outputText value="#{item.surname}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Login"/>
                            </f:facet>
                            <h:outputText value="#{item.login}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Password"/>
                            </f:facet>
                            <h:outputText value="#{item.password}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Telephone"/>
                            </f:facet>
                            <h:outputText value="#{item.telephone}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Type"/>
                            </f:facet>
                            <h:outputText value="#{item.type}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Personaldata"/>
                            </f:facet>
                            <h:outputText value="#{item.personaldata}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Admindata"/>
                            </f:facet>
                            <h:outputText value="#{item.admindata}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Managerdata"/>
                            </f:facet>
                            <h:outputText value="#{item.managerdata}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Employeedata"/>
                            </f:facet>
                            <h:outputText value="#{item.employeedata}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="Id"/>
                            </f:facet>
                            <h:outputText value="#{item.id}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText value="BusinessKey"/>
                            </f:facet>
                            <h:outputText value="#{item.businessKey}"/>
                        </h:column>
                        <h:column>
                            <f:facet name="header">
                                <h:outputText escape="false" value="&nbsp;"/>
                            </f:facet>
                            <h:commandLink value="Show" action="#{account.detailSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Edit" action="#{account.editSetup}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                            <h:outputText value=" "/>
                            <h:commandLink value="Destroy" action="#{account.remove}">
                                <f:param name="jsfcrud.currentAccount" value="#{jsfcrud_class['pl.lodz.p.it.spjava.sop8.ejb.endpoints.util.JsfUtil'].jsfcrud_method['getAsConvertedString'][item][account.converter].jsfcrud_invoke}"/>
                            </h:commandLink>
                        </h:column>

                    </h:dataTable>
                </h:panelGroup>
                <br />
                <h:commandLink action="#{account.createSetup}" value="New Account"/>
                <br />
                <br />
                <h:commandLink value="Index" action="welcome" immediate="true" />


            </h:form>
        </body>
    </html>
</f:view>
