package vn.com.iuh.fit.models;

public class Thuoc {

    private int maThuoc;
    private String tenThuoc;
    private double gia;
    private int namSX;
    private LoaiThuoc loaiThuoc;

    public int getMaThuoc() {
        return maThuoc;
    }
    public void setMaThuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }
    public String getTenThuoc() {
        return tenThuoc;
    }
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }
    public double getGia() {
        return gia;
    }
    public void setGia(double gia) {
        this.gia = gia;
    }
    public int getNamSX() {
        return namSX;
    }
    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }
    public LoaiThuoc getLoaiThuoc() {
        return loaiThuoc;
    }
    public void setLoaiThuoc(LoaiThuoc loaiThuoc) {
        this.loaiThuoc = loaiThuoc;
    }

    public Thuoc() {
    }
    public Thuoc(int maThuoc) {
        this.maThuoc = maThuoc;
    }
    public Thuoc(int maThuoc, String tenThuoc, double gia, int namSX, LoaiThuoc loaiThuoc) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.gia = gia;
        this.namSX = namSX;
        this.loaiThuoc = loaiThuoc;
    }

    @Override
    public String toString() {
        return "Thuoc{" +
                "maThuoc=" + maThuoc +
                ", tenThuoc='" + tenThuoc + '\'' +
                ", gia=" + gia +
                ", namSX=" + namSX +
//                ", loaiThuoc=" + loaiThuoc.getMaLoai() +
                ", loaiThuoc=" + loaiThuoc.getTenLoai() +
                '}';
    }
}
