/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import DTO.DTOChuyenKhoa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class DALChuyenKhoa {
    DALConnectionBD cnt = new DALConnectionBD();

    public DALChuyenKhoa() {
    }
    
    public DTOChuyenKhoa LayChuyenKhoaTheoTen(String tenCK){
         try {
            cnt.getConnectionBD();
            DTOChuyenKhoa dtoCK = null;
            String sql = "SELECT * FROM chuyenkhoa WHERE tenck = ?";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setString(1, tenCK);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                dtoCK = new DTOChuyenKhoa(rs);
            }
            
            return dtoCK;
        } 
        catch (SQLException ex) {
            System.err.print("Lấy dữ liệu bị lỗi");
            return null;
        } 
        finally{
            cnt.closeCnt();
        }
    }
    
    public DTOChuyenKhoa LayChuyenKhoaTheoMa(int maCK){
         try {
            cnt.getConnectionBD();
            DTOChuyenKhoa dtoCK = null;
            String sql = "SELECT * FROM chuyenkhoa WHERE mack = ?";
            PreparedStatement stmt = cnt.getCnt().prepareStatement(sql);
            stmt.setInt(1, maCK);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                dtoCK = new DTOChuyenKhoa(rs);
            }
            
            return dtoCK;
        } 
        catch (SQLException ex) {
            System.err.print("Lấy dữ liệu bị lỗi");
            return null;
        } 
        finally{
            cnt.closeCnt();
        }
    }
    
    //lay tat ca chuyen khoa
    public ArrayList<DTOChuyenKhoa> layDSChuyenKhoa(){
        ArrayList<DTOChuyenKhoa> dsChucVu = new ArrayList<>();
        try {
            cnt.getConnectionBD();
            String sql = "SELECT * FROM chuyenkhoa";
            PreparedStatement pre = cnt.getCnt().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while(rs.next()){
                dsChucVu.add(new DTOChuyenKhoa(rs));
            }
            
            
        } catch (SQLException e) {
            System.err.print(e.getMessage());
            System.err.print("Lấy ds chuyen khoa bị lỗi");
        }
        finally{
            cnt.closeCnt();
        }
        return dsChucVu;
    }
}
