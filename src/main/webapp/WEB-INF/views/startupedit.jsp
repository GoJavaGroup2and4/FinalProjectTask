<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${startup.name}"/></title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<h1><c:out value="${startup.name}"/></h1>

<form:form action="/startupedit/" method="POST" commandName="startup">
    <c:if test="${!empty startup}">
        <table>
            <tr>
                <td>
                    <form:label path="name">
                        <spring:message text="Name"/>
                    </form:label>
                </td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="needed_investment">
                        <spring:message text="Needed Invesment"/>
                    </form:label>
                </td>
                <td><form:input path="needed_investment"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">
                        <spring:message text="Description"/>
                    </form:label>
                </td>
                <td><form:input path="description"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="category">
                        <spring:message text="Category"/>
                    </form:label>
                </td>
                <td>
                    <form:select path="category" multiple="single">
                        <form:option value="${startup.category.name}"/>
                        <form:options items="${category_names}"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="<spring:message text="Save changes"/>"/>
                </td>
            </tr>
        </table>
    </c:if>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>
</body>
</html>
