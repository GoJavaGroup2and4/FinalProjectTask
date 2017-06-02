<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><c:out value="${startup.name}"/></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<jsp:include page="navbar.jsp"/>

<form:form action="/startupedit/${startup.id}" method="POST" commandName="startup" modelAttribute="startup">
    <c:if test="${!empty startup}">
        <div class="container">
            <h2>${startup.name}:</h2>
            <br/>

            <form class="form-horizontal">

                <div class="form-group">
                    <label class="control-label col-sm-2">
                        <spring:message text="Name:"/>
                    </label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="name"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">
                        <spring:message text="Needed Invesment:"/>
                    </label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="needed_investment"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">
                        <spring:message text="Description:"/>
                    </label>
                    <div class="col-sm-10">
                        <form:input class="form-control" path="description"/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="control-label col-sm-2">
                        <spring:message text="Category:"/>
                    </label>
                    <div class="col-sm-10">
                        <form:select class="form-control" path="category" multiple="single">
                            <form:option value="${startup.category.name}"/>
                            <form:options items="${category_names}"/>
                        </form:select>
                    </div>
                </div>

                <br/>

                <div class="form-group">
                    <label class="control-label col-sm-2">
                        <input class="btn btn-primary" type="submit" value="<spring:message text="Save changes"/>"/>
                        <a href="<c:url value="/allstartups"/>" class="btn btn-ghost">Cancel</a>
                    </label>
                </div>


            </form>

        </div>
    </c:if>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>

</body>
</html>
