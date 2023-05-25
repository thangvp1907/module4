<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<h1>Choose spice for  your sandwich</h1>
<form action="/save" method="post" >
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Lettuce" id="flexCheckDefault" name="condiment">
        <label class="form-check-label" for="flexCheckDefault">
            Lettuce
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Tomato" id="flexCheckDefault2" name="condiment">
        <label class="form-check-label" for="flexCheckDefault2">
            Tomato
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Mustard" id="flexCheckDefault3" name="condiment">
        <label class="form-check-label" for="flexCheckDefault3">
            Mustard
        </label>
    </div>
    <div class="form-check">
        <input class="form-check-input" type="checkbox" value="Sprouts" id="flexCheckDefault4" name="condiment">
        <label class="form-check-label" for="flexCheckDefault4">
            Sprouts
        </label>
    </div>


    <input type="submit" value="Save">
    <h5 style="color: darkred">The spices you choose are: : ${choose}</h5>
</form>
</body>
</html>
