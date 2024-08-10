/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_UI.MatHang;

import BHX_DAO.LoaiMatHangDAO;
import BHX_DAO.MatHangDAO;
import BHX_DAO.NhomLoaiMatHangDAO;
import BHX_MODEL.Database.model.LoaiMathang;
import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.NhomLoaiMathang;
import BHX_Swings.bhx.swing.tableToAction.ImageCellRender;
import BHX_UI.BanHang.frm_Main_BanHang;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author VanPhu
 */
public class frm_TimKiemMatHang extends javax.swing.JFrame {
    
    private frm_Main_BanHang banHang;
    private ArrayList<MatHang> dsMH;
    private ArrayList<LoaiMathang> danhSachLoaiMH;
    private ArrayList<NhomLoaiMathang> danhSachNhomLoaiMH;
    private ArrayList<String> dsDVT;
    private boolean flagBlockLoadData = true;

    /**
     * Creates new form frm_TimKiemMatHang
     */
    public frm_TimKiemMatHang() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageCellRender());
        btnSearch.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\search.png", 30, 30));
        loadDataToComboboxLoai();
        loadDataToComboboxNhomLoai();
        loadDataToComboboxDVT();
        resetFrm();
        loadDataToTable();

        // Sau khi load dữ liệu xong thay đổi flag.
        flagBlockLoadData = false;
    }
    
    public frm_TimKiemMatHang(frm_Main_BanHang banHang) {
        this.banHang = banHang;
        initComponents();
        setLocationRelativeTo(banHang);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        table.getColumnModel().getColumn(3).setCellRenderer(new ImageCellRender());
        btnSearch.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\search.png", 30, 30));
        loadDataToComboboxLoai();
        loadDataToComboboxNhomLoai();
        loadDataToComboboxDVT();
        resetFrm();
        loadDataToTable();

        // Sau khi load dữ liệu xong thay đổi flag.
        flagBlockLoadData = false;
    }
    
    private ImageIcon getIScaleImage(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image scale = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scalIcon = new ImageIcon(scale);
        return scalIcon;
    }
    
    private void resetFrm() {
        rdoNhom.setSelected(false);
        buttonGroup1.clearSelection();
        rdoDocLap.setSelected(true);
        cbbDVT.setSelectedIndex(-1);
        cbbGiaThanh.setSelectedIndex(-1);
        cbbLocLoaiMH.setSelectedIndex(-1);
        cbbNhomLoai.setSelectedIndex(-1);
        txtTimKiem.setText("");
    }
    
    private void locTheoDVT(String dvtSP) {
        if (rdoDocLap.isSelected()) {
            try {
                MatHangDAO mhDAO = new MatHangDAO();
                this.dsMH = mhDAO.locTheoDVT(dvtSP);
                table.clearDataTable();
                for (MatHang matHang : dsMH) {
                    table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
                }
                txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
                String dvt = cbbDVT.getSelectedItem().toString();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    private void locTheoNhomLoai(String maNhomLoai) {
        if (rdoDocLap.isSelected()) {
            try {
                MatHangDAO mhDAO = new MatHangDAO();
                this.dsMH = mhDAO.locTheoNhomLoai(maNhomLoai);
                table.clearDataTable();
                for (MatHang matHang : dsMH) {
                    table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
                }
                txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
                NhomLoaiMathang nl = (NhomLoaiMathang) cbbNhomLoai.getSelectedItem();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    private void locTheoLoai(String maLoai) {
        if (rdoDocLap.isSelected()) {
            try {
                MatHangDAO mhDAO = new MatHangDAO();
                this.dsMH = mhDAO.locTheoLoai(maLoai);
                table.clearDataTable();
                for (MatHang matHang : dsMH) {
                    table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
                }
                txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
                LoaiMathang l = (LoaiMathang) cbbLocLoaiMH.getSelectedItem();
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    
    private void loadDataToTable() {
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            this.dsMH = mhDAO.select();
            table.clearDataTable();
            for (MatHang matHang : dsMH) {
                table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
            }
            txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadDataToComboboxNhomLoai() {
        try {
            NhomLoaiMatHangDAO lmhDAO = new NhomLoaiMatHangDAO();
            this.danhSachNhomLoaiMH = lmhDAO.select();
            cbbNhomLoai.removeAllItems();
            for (NhomLoaiMathang nhomLoaiMH : danhSachNhomLoaiMH) {
                cbbNhomLoai.addItem(nhomLoaiMH);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadDataToComboboxDVT() {
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            this.dsDVT = mhDAO.selectDVT();
            cbbDVT.removeAllItems();
            for (String dvt : dsDVT) {
                cbbDVT.addItem(dvt);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    private void loadDataToComboboxLoai() {
        try {
            LoaiMatHangDAO lmhDAO = new LoaiMatHangDAO();
            this.danhSachLoaiMH = lmhDAO.select();
            cbbLocLoaiMH.removeAllItems();
            for (LoaiMathang loaiMatHang : danhSachLoaiMH) {
                cbbLocLoaiMH.addItem(loaiMatHang);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new BHX_Swings.bhx.swing.tableToAction.Table();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbbNhomLoai = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel3 = new javax.swing.JLabel();
        cbbLocLoaiMH = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel4 = new javax.swing.JLabel();
        cbbDVT = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel5 = new javax.swing.JLabel();
        cbbGiaThanh = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel6 = new javax.swing.JLabel();
        btnSearch = new BHX_Swings.bhx.swing.button.ButtonCustom();
        txtTimKiem = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        btnChon = new BHX_Swings.bhx.swing.button.ButtonCustom();
        btnXoaLoc = new BHX_Swings.bhx.swing.button.ButtonCustom();
        jLabel7 = new javax.swing.JLabel();
        txtTongSanPham = new javax.swing.JLabel();
        txtTongSanPham1 = new javax.swing.JLabel();
        rdoNhom = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        rdoDocLap = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        btnLocTheoNhom = new BHX_Swings.bhx.swing.button.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TÌM KIẾM MẶT HÀNG - SẢN PHẨM");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Sản Phẩm", "Tên Sản Phẩm", "Hình Ảnh", "Đơn Vị Tính", "Giá Bán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        table.setRowHeight(90);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(250);
            table.getColumnModel().getColumn(1).setMaxWidth(250);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            table.getColumnModel().getColumn(3).setMaxWidth(200);
            table.getColumnModel().getColumn(4).setPreferredWidth(200);
            table.getColumnModel().getColumn(4).setMaxWidth(200);
            table.getColumnModel().getColumn(5).setPreferredWidth(200);
            table.getColumnModel().getColumn(5).setMaxWidth(200);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setText("Thao tác");

        cbbNhomLoai.setEditable(false);
        cbbNhomLoai.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        cbbNhomLoai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbNhomLoaiItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setText("Loại");

        cbbLocLoaiMH.setEditable(false);
        cbbLocLoaiMH.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        cbbLocLoaiMH.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbLocLoaiMHItemStateChanged(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 51));
        jLabel4.setText("Đơn vị tính");

        cbbDVT.setEditable(false);
        cbbDVT.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        cbbDVT.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDVTItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 51));
        jLabel5.setText("Giá thành");

        cbbGiaThanh.setEditable(false);
        cbbGiaThanh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Thấp đến cao", "Cao xuống thấp." }));
        cbbGiaThanh.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        cbbGiaThanh.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbGiaThanhItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("Tìm kiếm sản phẩm");

        btnSearch.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N
        txtTimKiem.setRound(0);
        txtTimKiem.setSelectionColor(new java.awt.Color(0, 153, 102));

        btnChon.setText("Chọn Sản Phẩm");
        btnChon.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonActionPerformed(evt);
            }
        });

        btnXoaLoc.setText("Xóa Lọc");
        btnXoaLoc.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLocActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 51));
        jLabel7.setText("Nhóm loại");

        txtTongSanPham.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtTongSanPham.setForeground(new java.awt.Color(0, 0, 204));
        txtTongSanPham.setText("Tổng sản phẩm hiển thị:");

        txtTongSanPham1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        txtTongSanPham1.setForeground(new java.awt.Color(0, 0, 204));
        txtTongSanPham1.setText("Lọc theo điều kiện:");

        rdoNhom.setBackground(new java.awt.Color(0, 51, 204));
        buttonGroup1.add(rdoNhom);
        rdoNhom.setForeground(new java.awt.Color(0, 0, 204));
        rdoNhom.setText("Lọc theo nhóm.");
        rdoNhom.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        rdoDocLap.setBackground(new java.awt.Color(0, 51, 204));
        buttonGroup1.add(rdoDocLap);
        rdoDocLap.setForeground(new java.awt.Color(0, 0, 204));
        rdoDocLap.setText("Lọc riêng lẻ - độc lập.");
        rdoDocLap.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        btnLocTheoNhom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/BHX_IMG/folderImages/images/icons/icons8-filter-20.png"))); // NOI18N
        btnLocTheoNhom.setText("Lọc Theo Nhóm");
        btnLocTheoNhom.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        btnLocTheoNhom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocTheoNhomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoaLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocTheoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(cbbNhomLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbbLocLoaiMH, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTongSanPham))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(cbbDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbbGiaThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtTongSanPham1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdoDocLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnXoaLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnChon, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(cbbNhomLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(cbbLocLoaiMH, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(cbbDVT, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(cbbGiaThanh, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(btnLocTheoNhom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongSanPham)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongSanPham1)
                            .addComponent(rdoNhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdoDocLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonActionPerformed
        // TODO add your handling code here:
        int index = table.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn mặt hàng !");
            return;
        }
        MatHang mh = dsMH.get(index);
        this.banHang.setTxtMaSP(mh.getMamh());
        this.banHang.setEnabled(true);
        dispose();
    }//GEN-LAST:event_btnChonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.banHang.setEnabled(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnXoaLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLocActionPerformed
        // TODO add your handling code here:
        resetFrm();
        loadDataToTable();
    }//GEN-LAST:event_btnXoaLocActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        if (txtTimKiem.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập từ khóa cần tìm !");
            return;
        }
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            this.dsMH = mhDAO.timKiem(txtTimKiem.getText().trim());
            txtTongSanPham.setText("Tổng sản phẩm vừa tìm: Có [" + dsMH.size() + "] sản phẩm. ");
            table.clearDataTable();
            for (MatHang matHang : dsMH) {
                table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void cbbNhomLoaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbNhomLoaiItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED && flagBlockLoadData == false) {
            try {
                if (rdoDocLap.isSelected()) {
                    cbbDVT.setSelectedIndex(-1);
                    cbbGiaThanh.setSelectedIndex(-1);
                    cbbLocLoaiMH.setSelectedIndex(-1);
                }
                NhomLoaiMathang nlmh = (NhomLoaiMathang) cbbNhomLoai.getSelectedItem();
                locTheoNhomLoai(nlmh.getManhomLoai());
            } catch (Exception e) {
                loadDataToTable();
                return;
            }
        }
    }//GEN-LAST:event_cbbNhomLoaiItemStateChanged

    private void cbbLocLoaiMHItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbLocLoaiMHItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED && flagBlockLoadData == false) {
            try {
                if (rdoDocLap.isSelected()) {
                    cbbDVT.setSelectedIndex(-1);
                    cbbGiaThanh.setSelectedIndex(-1);
                    cbbNhomLoai.setSelectedIndex(-1);
                }
                LoaiMathang lmh = (LoaiMathang) cbbLocLoaiMH.getSelectedItem();
                locTheoLoai(lmh.getMaloai());
            } catch (Exception e) {
                loadDataToTable();
                return;
            }
        }
    }//GEN-LAST:event_cbbLocLoaiMHItemStateChanged

    private void cbbDVTItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDVTItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED && flagBlockLoadData == false) {
            try {
                if (rdoDocLap.isSelected()) {
                    cbbGiaThanh.setSelectedIndex(-1);
                    cbbLocLoaiMH.setSelectedIndex(-1);
                    cbbNhomLoai.setSelectedIndex(-1);
                }
                String dvt = cbbDVT.getSelectedItem().toString();
                locTheoDVT(dvt);
            } catch (Exception e) {
                loadDataToTable();
                return;
            }
        }
    }//GEN-LAST:event_cbbDVTItemStateChanged

    private void cbbGiaThanhItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbGiaThanhItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED && flagBlockLoadData == false) {
            try {
                int orderby = cbbGiaThanh.getSelectedIndex();
                if (orderby == 0) {
                    Collections.sort(dsMH, new Comparator<MatHang>() {
                        @Override
                        public int compare(MatHang s1, MatHang s2) {
                            return s1.getGiaBan().compareTo(s2.getGiaBan());
                        }
                    });
                    txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
                    table.clearDataTable();
                    for (MatHang matHang : dsMH) {
                        table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
                    }
                    return;
                }
                Collections.sort(dsMH, new Comparator<MatHang>() {
                    @Override
                    public int compare(MatHang s1, MatHang s2) {
                        return s2.getGiaBan().compareTo(s1.getGiaBan());
                    }
                });
                txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
                table.clearDataTable();
                for (MatHang matHang : dsMH) {
                    table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
                }
            } catch (Exception e) {
                loadDataToTable();
                return;
            }
        }
    }//GEN-LAST:event_cbbGiaThanhItemStateChanged

    private void btnLocTheoNhomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocTheoNhomActionPerformed
        // TODO add your handling code here:
        cbbGiaThanh.setSelectedIndex(-1);
        if (!rdoNhom.isSelected()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chức năng lọc theo điều kiện nhóm !");
            return;
        }
        NhomLoaiMathang nlmh = (cbbNhomLoai.getSelectedItem() != null) ? (NhomLoaiMathang) cbbNhomLoai.getSelectedItem() : null;
        LoaiMathang lmh = (cbbLocLoaiMH.getSelectedItem() != null) ? (LoaiMathang) cbbLocLoaiMH.getSelectedItem() : null;
        String dvt = (cbbDVT.getSelectedItem() != null) ? cbbDVT.getSelectedItem().toString() : "";
        
        if (nlmh == null && lmh == null && dvt == "") {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn gía trị cần lọc !");
            return;
        }
        
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            this.dsMH = mhDAO.locTheoNhom((nlmh != null) ? nlmh.getManhomLoai() : "", (lmh != null) ? lmh.getMaloai() : "", dvt);
            txtTongSanPham.setText("Tổng sản phẩm hiển thị: Có [" + dsMH.size() + "] sản phẩm. ");
            table.clearDataTable();
            for (MatHang matHang : dsMH) {
                table.addRow(matHang.toRowTableTimKiem(dsMH.indexOf(matHang) + 1));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnLocTheoNhomActionPerformed

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
            java.util.logging.Logger.getLogger(frm_TimKiemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_TimKiemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_TimKiemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_TimKiemMatHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_TimKiemMatHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BHX_Swings.bhx.swing.button.ButtonCustom btnChon;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnLocTheoNhom;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnSearch;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnXoaLoc;
    private javax.swing.ButtonGroup buttonGroup1;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbDVT;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbGiaThanh;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbLocLoaiMH;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbNhomLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private BHX_Swings.bhx.swing.radio_button.RadioButtonCustom rdoDocLap;
    private BHX_Swings.bhx.swing.radio_button.RadioButtonCustom rdoNhom;
    private BHX_Swings.bhx.swing.tableToAction.Table table;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTimKiem;
    private javax.swing.JLabel txtTongSanPham;
    private javax.swing.JLabel txtTongSanPham1;
    // End of variables declaration//GEN-END:variables
}
