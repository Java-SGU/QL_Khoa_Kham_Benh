/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 *
 * @author Documents
 */
final class DALConnectionBD {
    Statement stmt;
    Connection cnt;
    ResultSet rs;
    String tendangnhap = "root", mk = "",
            host = "localhost", csdl = "khoakhambenh", dbms = "mysql";

    public Connection getCnt() {
        return cnt;
    }

    public void setCnt(Connection cnt) {
        this.cnt = cnt;
    }
    
    
    public DALConnectionBD(){
//        try
//        {
//            cnt = getConnectionBD();
//        }
//        catch (Exception ex)
//        {
//               System.err.print(ex.getMessage());     
//        }
    }

    public Connection getConnectionBD(){
        try
        {
//            Properties pro = new Properties();
//            pro.put("tendangnhap", this.tendangnhap);
//            pro.put("matkhau", this.mk);
            cnt = DriverManager.getConnection("jdbc:" + dbms + "://" +  host + ":3306" + "/" + csdl + "" 
                            + "?useUnicode=true&characterEncoding=UTF-8", this.tendangnhap, this.mk);
            return cnt;
        }
        catch(SQLException except)
        {
            //JOptionPane.showMessageDialog(null, "" );
            return null;
        }
        
    }
    
    public void closeCnt() {
        try {
            cnt.close();
        } catch (Exception e) {
        }
        
    }
     
    public ResultSet executeQuery(String query){
        try
        {
            stmt = cnt.createStatement();
            rs = stmt.executeQuery(query);
            return rs;
        }
        catch(SQLException ex)
        {
            System.err.printf("Error: ", ex.getMessage());
            return null;
        }
    }
    
    public boolean exeUpdate(String query){
        try
        {
            stmt = cnt.createStatement();
            return stmt.executeUpdate(query) == 1;
        }
        catch(SQLException excep)
        {
            System.err.printf(excep.getMessage());
            return false;
        }
    }
    
    public ResultSet preparedStmt(String sqlString) throws SQLException
    {
        PreparedStatement statement = cnt.prepareStatement(sqlString);
        ResultSet rst = statement.executeQuery();
        return rst;
    }
    
    //md5
    public String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    
}
