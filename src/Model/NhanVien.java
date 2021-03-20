/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nguyen The Dong
 */
public class NhanVien {
    String manv;
    String tennv;
    String gioitinh;
    String diachi;   
    String sdt;

    public NhanVien(String manv, String tennv, String gioitinh, String diachi, String sdt) {
        this.manv = manv;
        this.tennv = tennv;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    public NhanVien() {
    }

   

    public String getMaNV() {
        return manv;
    }

    public void setMaNV(String manv) {
        this.manv = manv;
    }

    public String getTenNV() {
        return tennv;
    }

    public void setTenNV(String tennv) {
        this.tennv = tennv;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}
