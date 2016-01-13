/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import BLL.BLLBenhNhan;
import BLL.BLLPhongKham;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Documents
 */
public class DTOHoSoKhamBenh {
    int maHS;
    DTOBenhNhan dtoBN;
    Date ngayKham;
    DTOPhongKham dtoPK;
    String bacSi;
    String chanDoan;
    Date ngayTaiKham;

    public int getMaHS() {
        return maHS;
    }

    public void setMaHS(int maHS) {
        this.maHS = maHS;
    }

    public DTOBenhNhan getDtoBN() {
        return dtoBN;
    }

    public void setDtoBN(DTOBenhNhan dtoBN) {
        this.dtoBN = dtoBN;
    }

    public Date getNgayKham() {
        return ngayKham;
    }

    public void setNgayKham(Date ngayKham) {
        this.ngayKham = ngayKham;
    }

    public DTOPhongKham getDtoPK() {
        return dtoPK;
    }

    public void setDtoPK(DTOPhongKham dtoPK) {
        this.dtoPK = dtoPK;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }

    public String getChanDoan() {
        return chanDoan;
    }

    public void setChanDoan(String chanDoan) {
        this.chanDoan = chanDoan;
    }

    public Date getNgayTaiKham() {
        return ngayTaiKham;
    }

    public void setNgayTaiKham(Date ngayTaiKham) {
        this.ngayTaiKham = ngayTaiKham;
    }

    
    
    public DTOHoSoKhamBenh() {
    }

    public DTOHoSoKhamBenh(int maHS, DTOBenhNhan dtoBN, Date ngayKham, DTOPhongKham dtoPK, String bacSi, String chanDoan, Date ngayTaiKham) {
        this.maHS = maHS;
        this.dtoBN = dtoBN;
        this.ngayKham = ngayKham;
        this.dtoPK = dtoPK;
        this.bacSi = bacSi;
        this.chanDoan = chanDoan;
        this.ngayTaiKham = ngayTaiKham;
    }
    
    public DTOHoSoKhamBenh(ResultSet rs) throws SQLException{
        this.maHS = rs.getInt("maba");
        this.dtoBN = (new BLLBenhNhan()).layBNTheoMa(rs.getString("mabn"));
        this.ngayKham = rs.getDate("ngaykham");
        this.dtoPK = (new BLLPhongKham()).layPhongKhamTheoMa(rs.getInt("mapk"));
        this.bacSi = rs.getString("bacsi");
        this.chanDoan = rs.getString("chandoan");
        this.ngayTaiKham = rs.getDate("ngaytaikham");
    }
}
