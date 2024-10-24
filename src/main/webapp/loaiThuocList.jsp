<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách loại thuốc</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Danh sách loại thuốc</h2>
<form action="controller" method="post">
    <table>
        <tr>
            <th>Mã loại</th>
            <th>Tên loại</th>
        </tr>
        <c:forEach var="loaiThuoc" items="${loaiThuocList}">
            <tr>
                <td>${loaiThuoc.maLoai}</td>
                <td>${loaiThuoc.tenLoai}</td>
            </tr>
        </c:forEach>
    </table>
</form>
<form action="controller" method="post">
    <button type="submit" name="action" value="loaiThuocForm">Thêm mới Loại Thuốc</button>
    <button type="button" onclick="window.location.href='searchLoaiThuoc.jsp'">Tìm kiếm Loại Thuốc</button>
    <button type="submit" name="action" value="index">Trang chính</button>
</form>
</body>
</html>