<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2023
  Time: 12:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form action="/save" method="post" modelAttribute="mailList">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td>Languages</td>
            <td><form:select path="languages" items="${languagesList}"/></td>
        </tr>
        <tr>
            <td>Page size</td>
            <td>show <form:select path="pageSize" items="${pageSize}"/>email per page</td>
        </tr>
        <tr>
            <td>spamFilter</td>
            <td><form:checkbox path="spamFilter"/>enable spams filter</td>
        </tr>
        <tr>
            <td>signature</td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><form:button>Update</form:button></td>
            <td><form:button>back</form:button></td>

        </tr>
    </table>
</form:form>

</body>
</html>
