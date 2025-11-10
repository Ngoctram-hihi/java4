<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Form Đăng Ký</title></head>
<body>
    <h2>Form Đăng Ký</h2>
    <form action="${pageContext.request.contextPath}/dang-ky" method="post">
        Tên đăng nhập: <input name="username"><br>
        Mật khẩu: <input name="password" type="password"><br>
        Giới tính:
        <input name="gender" type="radio" value="Nam">Nam
        <input name="gender" type="radio" value="Nữ">Nữ<br>
        <input name="married" type="checkbox">Đã có gia đình?<br>
        Quốc tịch:
        <select name="country">
            <option value="VN">Việt Nam</option>
            <option value="US">United States</option>
        </select><br>
        Ghi chú: <textarea name="notes" rows="3" cols="30"></textarea><br>
        Sở thích:
        <input name="hobbies" type="checkbox" value="Đọc Sách">Đọc sách
        <input name="hobbies" type="checkbox" value="Du Lịch">Du lịch
        <input name="hobbies" type="checkbox" value="Âm Nhạc">Âm nhạc
        <input name="hobbies" type="checkbox" value="khác">Khác<br>
        <hr>
        <button type="submit">Đăng ký</button>
    </form>
</body>
</html>
