/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import BLL.BLLPhongKham;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pham
 */
public class DTOBenhNhan {
    String maBN;
    String hoten;
    String gioitinh;
    String ngaysinh;
    String CMND;
    String diachi;
    String dienthoai;
    int BHYT;
    Date ngayhethan;
    int vuottuyen;
    String maBH;
    String tiensusk;
    Date ngaydangky;
    DTOPhongKham dtoPhongKham;
    
    public DTOBenhNhan(){
        
    }

    public DTOBenhNhan(String maBN, String hoten, String gioitinh, String ngaysinh, String CMND, String diachi, String dienthoai, int BHYT, Date ngayhethan, int vuottuyen, String maBH, DTOPhongKham dtoPhongKham) {
        this.maBN = maBN;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.CMND = CMND;
        this.diachi = diachi;
        this.dienthoai = dienthoai;
        this.BHYT = BHYT;
        this.ngayhethan = ngayhethan;
        this.vuottuyen = vuottuyen;
        this.maBH = maBH;
        this.dtoPhongKham = dtoPhongKham;
    }

    
    public DTOBenhNhan(ResultSet rs) throws SQLException{
        this.maBN = rs.getString("mabn");
        this.hoten = rs.getString("hoten");
        this.gioitinh = rs.getString("gioitinh");
        this.ngaysinh = rs.getString("ngaysinh");
        this.CMND = rs.getString("cmnd");
        this.diachi = rs.getString("diachi");
        this.dienthoai = rs.getString("dienthoai");
        this.BHYT = rs.getInt("bhyt");
        this.ngayhethan = rs.getDate("ngayhethan");
        this.vuottuyen = rs.getInt("vuottuyen");
        this.maBH = rs.getString("mabh");
        this.tiensusk = rs.getString("tiensusk");
        this.ngaydangky = rs.getDate("ngaydangky");
        this.dtoPhongKham = (new BLLPhongKham()).layPhongKhamTheoMa(rs.getInt("mapk"));
    }

    public String getMaBN() {
        return maBN;
    }

    public void setMaBN(String maBN) {
        this.maBN = maBN;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getDienthoai() {
        return dienthoai;
    }

    public void setDienthoai(String dienthoai) {
        this.dienthoai = dienthoai;
    }

    public int getBHYT() {
        return BHYT;
    }

    public void setBHYT(int BHYT) {
        this.BHYT = BHYT;
    }

    public Date getNgayhethan() {
        return ngayhethan;
    }

    public void setNgayhethan(Date ngayhethan) {
        this.ngayhethan = ngayhethan;
    }

    public int getVuottuyen() {
        return vuottuyen;
    }

    public void setVuottuyen(int vuottuyen) {
        this.vuottuyen = vuottuyen;
    }

    public String getMaBH() {
        return maBH;
    }

    public void setMaBH(String maBH) {
        this.maBH = maBH;
    }

    public DTOPhongKham getDtoPhongKham() {
        return dtoPhongKham;
    }

    public void setDtoPhongKham(DTOPhongKham dtoPhongKham) {
        this.dtoPhongKham = dtoPhongKham;
    }

    public String getTiensusk() {
        return tiensusk;
    }

    public void setTiensusk(String tiensusk) {
        this.tiensusk = tiensusk;
    }

    public Date getNgaydangky() {
        return ngaydangky;
    }

    public void setNgaydangky(Date ngaydangky) {
        this.ngaydangky = ngaydangky;
    }
    
    
}
