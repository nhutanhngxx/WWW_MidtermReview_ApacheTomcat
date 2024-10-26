<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 10/25/2024
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách loại thuốc</title>
  <style>
    body {
      width: 70%;
      justify-content: center;

    }
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
<form action="thuoc" method="post">
  <table>
    <tr>
      <th>Mã thuốc</th>
      <th>Tên thuốc</th>
      <th>Đơn giá</th>
      <th>Năm sản xuất</th>
      <th>Loại thuốc</th>
      <th>Chức năng</th>
    </tr>
    <c:forEach var="thuoc" items="${thuocList}">
      <tr>
        <td>${thuoc.maThuoc}</td>
        <td>${thuoc.tenThuoc}</td>
        <td>${thuoc.gia}</td>
        <td>${thuoc.namSX}</td>
        <td>${thuoc.loaiThuoc.tenLoai}</td>
        <td>
          <form action="thuoc" method="post">
            <input type="hidden" name="maThuoc" value="${thuoc.maThuoc}">
            <button type="submit" name="action" value="editThuoc" >EDIT</button>
          </form>
        </td>
      </tr>
    </c:forEach>
  </table>
</form>
</body>
</html>
