package vn.com.iuh.fit.dao;

import vn.com.iuh.fit.models.LoaiThuoc;
import vn.com.iuh.fit.models.Thuoc;
import vn.com.iuh.fit.utils.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ThuocDAO {
    public List<Thuoc> getAllThuoc() {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT t.maThuoc, t.tenThuoc, t.gia, t.namSX, l.maLoai AS loaiThuocId, l.loaiThuoc AS tenLoaiThuoc FROM tenthuoc t " +
                     "JOIN loaithuoc l ON t.maLoai = l.maLoai";
        try(Connection connection = ConnectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(resultSet.getInt("maThuoc"));
                thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
                thuoc.setGia(resultSet.getDouble("gia"));
                thuoc.setNamSX(resultSet.getInt("namSX"));
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setMaLoai(resultSet.getInt("loaiThuocId"));
                loaiThuoc.setTenLoai(resultSet.getString("tenLoaiThuoc"));
                thuoc.setLoaiThuoc(loaiThuoc);
                list.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void addThuoc(Thuoc thuoc) {
        String sql = "INSERT INTO tenthuoc(tenThuoc, gia, namSX, maLoai) VALUES (?, ?, ?, ?)";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, thuoc.getTenThuoc());
            preparedStatement.setDouble(2, thuoc.getGia());
            preparedStatement.setInt(3, thuoc.getNamSX());
            preparedStatement.setInt(4, thuoc.getLoaiThuoc().getMaLoai());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThuocDAO thuocDAO = new ThuocDAO();
        thuocDAO.getAllThuoc().forEach(System.out::println);
    }
}
