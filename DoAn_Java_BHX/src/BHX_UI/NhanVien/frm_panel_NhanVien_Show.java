/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_UI.NhanVien;

import BHX_DAO.NhanVienDAO;
import BHX_DAO.QueQuanNVDAO;
import BHX_DAO.TinhThanhDAO;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.QuequanNhanvien;
import BHX_MODEL.Database.model.Tinhthanh;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author VanPhu
 */
public class frm_panel_NhanVien_Show extends javax.swing.JPanel {

    private static String srcImg = "src/BHX_IMG/folderImages/images/staff/";
    private ArrayList<Tinhthanh> dsTinhThanh;

    /**
     * Creates new form frm_panel_NhanVien_Show
     */
    public frm_panel_NhanVien_Show() {
        initComponents();
        image.setSize(600, 600);
    }

    public void loadInfo(String ID) {
        if (!ID.isEmpty()) {
            try {
                NhanVienDAO nvDAO = new NhanVienDAO();
                Nhanvien nv = nvDAO.selectWithID(ID.trim());
                if (nv != null) {
                    txtID.setText(nv.getManv());
                    txtTen.setText(nv.getTennv());
                    txtChucVu.setText(nv.getChucvu());
                    txtCCCD.setText(nv.getCccd());
                    txtHSL.setText(nv.getHesoluong().toString());
                    txtHocVan.setText(nv.getTrinhdohocvan());
                    txtNS.setText(nv.getNgaysinh().toString());
                    txtNgayVL.setText(nv.getNgayvaolam().toString());
                    txtSDT.setText(nv.getPhone());
                    try {
                        BufferedImage originalImage = ImageIO.read(new File(srcImg + nv.getPicture().toString()));
                        int originalWidth = originalImage.getWidth();
                        int originalHeight = originalImage.getHeight();
                        int labelWidth = image.getWidth();
                        int labelHeight = image.getHeight();
                        double widthRatio = (double) labelWidth / originalWidth;
                        double heightRatio = (double) labelHeight / originalHeight;
                        double ratio = Math.min(widthRatio, heightRatio);
                        int newWidth = (int) (originalWidth * ratio);
                        int newHeight = (int) (originalHeight * ratio);
                        Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                        ImageIcon imageIcon = new ImageIcon(scaledImage);
                        image.setIcon(imageIcon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //
                    String gt = nv.getGioitinh();
                    if (gt.toLowerCase().equals("nam")) {
                        rdoNam.setSelected(true);
                    } else if (gt.toLowerCase().equals("nữ")) {
                        rdoNu.setSelected(true);
                    } else {
                        rdoKhac.setSelected(true);
                    }

                    //
                    loadQueQuan(ID.trim());
                    return;
                }
                JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại hoặc tải thông tin nhân viên lỗi !");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }

    public void loadQueQuan(String ID) {
        if (!ID.isEmpty()) {
            try {
                QueQuanNVDAO qqNV = new QueQuanNVDAO();
                QuequanNhanvien qqnv = qqNV.loadQueQuanNhanVien(ID);
                if (qqnv != null) {
                    String tenDuong = qqnv.getTenduong();
                    String tenTinh = qqNV.getTenTinhThanh(qqnv.getTinhthanh().getMatinhthanh()) == null ? "" : qqNV.getTenTinhThanh(qqnv.getTinhthanh().getMatinhthanh());
                    String tenHuyen = qqNV.getTenQuanHuyen(qqnv.getQuanHuyen().getMaquanHuyen()) == null ? "" : qqNV.getTenQuanHuyen(qqnv.getQuanHuyen().getMaquanHuyen());
                    String tenXa = qqNV.getTenXaPhuong(qqnv.getXaPhuong().getMaxaPhuong()) == null ? "" : qqNV.getTenXaPhuong(qqnv.getXaPhuong().getMaxaPhuong());
                    txtDiaChi.setText((!tenDuong.isEmpty() ? tenDuong : "") + ", " + (!tenTinh.isEmpty() ? tenTinh : "") + ", " + (!tenHuyen.isEmpty() ? tenHuyen : "") + ", " + (!tenXa.isEmpty() ? tenXa : "") + ". ");
                    if (tenDuong.isEmpty() && tenTinh.isEmpty() && tenHuyen.isEmpty() && tenXa.isEmpty()) {
                        txtDiaChi.setText("Thông tin chưa được cập nhật !");
                    }
                } else {
                    txtDiaChi.setText("Thông tin chưa được cập nhật !");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Nhân viên không tồn tại hoặc tải thông tin nhân viên lỗi !");
    }

    private ImageIcon getIScaleImage(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image scale = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scalIcon = new ImageIcon(scale);
        return scalIcon;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel6 = new javax.swing.JLabel();
        txtNS = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHocVan = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel9 = new javax.swing.JLabel();
        txtChucVu = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNgayVL = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel13 = new javax.swing.JLabel();
        txtSDT = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jPanel2 = new javax.swing.JPanel();
        rdoNam = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        rdoNu = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        rdoKhac = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        txtHSL = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtCCCD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel14 = new javax.swing.JLabel();
        txtDiaChi = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("Thông tin nhân viên");

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        image.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Mã nhân viên:");

        txtID.setEditable(false);
        txtID.setForeground(new java.awt.Color(204, 0, 0));
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 102));
        jLabel5.setText("Tên nhân viên:");

        txtTen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 102));
        jLabel6.setText("Ngày sinh:");

        txtNS.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 102));
        jLabel7.setText("Giới tính:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 102));
        jLabel8.setText("Trình độ học vấn:");

        txtHocVan.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 102));
        jLabel9.setText("Chức vụ:");

        txtChucVu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 153, 102));
        jLabel10.setText("Căn cước công dân:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 153, 102));
        jLabel11.setText("Hệ số lương:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 102));
        jLabel12.setText("Ngày vào làm:");

        txtNgayVL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 102));
        jLabel13.setText("Số điện thoại:");

        txtSDT.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(193, 42));

        rdoNam.setBackground(new java.awt.Color(51, 153, 0));
        buttonGroup1.add(rdoNam);
        rdoNam.setForeground(new java.awt.Color(0, 153, 51));
        rdoNam.setText("Nam");
        rdoNam.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        rdoNu.setBackground(new java.awt.Color(51, 153, 0));
        buttonGroup1.add(rdoNu);
        rdoNu.setForeground(new java.awt.Color(0, 153, 51));
        rdoNu.setText("Nữ");
        rdoNu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        rdoKhac.setBackground(new java.awt.Color(51, 153, 0));
        buttonGroup1.add(rdoKhac);
        rdoKhac.setForeground(new java.awt.Color(0, 153, 51));
        rdoKhac.setText("Khác");
        rdoKhac.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdoNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdoNu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdoKhac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoKhac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtHSL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtCCCD.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 102));
        jLabel14.setText("Địa chỉ:");

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNS, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                            .addComponent(txtHocVan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayVL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtNS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel7)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHocVan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel9)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtNgayVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtHSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private BHX_Swings.bhx.swing.radio_button.RadioButtonCustom rdoKhac;
    private BHX_Swings.bhx.swing.radio_button.RadioButtonCustom rdoNam;
    private BHX_Swings.bhx.swing.radio_button.RadioButtonCustom rdoNu;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtCCCD;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtChucVu;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtDiaChi;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtHSL;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtHocVan;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtID;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNS;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNgayVL;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtSDT;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTen;
    // End of variables declaration//GEN-END:variables
}
