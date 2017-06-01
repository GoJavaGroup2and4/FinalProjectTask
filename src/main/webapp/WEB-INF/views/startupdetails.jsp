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
    <div>Total required amount: <c:out value="${startup.needed_investment}"/>$</div>

    <div>Investments received: <c:out value="${startup.current_investment}"/>$</div>
</div>

<div>
    <div>Average Startup rating: <c:out value="${average_rating}"/> (votes: <c:out value="${votes_count}"/>)</div>
</div>

<br/>

<div>
    <div>Description:</div>
    <div>
        <div><c:out value="${startup.description}"/></div>
    </div>
</div>

<br/>

<div>
    <c:if test="${startup.status == 'Approved'}">
        <h4>Investor Block:</h4>
        <div>
            <form action="/startupdetails/${id}/invest" method="POST">
                <table>
                   <tr>
                       <td>Enter your amount: </td>
                       <td><input type="text" name="investment"></td>
                   </tr>
                    <tr>
                        <td colspan = "2">
                            <input type = "submit" value = "Make an investment"/>
                        </td>
                    </tr>
                </table>
                <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
            </form>
        </div>
    </c:if>

</div>

<br/>

<div>
    <c:if test="${is_owner}">
        <h4>Owner Block:</h4>
        <div>Startup status: <c:out value="${startup.status}"/></div>
        <c:if test="${startup.status == 'Draft' || startup.status == 'Rejected'}">
            <div><a href="<c:url value="/startupdetails/sendforapprove/${startup.id}"/> ">Send startup for approve</a> </div>
        </c:if>
        <c:if test="${startup.status != 'Closed'}">
            <div><a href="<c:url value="/startupedit/${startup.id}"/>">Edit startup</a></div>
            <div><a href="<c:url value="/startupdetails/close/${startup.id}"/> ">Close startup</a> </div>
        </c:if>
    </c:if>

</div>

<br/>

<div>
    <c:if test="${is_admin}">
        <h4>Admin Block:</h4>
        <div>Startup status: <c:out value="${startup.status}"/></div>
        <c:choose>
            <c:when test="${startup.status == 'Ready for approve'}">
                <div><a href="<c:url value="/startupdetails/approve/${startup.id}"/>">Approve startup</a></div>
                <div><a href="<c:url value="/startupdetails/reject/${startup.id}"/>">Reject startup</a></div>
            </c:when>
            <c:when test="${startup.status == 'Rejected' || startup.status == 'Closed'}">
                <div><a href="<c:url value="/startupdetails/delete/${startup.id}"/>">Delete startup</a></div>
                </c:when>
        </c:choose>
    </c:if>
</div>

</body>
</html>
