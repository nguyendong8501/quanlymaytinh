/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.NhaCungCap;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author Nguyen The Dong
 */
public class DAONhaCungCap {
    private Connection conn;

    public DAONhaCungCap() {
        try {
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("org.mariadb.jdbc.Driver");
            String dbURL = "jdbc:mariadb://localhost:3307/QLBanHang";
            conn = DriverManager.getConnection(dbURL, "root", "123456");
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public boolean addNhaCungCap(NhaCungCap s){
        String sql = "insert into NhaCungCap "
                + "(MaNCC,TenNCC,Diachi,Sdt) "
                + "values ('"+s.getMancc()+"','"+s.getTenncc()+"','"+s.getDiachi()+"','"+s.getSdt()+"')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            
            return ps.executeUpdate(sql)>0;
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean deleteNhaCungCap(NhaCungCap s){
        String sql = "DELETE FROM NhaCungCap WHERE MaNCC='"+s.getMancc()+"'";
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
      public boolean updateNhaCungCap(NhaCungCap s){
        String sql = "UPDATE NhaCungCap SET MaNCC ='"+ s.getMancc()+"',TenNCC = '"+s.getTenncc()+"',"
                + "Diachi = '"+s.getDiachi()+"',Sdt='"+s.getSdt()+"' "
                + "WHERE MaNV='"+s.getMancc()+" '";
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
     public ArrayList<NhaCungCap> getListNhaCungCap(){
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String sql = "select * from NhaCungCap";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                NhaCungCap s = new NhaCungCap();
                s.setMancc(rs.getString("MaNCC"));
                s.setTenncc(rs.getString("TenNCC"));
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
        new DAONhaCungCap();
    }
}
