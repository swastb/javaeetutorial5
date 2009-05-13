<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%--
The taglib directive below imports the JSTL library. If you uncomment it,
you must also add the JSTL library to the project. The Add Library... action
on Libraries node in Projects view can be used to add the JSTL 1.1 library.
--%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response Page</title>
    </head>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
    <f:view>
        <h:form>
            <h2><h:outputText value="#{bundle.YouAre} "/>
            <h:outputText value="#{bundle.SameAge}" rendered="#{dukesBDay.ageDiff == 0}"/>
            <h:outputText value="#{dukesBDay.absAgeDiff}" rendered="#{dukesBDay.ageDiff < 0}"/>
            <h:outputText value=" #{bundle.Year} " rendered="#{dukesBDay.ageDiff == -1}"/>
            <h:outputText value=" #{bundle.Years} " rendered="#{dukesBDay.ageDiff < -1}"/>
            <h:outputText value="#{bundle.Younger}" rendered="#{dukesBDay.ageDiff < 0}"/>
            <h:outputText value="#{dukesBDay.absAgeDiff}" rendered="#{dukesBDay.ageDiff > 0}"/>
            <h:outputText value=" #{bundle.Year} " rendered="#{dukesBDay.ageDiff == 1}"/>
            <h:outputText value=" #{bundle.Years} " rendered="#{dukesBDay.ageDiff > 1}"/>
            <h:outputText value="#{bundle.Older}" rendered="#{dukesBDay.ageDiff > 0}"/>
            <p><h:commandButton id="back" value="#{bundle.Back}" action="success"/>
        </h:form>
    </f:view>
</html>
