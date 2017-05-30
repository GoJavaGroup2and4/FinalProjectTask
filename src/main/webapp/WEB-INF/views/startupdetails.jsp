<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title><c:out value="${startup.name}"/> </title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<h1><c:out value="${startup.name}"/></h1>

<div>
    <div>Category: <span><c:out value="${startup.category.name}"/></span></div>
</div>

<br/>

<div>
    <c:if test="${startup.status == 'approved'}">
        <div><a href="<c:url value="/invest/${startup.id}"/>"> Make an investment</a></div>
    </c:if>

    <div>Total required amount: <c:out value="${startup.needed_investment}"/></div>

    <div>Investments received: <c:out value="${startup.current_investment}"/></div>
</div>

<%--<div>--%>
    <%--<div>Average Startup rating: <c:out value="${average_rating}"/> votes(<c:out value="${votes_count}"/>)</div>--%>
<%--</div>--%>

<br/>

<div>
    <div>Description:</div>
    <div>
        <div><c:out value="${startup.description}"/></div>
    </div>
</div>

<br/>

<div>
    <c:if test="${is_admin}">
        <div>Startup status: <c:out value="${startup.status}"/></div>
        <c:choose>
            <c:when test="${startup.status == 'Ready for approve'}">
                <div><a href="<c:url value="/startupdetails/approve/${startup.id}"/>">Approve startup</a></div>
            </c:when>

            <c:when test="${startup.status == 'Ready for approve'}">
                <div><a href="<c:url value="/startupdetails/reject/${startup.id}"/>">Reject startup</a></div>
            </c:when>
        </c:choose>
        <div><a href="<c:url value="/startupdetails/delete/${startup.id}"/>">Delete startup</a></div>
    </c:if>

    <c:if test="${is_owner}">
        <div>Startup status: <c:out value="${startup.status}"/></div>
        <c:choose>
            <c:when test="${startup.status == 'Draft' || startup.status == 'Rejected'}">
                <div><a href="<c:url value="/startupdetails/ready/${startup.id}"/> ">Send startup for approve</a> </div>
            </c:when>
            <c:when test="${startup.status == 'Approved'}">
                <div><a href="<c:url value="/startupdetails/close/${startup.id}"/> ">Close startup</a> </div>
            </c:when>
        </c:choose>

        <div><a href="<c:url value="/startupedit/${startup.id}"/>">Edit startup</a></div>
    </c:if>

</div>

</body>
</html>
