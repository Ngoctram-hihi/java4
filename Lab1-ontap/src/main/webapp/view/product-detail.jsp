<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
    <h2>Chi tiết sản phẩm</h2>
    <img src="${pageContext.request.contextPath}/${product.image}" width="200"><br>
    <b>${product.name}</b><br>
    Giá: $${product.price}<br>
    Giảm giá: ${product.discount * 100}%<br>
    Mô tả: ${product.description}<br>

    <form action="${pageContext.request.contextPath}/cart" method="get">
        <input type="hidden" name="name" value="${product.name}" />
        <input type="hidden" name="image" value="${product.image}" />
        <input type="hidden" name="price" value="${product.price}" />
        Số lượng: <input type="number" name="qty" value="1" min="1" style="width:50px;" />
        <button type="submit">Thêm vào giỏ hàng</button>
    </form>
</body>
</html>
