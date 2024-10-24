package vn.com.iuh.fit.dao;

import vn.com.iuh.fit.models.LoaiThuoc;
import vn.com.iuh.fit.utils.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiThuocDAO {
    public List<LoaiThuoc> getAllLoaiThuoc() {
        List<LoaiThuoc> list = new ArrayList<>();
        String sql = "SELECT * FROM loaithuoc";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setMaLoai(resultSet.getInt("maLoai"));
                loaiThuoc.setTenLoai(resultSet.getString("loaiThuoc"));
                list.add(loaiThuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean isLoaiThuocExists(String tenLoai) {
        String sql = "SELECT COUNT(*) FROM loaithuoc WHERE loaiThuoc = ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1, tenLoai);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean addLoaiThuoc(LoaiThuoc loaiThuoc) {
        if (isLoaiThuocExists(loaiThuoc.getTenLoai())) {
            System.out.println("Loại thuốc đã tồn tại!!");
            return false;
        }
        String sql = "INSERT INTO loaithuoc (maLoai, loaiThuoc) VALUES (?, ?)";
        try (Connection connection = ConnectDatabase.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, loaiThuoc.getMaLoai());
            preparedStatement.setString(2, loaiThuoc.getTenLoai());
            int rowsInserted = preparedStatement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<LoaiThuoc> searchLoaiThuoc(String tenLoaiThuoc) {
        List<LoaiThuoc> list = new ArrayList<>();
        String sql = "SELECT * FROM loaithuoc WHERE loaiThuoc LIKE ?";
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, "%" + tenLoaiThuoc + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LoaiThuoc loaiThuoc = new LoaiThuoc();
                loaiThuoc.setMaLoai(resultSet.getInt("maLoai"));
                loaiThuoc.setTenLoai(resultSet.getString("loaiThuoc"));
                list.add(loaiThuoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        LoaiThuocDAO loaiThuocDAO = new LoaiThuocDAO();
//        loaiThuocDAO.searchLoaiThuoc("an than").forEach(System.out::println);
//        LoaiThuoc loaiThuoc = new LoaiThuoc(4, "Thuoc tri tam than");
//        System.out.println(loaiThuocDAO.addLoaiThuoc(loaiThuoc));
//        System.out.println(loaiThuocDAO.isLoaiThuocExists("Thuoc giam dau"));
//        List<LoaiThuoc> loaiThuocs = loaiThuocDAO.getAllLoaiThuoc();
//        for (LoaiThuoc loaiThuoc : loaiThuocs) {
//            System.out.println(loaiThuoc);
//        }
    }
}
