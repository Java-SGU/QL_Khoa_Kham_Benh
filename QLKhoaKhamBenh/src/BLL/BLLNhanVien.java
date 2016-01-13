/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALNhanVien;
import DTO.DTONhanVien;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class BLLNhanVien {
    DALNhanVien dalNhanvien = new DALNhanVien();
    
    public  BLLNhanVien(){
        
    }
    
    public DTONhanVien layNhanVienTheoMa(int manv){
        return dalNhanvien.LayNVTheoMa(manv);
    }
    
    public ArrayList<DTONhanVien> dsNhanVien(){
        return dalNhanvien.LayDSNhanVien();
    }
    
    public boolean ThemNhanVien(DTONhanVien dtoNV){
        return dalNhanvien.ThemNhanVien(dtoNV);
    }
    
    //lay toan bo nhan vien
    public ArrayList<DTONhanVien> LayToanBoNhanVien(){
        return dalNhanvien.LayToanBoNhanVien();
    }
    
    //cap nhat thong tin nhan vien
    public boolean capNhatNhanVien(DTONhanVien dtoNV){
        return dalNhanvien.capNhatNhanVien(dtoNV);
    }
    
    //tim nhan vien
    public ArrayList<DTONhanVien> timNhanVien(String tim){
        return dalNhanvien.timNhanVien(tim);
    }
    
    //xoa thong tin nhan vien
    public boolean xoaNhanVien(int maNV){
        return dalNhanvien.xoaNhanVien(maNV);
    }
    
    //tìm trưởng khoa trong danh sách nhân viên
    public DTONhanVien timTruongKhoa(String dk){
        return dalNhanvien.timTruongKhoa(dk);
    }
}
