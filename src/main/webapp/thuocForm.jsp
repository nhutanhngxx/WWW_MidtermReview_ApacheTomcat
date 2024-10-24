<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/25/2024
  Time: 12:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Thêm mới thuốc</title>
    <style>
        label {
            width: 150px;
            display: inline-block;
        }
    </style>
</head>
<body>
<h2>Thêm mới thuốc</h2>
<form action="thuoc" method="post">
    <label for="tenThuoc">Tên thuốc</label>
    <input type="text" id="tenThuoc" name="tenThuoc" required>
    <br><br>

    <label for="gia">Đơn giá</label>
    <input type="text" id="gia" name="gia" required>
    <br><br>

    <label for="namSX">Năm sản xuất</label>
    <input type="text" id="namSX" name="namSX" required>
    <br><br>

    <label for="loaiThuoc">Loại Thuốc: </label>
    <select id="loaiThuoc" name="loaiThuoc" required>
      <option value="">Chọn loại thuốc</option>
      <c:forEach var="loaiThuoc" items="${loaiThuocList}">
        <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
      </c:forEach>
    </select><br><br>
    <button type="submit" name="action" value="addThuoc">Thêm mới</button>
<%--    <button type="submit" name="action" value="thuocList">Danh sách</button>--%>
<%--    <button type="submit" name="action" value="index">Trang chính</button>--%>
</form>
</body>
</html>
