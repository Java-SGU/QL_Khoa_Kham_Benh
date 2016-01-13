/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import BLL.BLLChucVu;
import BLL.BLLChuyenKhoa;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Documents
 */
public class DTONhanVien {
    int maNV;
    String hoTen;
    String gioiTinh;
    Date ngaySinh;
    String cmnd;
    String diaChi;
    String dienThoai;
    String hocVi;
    DTOChuyenKhoa dtoCK;
    DTOChucVu dtoCV;

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public String getHocVi() {
        return hocVi;
    }

    public void setHocVi(String hocVi) {
        this.hocVi = hocVi;
    }

    public DTOChuyenKhoa getDtoCK() {
        return dtoCK;
    }

    public void setDtoCK(DTOChuyenKhoa dtoCK) {
        this.dtoCK = dtoCK;
    }

    public DTOChucVu getDtoCV() {
        return dtoCV;
    }

    public void setDtoCV(DTOChucVu dtoCV) {
        this.dtoCV = dtoCV;
    }
  
  
    
  public DTONhanVien (){
      
  }

    public DTONhanVien(int maNV, String hoTen, String gioiTinh, Date ngaySinh, String cmnd, String diaChi, 
                        String dienThoai, String hocVi, DTOChuyenKhoa dtoCK, DTOChucVu dtoCV) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
        this.hocVi = hocVi;
        this.dtoCK = dtoCK;
        this.dtoCV = dtoCV;
    }

    public DTONhanVien(ResultSet rs) throws SQLException {
        this.maNV = rs.getInt("manv");
        this.hoTen = rs.getString("hoten");
        this.gioiTinh = rs.getString("gioitinh");
        this.ngaySinh = rs.getDate("ngaysinh");
        this.cmnd = rs.getString("cmnd");
        this.diaChi = rs.getString("diachi");
        this.dienThoai = rs.getString("dienthoai");
        this.hocVi = rs.getString("hocvi");
        int maCK = rs.getInt("mack");
        BLLChuyenKhoa bllCK = new BLLChuyenKhoa();
        this.dtoCK = bllCK.LayChuyenKhoaTheoMa(maCK);
        int maCV = rs.getInt("macv");
        BLLChucVu bllCV = new BLLChucVu();
        this.dtoCV = bllCV.LayChucVuTheoMa(maCV);
    }

  
  
  @Override
  public String toString(){
      return this.hoTen;
  }
  
    @Override
  public boolean equals(Object obj){
      if(obj instanceof DTONhanVien){
          DTONhanVien dtoNV = (DTONhanVien)obj;
          return dtoNV.hoTen.equals(this.hoTen);
      }
      return false;
  }
}
