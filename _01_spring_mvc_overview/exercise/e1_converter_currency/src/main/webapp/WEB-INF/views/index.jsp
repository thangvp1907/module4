<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h2>Chuyển Đổi Tiền Tệ USD Sang VND</h2>
<form method="post" action="/usd">
    <table>
        <tr>
            <td >USD </td>
            <td><input type="text" name="usd" placeholder="USD" value="0"></td>
        </tr>
        <tr>
            <td></td>
            <td> <input type="submit" id="submit" value="Converter" class="bg-primary"></td>
        </tr>
        <tr>
            <td>Kết quả </td>
            <td><input value="${result}"></td>
        </tr>

    </table>

</form>
</body>
</html>