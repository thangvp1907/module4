<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        h3, h5 {
            text-align: center;
        }

        h6 {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<form:form action="/save" method="post" modelAttribute="declaration">
    <h3>TỜ KHAI Y TẾ</h3>
    <h5>ĐÂY LÀ TÀI LIỆU QAUNG TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾLIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM</h5>
    <h6>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xưr lý hình sự.</h6>

    <div class="mb-3">
        <label class="form-label" for="inputEmail">Họ tên(ghi chữ IN HOA)</label>
        <form:input path="name" class="form-control" id="inputEmail" placeholder="Email"/>
    </div>
    <div class="row">
        <div class="col">
            <label class="form-label" for="inputEmail">Năm sinh</label>
        </div>
        <div class="col">
            <label class="form-label" for="inputEmail">giới tinh</label>
        </div>
        <div class="col">
            <label class="form-label" for="inputEmail">quốc tịch</label>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="birthday" class="form-control"/>
        </div>
        <div class="col">
            <form:select path="gender" class="form-control">
                <form:option value="1" label="Nam"/>
                <form:option value="0" label="Nữ"/>
            </form:select>
        </div>
        <div class="col">
            <form:input path="nationality" class="form-control"/>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="inputEmail">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
        <form:input path="passportId" class="form-control" id="inputEmail"/>
    </div>
    <div class="mb-3">
        <label class="form-label" for="inputEmail">Thông tin đi lại</label><br>
        <form:radiobutton path="travelInformation" value="1" label="Tàu bay"/>
        <form:radiobutton path="travelInformation" value="2" label="Tàu thuyền"/>
        <form:radiobutton path="travelInformation" value="3" label="Ôtô"/>
        <form:radiobutton path="travelInformation" value="4" label="Khác"/>
    </div>
    <div class="row">
        <div class="col">
            <label class="form-label" for="inputEmail">Số hiệu phương tiện </label>
        </div>
        <div class="col">
            <label class="form-label" for="inputEmail">Số ghế</label>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="vehicleNumber" class="form-control"/>
        </div>
        <div class="col">
            <form:input path="seats" class="form-control"/>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <label class="form-label" for="inputEmail">Ngày khởi hành </label>
        </div>
        <div class="col">
            <label class="form-label" for="inputEmail">ngày kết thúc</label>
        </div>
    </div>
    <div class="row">
        <div class="col">
            <form:input path="departureDay" class="form-control"/>
        </div>
        <div class="col">
            <form:input path="endDate" class="form-control"/>
        </div>
    </div>
    <div class="mb-3">
        <label class="form-label" for="inputEmail">Trong vòng 14 ngày qua. Anh chị có đến tĩnh thành phố nào?</label>
        <form:textarea path="status" class="form-control" id="inputEmail"/>
    </div>

    <div>
        <button type="submit">save</button>
    </div>

</form:form>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
