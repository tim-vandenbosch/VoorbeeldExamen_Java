<%--
  Created by IntelliJ IDEA.
  User: Ben
  Date: 6/19/2017
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Alle boekingen</title>
</head>
<body>

<table>
    <th>Id</th>
    <th>Day</th>
    <th>Name</th>
    <th>City</th>
    <th>Street</th>
    <th>Hour</th>

    <c:forEach items="${boeking}" var="boek">
        <tr>
            <td>${boek.id}</td>
            <td>${boek.dag}</td>
            <td>${boek.naam}</td>
            <td>${boek.stad}</td>
            <td>${boek.straat}</td>
            <td>${boek.uur}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
