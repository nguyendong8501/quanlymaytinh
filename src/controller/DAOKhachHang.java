/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.KhachHang;

import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Nguyen The Dong
 */
public class DAOKhachHang {
     private Connection conn;
    
    public DAOKhachHang() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.mariadb.jdbc.Driver");
            String dbURL = "jdbc:mariadb://localhost:3307/QLBanHang";
            conn = DriverManager.getConnection(dbURL, "root", "123456");

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addKhachHang(KhachHang s){
        String sql = "insert into KhachHang "
                + "(MaKH,TenKH,GioiTinh,Diachi,SoDT) "
                + "values ('"+s.getMakh()+"','"+s.getTenkh()+"','"+s.getGioitinh()+"','"+s.getDiachi()+"','"+s.getSdt()+"')";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
        public boolean deleteKhachHang(KhachHang s){
        String sql = "DELETE FROM KhachHang WHERE MaKH='"+s.getMakh()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
          public boolean updateKhachHang(KhachHang s){
        String sql = "UPDATE KhachHang SET TenKH = '"+s.getTenkh()+"',GioiTinh='"+s.getGioitinh()+"',"
                + "Diachi = '"+s.getDiachi()+"',SoDT='"+s.getSdt()+"' "
                + "WHERE MaKH='"+s.getMakh()+" '";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
             public ArrayList<KhachHang> getListKhachHang(){
        ArrayList<KhachHang> list = new ArrayList<>();
        String sql = "select * from KhachHang";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KhachHang s = new KhachHang();
                s.setMakh(rs.getString("MaKH"));
                s.setTenkh(rs.getString("TenKH"));
                s.setGioitinh(rs.getString("GioiTinh"));
                s.setDiachi(rs.getString("DiaChi"));
                s.setSdt(rs.getString("SoDT"));
                
                list.add(s);
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
      public static void main(String[] args){
        new DAOKhachHang();
    }       
}
