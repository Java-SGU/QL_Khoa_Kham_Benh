/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.DTONguoiDung;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class DALNguoiDung {
    DALConnectionBD cnt = new DALConnectionBD();

    public DALNguoiDung() {
    }
    
    //đăng nhập
    public DTONguoiDung DangNhap(String tenDN, String mk){
        try {
            cnt.getConnectionBD();
            DTONguoiDung dtoNgDung = null;
            String sql = "SELECT * FROM nguoidung WHERE tendangnhap = ? AND matkhau = ?";
            PreparedStatement pr = cnt.getCnt().prepareStatement(sql);
            pr.setString(1, tenDN);
            pr.setString(2, mk);
            ResultSet rs = pr.executeQuery();
            while(rs.next()){
                dtoNgDung = new DTONguoiDung(rs);
            }
            return dtoNgDung;
        } 
        catch (Exception e) {
            System.err.println("Lỗi đăng nhập");
            return null;
        }
        finally{
            cnt.closeCnt();
        }
    }
    
    //thêm mới người dùng
    public boolean ThemNgDung(DTONguoiDung dtoNgDung){
        try {
            cnt.getConnectionBD();
            String sql = "INSERT INTO nguoidung(tendangnhap, matkhau, manv, email) VALUES(?, ?, ?, ?)";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setString(1, dtoNgDung.getTenDN());
            stmt.setString(2, dtoNgDung.getMatKhau());
            stmt.setInt(3, dtoNgDung.getDtoNV().getMaNV());
            stmt.setString(4, dtoNgDung.getEmail());
            stmt.executeUpdate();
            return true;
        } 
        catch (Exception e) {
        }
        finally{
            cnt.closeCnt();
        }
        return false;
    }
    
    //lấy thông tin người dùng theo tên
    public DTONguoiDung LayNgDungTheoTen(String ten){
        try {
            cnt.getConnectionBD();
            DTONguoiDung dtoNgDung = null;
            String sql = "SELECT * FROM nguoidung WHERE tendangnhap = ?";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setString(1, ten);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                dtoNgDung = new DTONguoiDung(rs);
            }
            return dtoNgDung;
        } 
        catch (SQLException ex) {
            System.err.print("Lấy dữ liệu bị lỗi");
            return null;
        } 
        finally{
            cnt.closeCnt();
        }
    }
    
    //dua du lieu vao bang
    public ArrayList<DTONguoiDung> LayDSNguoiDung(){
        try {
//            modelNgDung = new DefaultTableModel();
//            String muc[] = {"ID", "Tên đăng nhập", "Mã nhân viên", "Email"};
//            modelNgDung.setColumnIdentifiers(muc);
//            for(DTONguoiDung dtoNgDung : bllN)
            cnt.getConnectionBD();
            ArrayList<DTONguoiDung> dsNgDung = new ArrayList<>();
            String sql = "SELECT * FROM nguoidung";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next())
            {
                dsNgDung.add(new DTONguoiDung(rs));
            }
            return dsNgDung;
        } 
        catch (Exception e) {
            System.err.print("Lấy dữ liệu bị lỗi");
            return null;
        }
        finally{
            cnt.closeCnt();
        }
   }
    
    //lay nguoi dung theo ma
    public DTONguoiDung layNguoiDungTheoMa(int maND){
        DTONguoiDung dtoNgDung = null;
        try {
            cnt.getConnectionBD();
            String sql = "SELECT * FROM nguoidung WHERE id = ?";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setInt(1, maND);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                dtoNgDung = new DTONguoiDung(rs);
            }
        } catch (Exception e) {
            System.err.print("Loi lay nguoi dung theo ma");
        }
        finally{
            cnt.closeCnt();
        }
        return dtoNgDung;
    }
    
    //xóa người dùng
    public boolean xoaNguoiDung(int maND){
        try{
            cnt.getConnectionBD();
            String sql = "DELETE FROM nguoidung WHERE id = ?";
            PreparedStatement pstmt = cnt.getCnt().prepareStatement(sql);
            pstmt.setInt(1, maND);
            pstmt.executeUpdate();
            return true;
        }
        catch(Exception e){
            System.err.print(e.getMessage());
        }
        finally{
            cnt.closeCnt();
        }
        return false;
    }
    
    //đổi mật khẩu
    public boolean DoiMatKhau(String tenDN, String matKhau, String matKhauMoi){
       
        try {
            DTONguoiDung dtoNgDung = DangNhap(tenDN, matKhau);
            if(dtoNgDung == null)
            {
                return false;
            }
            else
            {
                cnt.getConnectionBD();
                String sql = "UPDATE nguoidung SET matkhau = ? WHERE tendangnhap = ?";
                PreparedStatement pre = cnt.getCnt().prepareStatement(sql);
                pre.setString(1, matKhauMoi);
                pre.setString(2, tenDN);
                return pre.executeUpdate() == 1;
            }
        } 
        catch (Exception e) {
            System.err.printf(e.getMessage());
            return false;
        }
        finally{
            cnt.closeCnt();
        }
    }
    
    //sửa người dùng
    public boolean SuaNguoiDung(DTONguoiDung dtoNgDung){
         try {
            cnt.getConnectionBD();
            String sql = "UPDATE nguoidung SET matkhau=?, email=? WHERE tendangnhap = ? ";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setString(1, dtoNgDung.getMatKhau());
            stmt.setString(2, dtoNgDung.getEmail());
            stmt.setString(3, dtoNgDung.getTenDN());
            stmt.executeUpdate();
            return true;
        } 
        catch (Exception e) {
            System.err.print(e.getMessage());
        }
        finally{
            cnt.closeCnt();
        }
        return false;
    }
    
    //tim theo ten dang nhap
    public ArrayList<DTONguoiDung> TimNguoiDung(String tim){
        ArrayList<DTONguoiDung> dsNgDung = new ArrayList<>();
        try {
            cnt.getConnectionBD();
            String sql = "SELECT * FROM nguoidung WHERE tendangnhap like ?";
            PreparedStatement pstmt = cnt.getCnt().prepareStatement(sql);
            pstmt.setString(1, "%" + tim + "%");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                dsNgDung.add(new DTONguoiDung(rs));
            } 
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        finally{
            cnt.closeCnt();
        }
        return dsNgDung;
    }
}