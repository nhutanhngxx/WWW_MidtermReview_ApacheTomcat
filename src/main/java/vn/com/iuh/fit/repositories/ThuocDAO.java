package vn.com.iuh.fit.repositories;

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
    public List<Thuoc> getThuocByName(String tenThuoc) {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT t.maThuoc, t.tenThuoc, t.gia, t.namSX, l.maLoai AS loaiThuocId, l.loaiThuoc AS tenLoaiThuoc FROM tenthuoc t " +
                "JOIN loaithuoc l ON t.maLoai = l.maLoai WHERE t.tenThuoc LIKE ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + tenThuoc + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
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
    public void updateThuoc(Thuoc thuoc) {
        String sql = "UPDATE tenthuoc SET tenThuoc = ?, gia = ?, namSX = ?, maLoai = ? WHERE maThuoc = ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, thuoc.getTenThuoc());
            preparedStatement.setDouble(2, thuoc.getGia());
            preparedStatement.setInt(3, thuoc.getNamSX());
            preparedStatement.setInt(4, thuoc.getLoaiThuoc().getMaLoai());
            preparedStatement.setInt(5, thuoc.getMaThuoc());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Thuoc getThuocById(int maThuoc) {
        Thuoc thuoc = new Thuoc();
        String sql = "SELECT t.maThuoc, t.tenThuoc, t.gia, t.namSX, l.maLoai AS loaiThuocId, l.loaiThuoc AS tenLoaiThuoc FROM tenthuoc t " +
                "JOIN loaithuoc l ON t.maLoai = l.maLoai WHERE t.maThuoc = ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maThuoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                thuoc.setMaThuoc(resultSet.getInt("maThuoc"));
                thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
                thuoc.setGia(resultSet.getDouble("gia"));
                thuoc.setNamSX(resultSet.getInt("namSX"));
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setMaLoai(resultSet.getInt("loaiThuocId"));
                loaiThuoc.setTenLoai(resultSet.getString("tenLoaiThuoc"));
                thuoc.setLoaiThuoc(loaiThuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thuoc;
    }
    public List<Thuoc> getThuocbyLoaiThuoc(int maLoaiThuoc) {
        List<Thuoc> list = new ArrayList<>();
        String sql = "SELECT t.maThuoc, t.tenThuoc, t.gia, t.namSX, l.maLoai AS loaiThuocId, l.loaiThuoc AS tenLoaiThuoc " +
                "FROM tenthuoc t " +
                "JOIN loaithuoc l ON t.maLoai = l.maLoai " +
                "WHERE l.maLoai LIKE ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, maLoaiThuoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Thuoc thuoc = new Thuoc();
                thuoc.setMaThuoc(resultSet.getInt("maThuoc"));
                thuoc.setTenThuoc(resultSet.getString("tenThuoc"));
                thuoc.setGia(resultSet.getDouble("gia"));
                thuoc.setNamSX(resultSet.getInt("namSX"));
                LoaiThuoc loaiThuoc1 = new LoaiThuoc();
                loaiThuoc1.setMaLoai(resultSet.getInt("loaiThuocId"));
                loaiThuoc1.setTenLoai(resultSet.getString("tenLoaiThuoc"));
                thuoc.setLoaiThuoc(loaiThuoc1);
                list.add(thuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        ThuocDAO thuocDAO = new ThuocDAO();
        Thuoc thuoc = thuocDAO.getThuocById(1);
        System.out.println(thuoc);
        thuoc.setNamSX(2003);
        System.out.printf("Update thuoc: %s\n", thuoc);
        thuocDAO.updateThuoc(thuoc);

//        thuocDAO.getThuocbyLoaiThuoc("Thuoc khang sinh").forEach(System.out::println);
//        thuocDAO.getThuocByName("Pa").forEach(System.out::println);
//        thuocDAO.getAllThuoc().forEach(System.out::println);
    }
}
