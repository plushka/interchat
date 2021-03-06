<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title><spring:message code="label.form.title"/></title>
</head>
<body>
<H1>
    <spring:message code="label.form.title"/>
</H1>
<form:form modelAttribute="user" method="POST" enctype="utf8">
    <table>
    <tr>
        <td>
            <label><spring:message code="label.user.firstName"/></label>
        </td>
        <td><form:input path="firstName" value="" /></td>
        <form:errors path="firstName" element="div"/>
    </tr>
    <tr>
        <td>
            <label><spring:message code="label.user.lastName"/></label>
        </td>
        <td><form:input path="lastName" value="" /></td>
        <form:errors path="lastName" element="div" />
    </tr>
    <tr>
        <td>
            <label><spring:message code="label.user.email"/></label>
        </td>
        <td><form:input path="email" value="" /></td>
        <form:errors path="email" element="div" />
    </tr>
    <tr>
        <td>
            <label><spring:message code="label.user.password"/></label>
        </td>
        <td><form:input path="password" value="" type="password" /></td>
        <form:errors path="password" element="div" />
    </tr>
    <tr>
        <td><label><spring:message code="label.user.confirmPass"/></label>
        </td>
        <td><form:input path="matchingPassword" value="" type="password" /></td>
        <form:errors element="div" />
    </tr>
    </table>
    <button type="submit"><spring:message code="label.form.submit"/></button>
</form:form>
<br>
<a href="<c:url value="../login" />">
    <spring:message code="label.form.loginLink"/>
</a>
</body>
</html>