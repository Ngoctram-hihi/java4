<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Kết Quả Đăng Ký</title></head>
<body>
    <h2>Kết Quả Đăng Ký</h2>
    <ul>
        <li>Tên đăng nhập: <b>${param.username}</b></li>
        <li>Mật khẩu: <b>${param.password}</b></li>
        <li>Giới tính: <b>${param.gender}</b></li>
        <li>Tình trạng hôn nhân: <b>${param.married}</b></li>
        <li>Quốc tịch: <b>${param.country}</b></li>
        <li>Ghi chú: <b>${param.notes}</b></li>
        <li>Sở thích: <b>
            <c:forEach var="hobby" items="${paramValues.hobbies}">
                ${hobby}&nbsp;
            </c:forEach>
        </b></li>
    </ul>
</body>
</html>
