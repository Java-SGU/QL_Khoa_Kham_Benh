/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import BLL.BLLChucVu;
import BLL.BLLChuyenKhoa;
import BLL.BLLNhanVien;
import DTO.DTOChucVu;
import DTO.DTOChuyenKhoa;
import DTO.DTONhanVien;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Documents
 */
public class SuaThongTinNhanVien extends javax.swing.JDialog {
    BLLNhanVien bllNV = new BLLNhanVien();
    BLLChucVu bllCV = new BLLChucVu();
    BLLChuyenKhoa bllCK = new BLLChuyenKhoa();
    DefaultComboBoxModel modelCV;
    
    int maNV;
    /**
     * Creates new form SuaThongTinNhanVien
     * @param maNV
     */
    public SuaThongTinNhanVien(int maNV) {
        initComponents();
        this.maNV = maNV;
        layDulieuVaoCombobox();
        
        layDuLieu(maNV);
    }

    //lấy dữ liệu vào form
    private void layDuLieu(int maNV){
        try{
            DTONhanVien dtoNhanVien = bllNV.layNhanVienTheoMa(maNV);//lấy đối tượng nhân viên theo mã
            if(dtoNhanVien != null){//nếu nhân viên tồn tại
                //gán các giá trị trong csdl vào form
                jtxtMaNV.setText(String.valueOf(dtoNhanVien.getMaNV()));
                jtxtHoTen.setText(dtoNhanVien.getHoTen());
                jtxtCmnd.setText(dtoNhanVien.getCmnd());
                jtxtDiaChi.setText(dtoNhanVien.getDiaChi());
                jtxtDienThoai.setText(dtoNhanVien.getDienThoai());
                if("Nam".equals(dtoNhanVien.getGioiTinh()))
                    jrabtnNam.setSelected(true);
                else
                    jrabtnNu.setSelected(true);
                
                if(null != dtoNhanVien.getHocVi())
                    switch (dtoNhanVien.getHocVi()) {
                    case "Bác sĩ":
                        jrabtnBacSi.setSelected(true);
                         modelCV.removeAllElements();
                        DTONhanVien dtoTruongKhoa = bllNV.timTruongKhoa("trưởng khoa");
                        ArrayList<DTOChucVu> dsChucVu;
                        if(dtoTruongKhoa == null){
                            dsChucVu = bllCV.layDSChucVuTheoDK(1);
                        }
                        else{
                            dsChucVu = bllCV.layDSChucVuTheoDK(2);
                        }
                        for(DTOChucVu dtoCV : dsChucVu){
                             modelCV.addElement(dtoCV);
                        }
                        break;
                    case "Y tá":
                        jrabtnYTa.setSelected(true);
                        modelCV.removeAllElements();
                        DTONhanVien dtoTruongKhoaYta = bllNV.timTruongKhoa("y tá trưởng");
                        ArrayList<DTOChucVu> dsChucVuYta;
                        if(dtoTruongKhoaYta == null){
                            dsChucVuYta = bllCV.layDSChucVuTheoDK(3);
                        }
                        else{
                            dsChucVuYta = bllCV.layDSChucVuTheoDK(4);
                        }
                        for(DTOChucVu dtoCV : dsChucVuYta){
                             modelCV.addElement(dtoCV);
                        }
                        break;
                }
                //gán ngày sinh
                Date ngaySinh = dtoNhanVien.getNgaySinh();
                Calendar cal = Calendar.getInstance();
                cal.setTime(ngaySinh);
                jcbNamsinh.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
                jcbThangsinh.setSelectedItem(String.valueOf(cal.get(Calendar.MONDAY)));
                jcbNgaysinh.setSelectedItem(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)));
                //----------
                //chức vụ
                jcbxChuyenKhoa.setSelectedItem(dtoNhanVien.getDtoCK());
                jcbxChucVu.setSelectedItem(dtoNhanVien.getDtoCV());
            }
            else{
                
            }
        }
        catch(Exception e){
            
        }
    }
    
    //tai du lieu vao combobox
    private void layDulieuVaoCombobox(){
        //combobox chuc vu
        modelCV = new DefaultComboBoxModel();
//        for(DTOChucVu dtoCV : bllCV.layDSChucVu()){
//            modelCV.addElement(dtoCV);
//        }
        jcbxChucVu.setModel(modelCV);
        
        DefaultComboBoxModel modelCK = new DefaultComboBoxModel();
        
        //combobox chuyen khoa
        for(DTOChuyenKhoa dtoChuyenKhoa : bllCK.layDSChuyenKhoa()){
            modelCK.addElement(dtoChuyenKhoa);
        }
        jcbxChuyenKhoa.setModel(modelCK);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jpnlChiTiet = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtxtMaNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtxtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtDiaChi = new javax.swing.JTextField();
        jtxtCmnd = new javax.swing.JTextField();
        jrabtnBacSi = new javax.swing.JRadioButton();
        jrabtnYTa = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jrabtnNam = new javax.swing.JRadioButton();
        jrabtnNu = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jtxtDienThoai = new javax.swing.JTextField();
        jcbNgaysinh = new javax.swing.JComboBox();
        jcbThangsinh = new javax.swing.JComboBox();
        jcbNamsinh = new javax.swing.JComboBox();
        jcbxChuyenKhoa = new javax.swing.JComboBox();
        jcbxChucVu = new javax.swing.JComboBox();
        jbtnLuu = new javax.swing.JButton();
        jbtnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 0));
        jLabel2.setText("SỬA THÔNG TIN NHÂN VIÊN");

        jpnlChiTiet.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Mã nhân viên");

        jtxtMaNV.setEnabled(false);

        jLabel4.setText("Họ tên");

        jtxtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHoTenActionPerformed(evt);
            }
        });

        jLabel5.setText("Giới tính");

        jLabel6.setText("Ngày sinh");

        jLabel7.setText("CMND");

        jLabel8.setText("Địa chỉ");

        jtxtCmnd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtCmndKeyTyped(evt);
            }
        });

        buttonGroup2.add(jrabtnBacSi);
        jrabtnBacSi.setText("Bác sĩ");
        jrabtnBacSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrabtnBacSiActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrabtnYTa);
        jrabtnYTa.setText("Y tá");
        jrabtnYTa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrabtnYTaActionPerformed(evt);
            }
        });

        jLabel11.setText("Chuyên khoa");

        jLabel12.setText("Chức vụ");

        buttonGroup1.add(jrabtnNam);
        jrabtnNam.setText("Nam");

        buttonGroup1.add(jrabtnNu);
        jrabtnNu.setText("Nữ");

        jLabel10.setText("Điện thoại");

        jtxtDienThoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDienThoaiKeyTyped(evt);
            }
        });

        jcbNgaysinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        jcbNgaysinh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbNgaysinhItemStateChanged(evt);
            }
        });
        jcbNgaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNgaysinhActionPerformed(evt);
            }
        });

        jcbThangsinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jcbNamsinh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014" }));
        jcbNamsinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNamsinhActionPerformed(evt);
            }
        });

        jcbxChuyenKhoa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbxChucVu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpnlChiTietLayout = new javax.swing.GroupLayout(jpnlChiTiet);
        jpnlChiTiet.setLayout(jpnlChiTietLayout);
        jpnlChiTietLayout.setHorizontalGroup(
            jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                        .addComponent(jrabtnBacSi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jrabtnYTa)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jcbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                        .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbThangsinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                        .addComponent(jcbNamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                        .addComponent(jtxtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jrabtnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jrabtnNu, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpnlChiTietLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(25, 25, 25)
                                .addComponent(jtxtDiaChi)))
                        .addGap(0, 14, Short.MAX_VALUE))))
        );
        jpnlChiTietLayout.setVerticalGroup(
            jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrabtnNam)
                            .addComponent(jLabel5)
                            .addComponent(jrabtnNu))))
                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jcbNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbThangsinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbNamsinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpnlChiTietLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jtxtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jtxtCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpnlChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrabtnBacSi)
                    .addComponent(jrabtnYTa)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jcbxChuyenKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jbtnLuu.setText("Lưu");
        jbtnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLuuActionPerformed(evt);
            }
        });

        jbtnHuy.setText("Đóng");
        jbtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnlChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnLuu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnHuy)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jpnlChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLuu)
                    .addComponent(jbtnHuy))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHoTenActionPerformed

    private void jrabtnYTaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrabtnYTaActionPerformed
        try {
            modelCV.removeAllElements();
            DTONhanVien dtoTruongKhoa = bllNV.timTruongKhoa("y tá trưởng");
            ArrayList<DTOChucVu> dsChucVu;
            if(dtoTruongKhoa == null){
                dsChucVu = bllCV.layDSChucVuTheoDK(3);
            }
            else{
                dsChucVu = bllCV.layDSChucVuTheoDK(4);
            }
            for(DTOChucVu dtoCV : dsChucVu){
                 modelCV.addElement(dtoCV);
            }        
                
                    
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }//GEN-LAST:event_jrabtnYTaActionPerformed

    private void jcbNgaysinhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbNgaysinhItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jcbNgaysinhItemStateChanged

    private void jcbNgaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNgaysinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNgaysinhActionPerformed

    private void jcbNamsinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNamsinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbNamsinhActionPerformed

    private void jbtnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLuuActionPerformed
        try {
            if("".equals(KiemTra())){
               
                String tennv = jtxtHoTen.getText().trim();
                String cmnd = jtxtCmnd.getText().trim();
                String dienthoai = jtxtDienThoai.getText().trim();
                String diachi = jtxtDiaChi.getText().trim();
                String gioitinh = jrabtnNam.isSelected()? "Nam":"Nữ";
                Date ngaysinh = layNgaySinh();
                String hocvi = jrabtnBacSi.isSelected()?"Bác sĩ":"Y tá";
                DTOChucVu dtoCV = (DTOChucVu)jcbxChucVu.getSelectedItem();
                DTOChuyenKhoa dtoCK = (DTOChuyenKhoa)jcbxChuyenKhoa.getSelectedItem();

                DTONhanVien dtoNV = new DTONhanVien();
                dtoNV.setMaNV(this.maNV);
                dtoNV.setHoTen(tennv);
                dtoNV.setCmnd(cmnd);
                dtoNV.setDienThoai(dienthoai);
                dtoNV.setDiaChi(diachi);
                dtoNV.setGioiTinh(gioitinh);
                dtoNV.setNgaySinh(ngaysinh);
                dtoNV.setHocVi(hocvi);
                dtoNV.setDtoCV(dtoCV);
                dtoNV.setDtoCK(dtoCK);

                if(bllNV.capNhatNhanVien(dtoNV))
                         JOptionPane.showMessageDialog(null, "Đã cập nhật thông tin nhân viên");
                else
                    JOptionPane.showMessageDialog(null, "Không thể cập nhật thông tin nhân viên");
            }
            else{
                JOptionPane.showMessageDialog(null, KiemTra());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi cập nhật nhân viên");
        }
    }//GEN-LAST:event_jbtnLuuActionPerformed

    private void jbtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHuyActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbtnHuyActionPerformed

    private void jtxtCmndKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCmndKeyTyped
        char vChar = evt.getKeyChar();
        if(!Character.isDigit(vChar) || vChar == KeyEvent.VK_BACK_SPACE || vChar == KeyEvent.VK_DELETE)
            evt.consume();
    }//GEN-LAST:event_jtxtCmndKeyTyped

    private void jtxtDienThoaiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDienThoaiKeyTyped
       char vChar = evt.getKeyChar();
       if(!Character.isDigit(vChar) || vChar == KeyEvent.VK_BACK_SPACE || vChar == KeyEvent.VK_DELETE)
            evt.consume();
    }//GEN-LAST:event_jtxtDienThoaiKeyTyped

    private void jrabtnBacSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrabtnBacSiActionPerformed
        try {
            modelCV.removeAllElements();
            DTONhanVien dtoTruongKhoa = bllNV.timTruongKhoa("trưởng khoa");
            ArrayList<DTOChucVu> dsChucVu;
            if(dtoTruongKhoa == null){
                dsChucVu = bllCV.layDSChucVuTheoDK(1);
            }
            else{
                dsChucVu = bllCV.layDSChucVuTheoDK(2);
            }
            for(DTOChucVu dtoCV : dsChucVu){
                 modelCV.addElement(dtoCV);
            }        
                
                    
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }//GEN-LAST:event_jrabtnBacSiActionPerformed

    
    //lay han su dung cua BHYT
    private Date layNgaySinh(){
        try {
            int namHH = Integer.valueOf(jcbNamsinh.getSelectedItem().toString());
            int thangHH = Integer.valueOf(jcbThangsinh.getSelectedItem().toString());
            int ngayHH = Integer.valueOf(jcbNgaysinh.getSelectedItem().toString());
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");//định dạng kiểu ngày tháng năm
            format.setLenient(false);//không cho phép lấy ngày qua tháng sau, bắt buộc phải chọn đúng ngày
            java.util.Date date = format.parse(namHH + "-" + thangHH + "-" + ngayHH);
            Date setNgayHH = new Date(date.getTime());//đổi ngày từ java.util.Date sang java.sql.Date
            return setNgayHH;
        } catch (NumberFormatException | ParseException e) {
            return null;
        }
    }
    private String KiemTra(){
        String kq = "";
        if("".equals(jtxtHoTen.getText().trim()))
            kq += "Vui lòng nhập họ tên\n";
        //nam sinh?
        if("".equals(jtxtCmnd.getText().trim()))
            kq += "Vui lòng nập số CMND\n";
        if("".equals(jtxtDiaChi.getText().trim()))
            kq += "Vui lòng nhập địa chỉ";
        if(!jrabtnBacSi.isSelected() && ! jrabtnYTa.isSelected())
            kq += "Vui lòng chọn học vị";
        if(!jrabtnNam.isSelected() && ! jrabtnNu.isSelected())
            kq += "Vui lòng chọn giới tính";
        return kq;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuaThongTinNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SuaThongTinNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnLuu;
    private javax.swing.JComboBox jcbNamsinh;
    private javax.swing.JComboBox jcbNgaysinh;
    private javax.swing.JComboBox jcbThangsinh;
    private javax.swing.JComboBox jcbxChucVu;
    private javax.swing.JComboBox jcbxChuyenKhoa;
    private javax.swing.JPanel jpnlChiTiet;
    private javax.swing.JRadioButton jrabtnBacSi;
    private javax.swing.JRadioButton jrabtnNam;
    private javax.swing.JRadioButton jrabtnNu;
    private javax.swing.JRadioButton jrabtnYTa;
    private javax.swing.JTextField jtxtCmnd;
    private javax.swing.JTextField jtxtDiaChi;
    private javax.swing.JTextField jtxtDienThoai;
    private javax.swing.JTextField jtxtHoTen;
    private javax.swing.JTextField jtxtMaNV;
    // End of variables declaration//GEN-END:variables
}
