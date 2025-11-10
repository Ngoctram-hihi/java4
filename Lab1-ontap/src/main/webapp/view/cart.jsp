<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Giỏ hàng</title>
    <style>
        table { border-collapse: collapse; width: 80%; margin: auto; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: center; }
        img { width: 80px; }
        h2 { text-align: center; }
    </style>
</head>
<body>
    <h2>Giỏ hàng</h2>
    <table>
        <tr>
            <th>Tên sản phẩm</th>
            <th>Hình ảnh</th>
            <th>Số lượng</th>
            <th>Giá</th>
            <th>Tổng giá</th>
            <th>Thao tác</th>
        </tr>
        <c:set var="total" value="0" />
        <c:forEach var="item" items="${cart}">
            <tr>
                <td>${item.name}</td>
                <td><img src="${pageContext.request.contextPath}/${item.image}" /></td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart-update" method="get">
                        <input type="hidden" name="name" value="${item.name}" />
                        <input type="number" name="qty" value="${item.qty}" min="1" style="width:50px;" />
                        <button type="submit">Cập nhật</button>
                    </form>
                </td>
                <td>$${item.price}</td>
                <td>$${item.price * item.qty}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/cart-remove" method="get">
                        <input type="hidden" name="name" value="${item.name}" />
                        <button type="submit">Xóa</button>
                    </form>
                </td>
            </tr>
            <c:set var="total" value="${total + (item.price * item.qty)}" />
        </c:forEach>
        <tr>
            <td colspan="4" style="text-align:right;"><b>Tổng giá giỏ hàng:</b></td>
            <td colspan="2"><b>$${total}</b></td>
        </tr>
    </table>
</body>
</html>
