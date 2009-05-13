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
        <title>Firstcup Greeting Page</title>
    </head>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html" %>  
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<f:view>
    <h:form>
        <h2><h:outputText value="#{bundle.Welcome}"/></h2>
<h:outputText value="#{bundle.DukeIs} "/>        
<h:outputText value="#{dukesBDay.age}"/>
<p><h:outputText value="#{bundle.Instructions}"/>
<p><h:outputText value="#{bundle.YourBD} "/>
<h:inputText id="userBirthday" 
   value="#{dukesBDay.yourBD}" converterMessage="#{bundle.DateError}">
    <f:convertDateTime pattern="MM/dd/yyyy" />
</h:inputText>
<h:outputText value=" #{bundle.Pattern}"/>
<p><h:commandButton value="#{bundle.Submit}" action="success"/>
<p><h:message for="userBirthday" style="color:red"/>    
    
    </h:form>
</f:view>

</html>
