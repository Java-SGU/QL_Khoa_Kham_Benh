/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BLL;

import DAL.DALBenhNhan;
import DTO.DTOBenhNhan;
import java.util.ArrayList;

/**
 *
 * @author Pham
 */
public class BLLBenhNhan {
    DALBenhNhan dalBenhNhan = new DALBenhNhan();
    
    //ham khoi tao
    public BLLBenhNhan(){
        
    }
    
    //them moi benh nhan
    public boolean nhapBenhNhan(DTOBenhNhan dtoBenhNhan){
        return dalBenhNhan.themBenhNhan(dtoBenhNhan);
    }
    
    //lay danh sach benh nhan
    public ArrayList<DTOBenhNhan> layDSBenhNhan(){
        return dalBenhNhan.layDSBenhNhan();
    }
    
    //lay benh nhan theo ma
    public DTOBenhNhan layBNTheoMa(String maBN){
        return dalBenhNhan.layBenhNhanTheoMa(maBN);
    }
    
    //tim benh nhan
    public ArrayList<DTOBenhNhan> timBenhNhan(String tim){
        return dalBenhNhan.timBenhNhan(tim);
    }
    
    //cap nhat thong tin benh nhan
    public boolean capnhatThongTinBenhNhan(DTOBenhNhan dtoBenhNhan){
        return dalBenhNhan.capnhatBenhNhan(dtoBenhNhan);
    }
    
    //xoa benh nhan
    public boolean xoaBenhNhan(String maBN){
        return dalBenhNhan.xoaBenhNhan(maBN);
    }
    
    //thống kê
    public ArrayList<DTOBenhNhan> thongkeBenhNhan(DTOBenhNhan dtoBenhNhan){
        return dalBenhNhan.thongkeBenhNhan(dtoBenhNhan);
    }
}
