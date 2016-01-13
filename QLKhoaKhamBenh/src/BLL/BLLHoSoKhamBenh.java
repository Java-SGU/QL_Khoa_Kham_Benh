/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALHoSoKhamBenh;
import DTO.DTOHoSoKhamBenh;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class BLLHoSoKhamBenh {
    DALHoSoKhamBenh dalHS = new DALHoSoKhamBenh();

    public BLLHoSoKhamBenh() {
    }
    
    public ArrayList<DTOHoSoKhamBenh> LayDSHoSo(){
        return dalHS.LayDSHoSo();
    }
    
    public ArrayList<DTOHoSoKhamBenh> LayHSTheoMaBN(String maBN){
        return dalHS.LayHoSoTheoMaBN(maBN);
    }
    
    public ArrayList<DTOHoSoKhamBenh> TimHoSo(int tim){
        return dalHS.TimHoSo(tim);
    }
    
    public boolean XoaHoSo(int maHS){
        return dalHS.XoaHoSo(maHS);
    }

    public DTOHoSoKhamBenh LayHSTheoMa(int maHS) {
       return  dalHS.LayHoSoTheoMa(maHS);
    }
}
