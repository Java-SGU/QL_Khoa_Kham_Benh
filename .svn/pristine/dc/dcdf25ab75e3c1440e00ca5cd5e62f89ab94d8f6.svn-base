/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import BLL.BLLNhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Documents
 */
public class DTONguoiDung {
    int iD;
    String tenDN;
    String matKhau;
    String email;
    DTONhanVien dtoNV;

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DTONhanVien getDtoNV() {
        return dtoNV;
    }

    public void setDtoNV(DTONhanVien dtoNV) {
        this.dtoNV = dtoNV;
    }

    public DTONguoiDung() {
    }

    public DTONguoiDung(int iD, String tenDN, String matKhau, String email, DTONhanVien dtoNV) {
        this.iD = iD;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.email = email;
        this.dtoNV = dtoNV;
    }
    
    public DTONguoiDung(ResultSet rs) throws SQLException{
        this.iD = rs.getInt("id");
        this.tenDN = rs.getString("tendangnhap");
        this.matKhau = rs.getString("matkhau");
        this.email = rs.getString("email");
        int manv = rs.getInt("manv");
        BLLNhanVien bllNV = new BLLNhanVien();
        this.dtoNV = bllNV.layNhanVienTheoMa(manv);
    }
}
