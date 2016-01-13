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
public class DTOChucVu {
    int maChucVu;
    String tenChucVu;

    public int getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(int maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public DTOChucVu() {
    }
    
    public DTOChucVu(int maChucVu, String tenChucVu) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
    }

    public DTOChucVu(ResultSet rs) throws SQLException {
        this.maChucVu = rs.getInt("macv");
        this.tenChucVu = rs.getString("tencv");
    }
    
    @Override
    public String toString(){
        return this.tenChucVu;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof DTOChucVu){
            DTOChucVu dtoCV = (DTOChucVu)obj;
            return dtoCV.tenChucVu.equals(this.tenChucVu);
        }
        return false;
    }
}
