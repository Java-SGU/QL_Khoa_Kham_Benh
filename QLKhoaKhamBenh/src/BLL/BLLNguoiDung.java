/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALNguoiDung;
import DTO.DTONguoiDung;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class BLLNguoiDung {
    DALNguoiDung dalNgDung = new DALNguoiDung();

    public BLLNguoiDung() {
    }
    
    public DTONguoiDung DangNhap(String tenDN, String mk){
        return dalNgDung.DangNhap(tenDN, mk);
    }
    
    public boolean ThemNguoiDung(DTONguoiDung dtoNgDung){
        return dalNgDung.ThemNgDung(dtoNgDung);
    }
    
    public DTONguoiDung LayNgDungTheoTen(String tendn){
        return dalNgDung.LayNgDungTheoTen(tendn);
    }
    
    public ArrayList<DTONguoiDung>  LayDSNguoiDung(){
        return dalNgDung.LayDSNguoiDung();
    }
    
    //lay nguoi dung theo ma
    public DTONguoiDung layNguoiDungTheoMa(int maND){
        return dalNgDung.layNguoiDungTheoMa(maND);
    }
    
    //xóa người dùng
    public boolean xoaNguoiDung(int maND){
        return dalNgDung.xoaNguoiDung(maND);
    }
    
    //sua mat khau
    public boolean DoiMatKhau(String tenDN, String matKhau, String matKhauMoi){
        return dalNgDung.DoiMatKhau(tenDN, matKhau, matKhauMoi);
    }
    
    public boolean SuaNguoiDung(DTONguoiDung dtoNgDung){
        return dalNgDung.SuaNguoiDung(dtoNgDung);
    }

    public Iterable<DTONguoiDung> LayNgDungTheoTen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<DTONguoiDung> TimNguoiDung(String tim){
        return dalNgDung.TimNguoiDung(tim);
    }
}
