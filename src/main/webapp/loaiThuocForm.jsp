<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
      <title>Thêm Loại Thuốc</title>
    </head>

    <body>
        <h2>Thêm loại thuốc mới</h2>
        <form action="loaiThuoc" method="post">
            <label for="loaiThuoc">Tên Loại: </label>
            <input type="text" id="loaiThuoc" name="loaiThuoc" required><br><br>
            <button type="submit" name="action" value="addLoaiThuoc">Thêm loại thuốc</button><br><br>
        </form>
        <form action="loaiThuoc" method="post">
            <button type="submit" name="action" value="loaiThuocList">Danh sách Loại Thuốc</button>
            <button type="submit" name="action" value="index">Trang chính</button>
        </form>
    </body>
</html>
