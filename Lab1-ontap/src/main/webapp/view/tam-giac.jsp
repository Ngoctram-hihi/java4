<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tính toán tam giác</title>
</head>
<body>
    <h2>Nhập các cạnh của tam giác</h2>

    <form method="post">
        <input name="a" placeholder="Cạnh a?" required><br>
        <input name="b" placeholder="Cạnh b?" required><br>
        <input name="c" placeholder="Cạnh c?" required><hr>

        <!-- Nút gửi đến /dien-tich -->
        <button formaction="${pageContext.request.contextPath}/dien-tich">Tính diện tích</button>

        <!-- Nút gửi đến /chu-vi -->
        <button formaction="${pageContext.request.contextPath}/chu-vi">Tính chu vi</button>
    </form>

    <h3 style="color:blue">${message}</h3>
</body>
</html>
