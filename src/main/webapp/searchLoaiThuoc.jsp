<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/24/2024
  Time: 7:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Tìm kiếm Loại Thuốc</title>
    </head>

    <body>
    <h2>Tìm kiếm loại thuốc</h2>
        <form action="controller" method="post">
            <label for="loaiThuoc">Nhập tên loại thuốc: </label>
            <input type="text" id="loaiThuoc" name="loaiThuoc" required><br><br>
            <button type="submit" name="action" value="searchLoaiThuoc">Tìm kiếm</button>
        </form>
        <form action="controller" method="post">
            <button type="submit" name="action" value="loaiThuocList">Danh sách Loại Thuốc</button>
            <button type="submit" name="action" value="index">Trang chính</button>
        </form>
    </body>
</html>

