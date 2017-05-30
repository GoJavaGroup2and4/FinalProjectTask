<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="startup/servlet-parameters" method="POST" enctype="multipart/form-data">
    <c:if test="${!empty startup}">
        <table class="tg">
            <tr>
                <td>Id:</td>
                <td><input readonly="readonly" type="text" name="id" value="${startup.id}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${startup.name}"/></td>
            </tr>
            <tr>
                <td>Picture:</td>
                <td>
                    <input type="file" name="picture" size="50"/>
                </td>
            </tr>
            <tr>
                <td>Attachment:</td>
                <td>
                    <input type="file" name="attachment" size="50"/>
                </td>
            </tr>
            <tr>
                <td>Current investment:</td>
                <td>
                    <input type="text" name="currentInvestment" value="${startup.current_investment}"/>
                </td>
            </tr>
            <tr>
                <td>Needed investment:</td>
                <td><input type="text" name="neededInvestment" value="${startup.needed_investment}"/></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" value="${startup.description}"/></td>
            </tr>
            <%--<tr>
                <td>Rating:</td>
                <td><input type="text" name="rating" value="${startup.rating}"/></td>
            </tr>--%>
            <tr>
                <td>Category:</td>
                <td>
                    <select name="category">
                        <c:forEach items="${listCategory}" var="category">
                            <option value="${category.id}">${category.name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><input type="text" name="status" value="${startup.status}"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Submit"/></td>
            </tr>
        </table>
    </c:if>
</form>
</body>
</html>
