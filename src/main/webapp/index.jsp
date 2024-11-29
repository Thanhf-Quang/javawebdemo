<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="InsertServlet" method="post">
    <label>Số CMND:</label>
    <input type="text" name="soCMND" required><br>

    <label>Họ Tên:</label>
    <input type="text" name="hoTen"><br>

    <label>Email:</label>
    <input type="email" name="email"><br>

    <label>Số Điện Thoại:</label>
    <input type="text" name="soDT"><br>

    <label>Địa Chỉ:</label>
    <input type="text" name="diaChi"><br>

    <label>Trường:</label>
    <select name="maTruong" required>
        <!-- Option được tải từ database -->
        <option value="DHQG">ĐHQG</option>
        <option value="BKDN">Bách Khoa Đà Nẵng</option>
    </select><br>

    <label>Ngành:</label>
    <select name="maNganh" required>
        <!-- Option được tải từ database -->
        <option value="CNTT">Công Nghệ Thông Tin</option>
        <option value="KTMT">Kỹ Thuật Máy Tính</option>
    </select><br>

    <label>Hệ TN:</label>
    <input type="text" name="heTN"><br>

    <label>Ngày Tốt Nghiệp:</label>
    <input type="date" name="ngayTN" required><br>

    <label>Loại TN:</label>
    <input type="text" name="loaiTN"><br>

    <button type="submit">Thêm Sinh Viên</button>
</form>

</body>
</html>