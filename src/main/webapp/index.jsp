<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Trang Index</title>
        <style>
            body {
                width: 70%;
            }
            .btn-chucnang {
                padding: 10px;
                margin: 10px;
                width: 300px;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <h1>Chọn trang bạn muốn truy cập</h1>
        <form action="loaiThuoc" method="post">
            <button type="submit" name="action" value="loaiThuocList" class="btn-chucnang">Danh sách Loại Thuốc</button>
            <button type="submit" name="action" value="loaiThuocForm" class="btn-chucnang">Thêm mới Loại Thuốc</button>
            <button type="button" onclick="window.location.href='searchLoaiThuoc.jsp'" class="btn-chucnang">Tìm kiếm Loại Thuốc</button>
        </form>
        <form action="thuoc" method="post">
            <button type="submit" name="action" value="thuocList" class="btn-chucnang">Danh sách Thuốc</button>
            <button type="submit" name="action" value="thuocForm" class="btn-chucnang">Thêm mới Thuốc</button>
            <button type="submit" name="action" value="searchThuoc" class="btn-chucnang">Tìm kiếm Thuốc</button>
        </form>
    </body>
</html>
