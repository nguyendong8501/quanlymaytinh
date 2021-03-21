/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.NhanVien;
import java.sql.*;

/**
 *
 * @author Nguyen The Dong
 */
public class DAONguoiDung {
    private Connection conn;
    
    public DAONguoiDung() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.mariadb.jdbc.Driver");
            String dbURL = "jdbc:mariadb://localhost:3307/QLBanHang";
            conn = DriverManager.getConnection(dbURL, "root", "123456");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addNhanVien(NhanVien s){
        String sql = "insert into tblNhanVien "
                + "(MaNV,TenNV,GioiTinh,Diachi,Sdt) "
                + "values ('"+s.getMaNV()+"','"+s.getTenNV()+"','"+s.getGioitinh()+"','"+s.getDiachi()+"','"+s.getSdt()+"')";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
