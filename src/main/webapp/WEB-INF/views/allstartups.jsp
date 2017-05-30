<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page session="false" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/allStartupsStyle.css"/>">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>All Startups</title>
</head>

<body>
<jsp:include page="navbar.jsp"/>


<section class="section-types">

    <c:forEach items="${categories}" var="category">
        <div class="row">
            <h2>${category.name}</h2>
        </div>

        <c:forEach items="${allStartups}" var="startup">
            <div class="col-md-3">
                <a style="text-decoration: none;" href="<c:url value='/allstartups/${startup.id}'/>" class="">
                    <div class="jumbo1">
                        <h4>
                            <p>${startup.name}</p>
                        </h4>
                        <h4>
                            <small>Needed investments:</small>
                            <p>${startup.needed_investment}</p>
                        </h4>
                        <h4>
                            <small>Current investments:</small>
                            <p>${startup.current_investment}</p>
                        </h4>
                    </div>
                </a>
            </div>
        </c:forEach>
    </c:forEach>

</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>