<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/25/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h2 style="color: red">${mess}</h2>
<table class="table table-striped table-bordered">
    <tr class="bg-primary">
        <th>họ tên:</th>
        <th>Năm sinh:</th>
        <th>giới tính:</th>
        <th>quốc tịch:</th>
        <th>số hộ chiếu:</th>
        <th>Thông tin đi lại:</th>
        <th>số hiệu phương tiện:</th>
        <th>số ghế:</th>
        <th>ngày khởi hành:</th>
        <th>ngày kết thúc:</th>
        <th>tình trạng đi lại:</th>
    </tr>
    <c:forEach var="dec" items="${declarationList}">
        <tr>
            <td>${dec.name}</td>
            <td>${dec.birthday}</td>
            <td>${dec.gender}</td>
            <td>${dec.nationality}</td>
            <td>${dec.passportId}</td>
            <td>${dec.travelInformation}</td>
            <td>${dec.vehicleNumber}</td>
            <td>${dec.seats}</td>
            <td>${dec.departureDay}</td>
            <td>${dec.endDate}</td>
            <td>${dec.status}</td>
        </tr>
    </c:forEach>
</table
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
