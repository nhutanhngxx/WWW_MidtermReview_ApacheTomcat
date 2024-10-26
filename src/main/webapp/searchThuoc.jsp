<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/25/2024
  Time: 2:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tìm kiếm Thuốc</title>
    <style>
        .inputSearch {
            width: 300px;
            height: 30px;
            margin: 10px;
        }
    </style>
</head>

<body>
<h1>Tìm kiếm Thuốc</h1> <br>
<form action="thuoc" method="post">
    <input type="text" name="tenThuoc" placeholder="Nhập tên thuốc cần tìm" class="inputSearch">
    <button type="submit" name="action" value="searchThuocbyName">Tìm kiếm</button>
</form>
<form action="thuoc" method="post">
    <input type="hidden" name="action" value="searchThuocByLoaiThuoc">
    <select id="loaiThuoc" name="loaiThuoc" class="inputSearch" required>
        <option value="">Chọn loại thuốc</option>
        <c:forEach var="loaiThuoc" items="${loaiThuocList}">
            <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
        </c:forEach>
    </select>
    <button type="submit">Tìm kiếm</button>
</form>

<h2>Kết quả tìm kiếm</h2>
<c:if test="${not empty thuocList}">
    <table border="1">
        <thead>
        <tr>
            <th>Mã Thuốc</th>
            <th>Tên Thuốc</th>
            <th>Giá</th>
            <th>Năm Sản Xuất</th>
            <th>Loại Thuốc</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="thuoc" items="${thuocList}">
            <tr>
                <td>${thuoc.maThuoc}</td>
                <td>${thuoc.tenThuoc}</td>
                <td>${thuoc.gia}</td>
                <td>${thuoc.namSX}</td>
                <td>${thuoc.loaiThuoc.tenLoai}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<c:if test="${empty thuocList}">
    <p>Không có kết quả tìm kiếm.</p>
</c:if>
</body>
</html>
