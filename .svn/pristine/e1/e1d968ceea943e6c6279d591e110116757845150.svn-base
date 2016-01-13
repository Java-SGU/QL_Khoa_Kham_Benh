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
 * @author Pham
 */
public class DTOPhongKham {
    int mapk;
    String tenpk;

    public DTOPhongKham() {
    }

    public DTOPhongKham(int mapk, String tenpk) {
        this.mapk = mapk;
        this.tenpk = tenpk;
    }

    public DTOPhongKham(ResultSet rs) throws SQLException{
        this.mapk = rs.getInt("mapk");
        this.tenpk = rs.getString("tenpk");
    }
    
    public int getMapk() {
        return mapk;
    }

    public void setMapk(int mapk) {
        this.mapk = mapk;
    }

    public String getTenpk() {
        return tenpk;
    }

    public void setTenpk(String tenpk) {
        this.tenpk = tenpk;
    }
    
    @Override
    public String toString(){
        return this.tenpk;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof DTOPhongKham){
            DTOPhongKham dtoPhong = (DTOPhongKham)obj;
            return dtoPhong.tenpk.equals(this.tenpk);
        }
        return false;
    }
}
