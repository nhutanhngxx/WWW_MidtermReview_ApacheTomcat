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
<c:if test="${thuocID != null}">
    <h2>Cập nhật thông tin Thuốc</h2>
    <form action="thuoc" method="post">
        <input type="hidden" name="maThuoc" value="${thuocID}">
        <label for="tenThuoc">Tên thuốc</label>
        <input type="text" name="tenThuoc" value="${thuoc.tenThuoc}" required>
        <br><br>
        <label for="gia">Đơn giá</label>
        <input type="text" name="gia" value="${thuoc.gia}" required>
        <br><br>
        <label for="namSX">Năm sản xuất</label>
        <input type="text" name="namSX" value="${thuoc.namSX}" required>
        <br><br>
        <label for="loaiThuoc">Loại Thuốc: </label>
        <select name="loaiThuoc" required>
            <option value="">Chọn loại thuốc</option>
            <c:forEach var="loaiThuoc" items="${loaiThuocList}">
                <option value="${thuoc.loaiThuoc.maLoai}"
                        <c:if test="${loaiThuoc.maLoai == thuoc.loaiThuoc.maLoai}">
                            selected="selected"
                        </c:if>>${loaiThuoc.tenLoai}</option>
            </c:forEach>
        </select><br><br>
        <button type="submit" name="action" value="updateThuoc">Cập nhật</button>
    </form>
</c:if>
<c:if test="${thuocID == null}">
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
    </form>
</c:if>
</body>
</html>
