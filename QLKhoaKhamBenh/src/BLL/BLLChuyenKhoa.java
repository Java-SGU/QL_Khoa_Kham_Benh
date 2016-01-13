/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALChuyenKhoa;
import DTO.DTOChuyenKhoa;
import java.util.ArrayList;

/**
 *
 * @author Documents
 */
public class BLLChuyenKhoa {
    DALChuyenKhoa dalCK = new DALChuyenKhoa();

    public BLLChuyenKhoa() {
    }
    
    public DTOChuyenKhoa LayChuyenKhoaTheoTen(String tenck){
        return dalCK.LayChuyenKhoaTheoTen(tenck);
    }
    
    public DTOChuyenKhoa LayChuyenKhoaTheoMa(int maCK){
        return dalCK.LayChuyenKhoaTheoMa(maCK);
    }
    
    public ArrayList<DTOChuyenKhoa> layDSChuyenKhoa(){
        return dalCK.layDSChuyenKhoa();
    }
}
