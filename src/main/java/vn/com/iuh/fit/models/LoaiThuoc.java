package vn.com.iuh.fit.models;

public class LoaiThuoc {

    private int maLoai;
    private String tenLoai;

    public int getMaLoai() {
        return maLoai;
    }
    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }
    public String getTenLoai() {
        return tenLoai;
    }
    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public LoaiThuoc() {
    }
    public LoaiThuoc(String tenLoai) {
        this.tenLoai = tenLoai;
    }
    public LoaiThuoc(int maLoai) {
        this.maLoai = maLoai;
    }
    public LoaiThuoc(int maLoai, String tenLoai) {
        this.maLoai = maLoai;
        this.tenLoai = tenLoai;
    }

    @Override
    public String toString() {
        return "LoaiThuoc{" +
                "maLoai=" + maLoai +
                ", tenLoai='" + tenLoai + '\'' +
                '}';
    }
}
