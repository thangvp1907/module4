<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/12/2023
  Time: 8:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Tra Cuu Tu Dien Tieng Anh</h2>
<form method="post" action="/search">
    <label>
        <input type="search" name="keyword">
    </label>
    <input type="submit" value="Search">
</form>

<h2>${key}</h2>
<h2> Meaning: ${word}</h2>

</body>
</html>
