/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.NhanVien;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Nguyen The Dong
 */
public class DAO {

    private Connection conn;

    public DAO() {
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
//                                + "(MaNV) "
//                + "values (?);";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,s.getMaNV());
//            ps.setString(2,s.getTenNV());
//            ps.setString(3,s.getGioitinh());
//            ps.setString(4,s.getDiachi());
//            ps.setString(5,s.getSdt());
            
//            System.out.println(ps);
            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
      public boolean deleteNhanVien(NhanVien s){
        String sql = "DELETE FROM tblNhanVien WHERE MaNV='"+s.getMaNV()+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,s.getMaNV());
//            ps.setString(2,s.getTenNV());
//            ps.setString(3,s.getGioitinh());
//            ps.setString(4,s.getDiachi());
//            ps.setString(5,s.getSdt());
            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
       public boolean updateNhanVien(NhanVien s){
        String sql = "UPDATE tblNhanVien SET MaNV ='"+ s.getMaNV()+"',TenNV = '"+s.getTenNV()+"',Gioitinh='"+s.getGioitinh()+"',"
                + "Diachi = '"+s.getDiachi()+"',Sdt='"+s.getSdt()+"' "
                + "WHERE MaNV='"+s.getMaNV()+" '";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1,s.getMaNV());
//            ps.setString(2,s.getTenNV());
//            ps.setString(3,s.getGioitinh());
//            ps.setString(4,s.getDiachi());
//            ps.setString(5,s.getSdt());
            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
      
    public ArrayList<NhanVien> getListNhanVien(){
        ArrayList<NhanVien> list = new ArrayList<>();
        String sql = "select * from tblNhanVien";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhanVien s = new NhanVien();
                s.setMaNV(rs.getString("MaNV"));
                s.setTenNV(rs.getString("TenNV"));
                s.setGioitinh(rs.getString("Gioitinh"));
                s.setDiachi(rs.getString("Diachi"));
                s.setSdt(rs.getString("Sdt"));
                
                list.add(s);
            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    
    public static void main(String[] args){
        new DAO();
    }
}
