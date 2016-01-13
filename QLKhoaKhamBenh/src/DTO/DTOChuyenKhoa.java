/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DTO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Documents
 */
public class DTOChuyenKhoa {
    int maChuyenKhoa;
    String tenChuyenKhoa;

    public int getMaChuyenKhoa() {
        return maChuyenKhoa;
    }

    public void setMaChuyenKhoa(int maChuyenKhoa) {
        this.maChuyenKhoa = maChuyenKhoa;
    }

    public String getTenChuyenKhoa() {
        return tenChuyenKhoa;
    }

    public void setTenChuyenKhoa(String tenChuyenKhoa) {
        this.tenChuyenKhoa = tenChuyenKhoa;
    }

    public DTOChuyenKhoa() {
    }

    public DTOChuyenKhoa(int maChuyenKhoa, String tenChuyenKhoa) {
        this.maChuyenKhoa = maChuyenKhoa;
        this.tenChuyenKhoa = tenChuyenKhoa;
    }
    
    public DTOChuyenKhoa(ResultSet rs) throws SQLException{
        this.maChuyenKhoa = rs.getInt("mack");
        this.tenChuyenKhoa = rs.getString("tenck");
    }
    
    @Override
    public String toString(){
        return this.tenChuyenKhoa;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof DTOChuyenKhoa){
            DTOChuyenKhoa dtoCK = (DTOChuyenKhoa)obj;
            return dtoCK.tenChuyenKhoa.equals(this.tenChuyenKhoa);
        }
        return false;
    }
}