/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALChucVu;
import DTO.DTOChucVu;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class BLLChucVu {
    DALChucVu dalChucVu = new DALChucVu();

    public BLLChucVu() {
    }
    
    public DTOChucVu LayChucVuTheoTen(String tencv){
        return dalChucVu.LayChucVuTheoTen(tencv);
    }
    
    public DTOChucVu LayChucVuTheoMa(int maCV){
        return dalChucVu.LayChucVuTheoMa(maCV);
    }
    
    public ArrayList<DTOChucVu> layDSChucVu(){
        return dalChucVu.layDSChucVu();
    }
    
    public ArrayList<DTOChucVu> layDSChucVuTheoDK(int dk){
        return dalChucVu.layDSChucVuTheoDK(dk);
    }
}