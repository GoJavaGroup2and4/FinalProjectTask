<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>StartUp: Registration</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">


    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>

<div class="modal-dialog">
    <form:form method="post" modelAttribute="userForm" class="loginmodal-container">
        <h1>Create Your Account</h1><br>
        <spring:bind path="login">
            <div class="${status.error ? 'has-error' : ''}">
                <form:errors path="login"></form:errors>
                <form:input type="text" path="login" class="form-control" placeholder="Login"
                            autofocus="true"></form:input>

            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="${status.error ? 'has-error' : ''}">
                <form:errors path="password"></form:errors>
                <form:input type="password" path="password" class="form-control"
                            placeholder="Password"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="confirmPassword"></form:errors>
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="firstName"></form:errors>
                <form:input type="text" path="firstName" class="form-control" placeholder="First Name"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:errors path="lastName"></form:errors>
                <form:input type="text" path="lastName" class="form-control" placeholder="Last Name"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="${status.error ? 'has-error' : ''}">
                <form:errors path="email"></form:errors>
                <form:input type="text" path="email" class="form-control" placeholder="Email"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="phoneNumber">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="text" path="phoneNumber" class="form-control" placeholder="Phone Number"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="country">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="text" path="country" class="form-control" placeholder="Country"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="city">
            <div class="${status.error ? 'has-error' : ''}">
                <form:input type="text" path="city" class="form-control" placeholder="City"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
