<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
    <h2 style="text-align:center;">Danh sách sản phẩm</h2>
    <table border="1" cellpadding="10" cellspacing="0" style="margin:auto;">
        <tr>
            <th>Tên sản phẩm</th>
            <th>Hình ảnh</th>
            <th>Giá</th>
            <th>Khuyến mãi</th>
            <th>Thao tác</th>
        </tr>
        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.name}</td>
                <td><img src="${pageContext.request.contextPath}/${p.image}" width="100"></td>
                <td>$${p.price}</td>
                <td>${p.discount * 100}%</td>
                <td>
                
                    <form action="${pageContext.request.contextPath}/cart" method="get">
                        <input type="hidden" name="name" value="${p.name}">
                        Số lượng: <input type="number" name="qty" value="1" min="1" style="width:50px;">
                        <button type="submit">Thêm vào giỏ</button>
                    </form>
                    <a href="${pageContext.request.contextPath}/product-detail?name=${p.name}">Chi tiết</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
