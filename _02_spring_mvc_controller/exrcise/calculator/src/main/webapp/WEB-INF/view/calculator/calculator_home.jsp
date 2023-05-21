<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Calculator</h1>
<form action="/calculators" method="post">
    <div class="row">
        <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping">Number One </span>
            <input type="text" class="form-control" placeholder="Enter number..." aria-label="Enter number..."
                   aria-describedby="addon-wrapping" name="inputOne">
        </div>
        <div class="input-group flex-nowrap">
            <span class="input-group-text" id="addon-wrapping2">Number Tow </span>
            <input type="text" class="form-control" placeholder="Enter number..." aria-label="Enter number..."
                   aria-describedby="addon-wrapping" name="inputTwo">
        </div>

    </div>
    <div class="row">
        <div class="col-3">
            <button type="submit" name="enter" value="+" class="btn btn-primary">Addition(+)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="enter" value="-" class="btn btn-success">Subtraction(-)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="enter" value="X" class="btn btn-danger">Multiplication(X)</button>
        </div>
        <div class="col-3">
            <button type="submit" name="enter" value="/" class="btn btn-info">Division(/)</button>
        </div>
    </div>
</form>
<h3>Result : ${result}</h3>
</body>
</html>
