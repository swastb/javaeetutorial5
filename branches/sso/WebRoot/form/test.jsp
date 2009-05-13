<%@ page language="java" pageEncoding="GBK"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean"
	prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html"
	prefix="html"%>

<html>
	<head>
		<title>JSP for DynaActionForm form</title>
	</head>
	<body>

		<logic:messagesPresent>
			<bean:message key="errors.header" />
			<ul>
				<html:messages id="error">
					<li>
						<bean:write name="error" />
					</li>
				</html:messages>
			</ul>
			<hr />
		</logic:messagesPresent>

		<html:form action="test.do?action=test"
			onsubmit="return validateTestForm(this);">
			<bean:message key="testForm.name" />
			<html:text property="name" />
			<html:errors property="name" />
			<br>
			<bean:message key="testForm.id" />
			<html:text property="id" />
			<html:errors property="id" />
			<br>
			<html:submit />
			<html:cancel />
		</html:form>
	</body>
	<html:javascript formName="testForm" />
</html>

