/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_UI.BanHang;

import BHX_DAO.ChitiethoadonDAO;
import BHX_DAO.HoaDonDAO;
import BHX_DAO.KhachHangDAO;
import BHX_DAO.MatHangDAO;
import BHX_MODEL.Database.model.ChitietHoadon;
import BHX_MODEL.Database.model.Hoadon;
import BHX_MODEL.Database.model.Khachhang;
import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Object.model.ChitiethoadonObj;
import BHX_PRINT_REPORT.ReportHoaDonObj;
import BHX_PRINT_REPORT.ReportManager;
import BHX_UI.MatHang.frm_TimKiemMatHang;
import BHX_UI.NhanVien.frm_QuanLyNhanVien;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author VanPhu
 */
public class frm_Main_BanHang extends javax.swing.JFrame {

    private JFrame main = null;
    private String IdNhanVien = "NV001";
    private int countPT = 1;
    private int countInfoNV = 1;
    private String IDHd = "";
    private ArrayList<frm_panel_BanHang_tabPhieuTam> danhSachPhieuTam = new ArrayList<>();
    private ArrayList<Khachhang> danhSachKH;

    /**
     * Creates new form frm_Main_BanHang
     */
    public frm_Main_BanHang(JFrame main) {
        this.main = main;
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        imageLogo.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\logo\\bachhoaxanhlogo_bh.png", imageLogo.getWidth(), imageLogo.getHeight()));
        btnInfo.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\information.png", 50, 50));
        btnReport.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\report.png", 50, 50));
        btnLogout.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\logout_toolbar.png", 50, 50));
        btnDeleteAll.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\trash.png", 50, 50));
        btnCreateTab.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\page.png", 50, 50));
        btnCloseTab.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\close.png", 50, 50));

        // Load form.
        setTxtTongTienHD(BigDecimal.ZERO);
        setTxtTongTienGiamGiaHD(BigDecimal.ZERO);
        setTxtTongSoLuongMhHD(BigDecimal.ZERO);
        loadCbbKhachHang();
        // 
        txtTienKHGui.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || (c == KeyEvent.VK_BACK_SPACE && !txtTienKHGui.getText().isEmpty()))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && !txtTienKHGui.getText().isEmpty() && e.getKeyCode() != KeyEvent.VK_ENTER) {
                    checkInput();
                }
            }
        });
    }

    public frm_Main_BanHang() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        imageLogo.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\logo\\bachhoaxanhlogo_bh.png", imageLogo.getWidth(), imageLogo.getHeight()));
        btnInfo.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\information.png", 50, 50));
        btnReport.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\report.png", 50, 50));
        btnLogout.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\logout_toolbar.png", 50, 50));
        btnDeleteAll.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\trash.png", 50, 50));
        btnCreateTab.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\page.png", 50, 50));
        btnCloseTab.setIcon(getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\close.png", 50, 50));

        // Load form.
        setTxtTongTienHD(BigDecimal.ZERO);
        setTxtTongTienGiamGiaHD(BigDecimal.ZERO);
        setTxtTongSoLuongMhHD(BigDecimal.ZERO);
        loadCbbKhachHang();
        // 
        txtTienKHGui.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || (c == KeyEvent.VK_BACK_SPACE && !txtTienKHGui.getText().isEmpty()))) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE && !txtTienKHGui.getText().isEmpty() && e.getKeyCode() != KeyEvent.VK_ENTER) {
                    checkInput();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnInfo = new javax.swing.JButton();
        btnReport = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        btnCreateTab = new javax.swing.JButton();
        btnCloseTab = new javax.swing.JButton();
        imageLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tab = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        btnTimKiemSP = new BHX_Swings.bhx.swing.button.ButtonCustom();
        btnAddCTHD = new BHX_Swings.bhx.swing.button.ButtonCustom();
        panelHD = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTongTienHD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtTongTienGiamGia = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel6 = new javax.swing.JLabel();
        txtTongSoLuongMH = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        txtTienKHGui = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txttienTraLai = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel21 = new javax.swing.JLabel();
        btnInHoaDon = new BHX_Swings.bhx.swing.button.btn2();
        btnThanhToan = new BHX_Swings.bhx.swing.button.btn2();
        txtThongBaoThanhToan = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnTimKH = new BHX_Swings.bhx.swing.button.ButtonCustom();
        cbbKH = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        txtIDHD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtNgayLap = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtNhanVien = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        btnTimKHLe = new BHX_Swings.bhx.swing.button.ButtonCustom();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtID_CTHD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtSoLuong_CTHD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        btnThayDoiSL = new BHX_Swings.bhx.swing.button.ButtonCustom();
        txtTen_CTHD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel13 = new javax.swing.JLabel();
        btnXoaDong = new BHX_Swings.bhx.swing.button.ButtonCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 136, 70));

        jToolBar1.setBackground(new java.awt.Color(0, 136, 70));
        jToolBar1.setBorder(null);
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        btnInfo.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnInfo.setText("Thông tin nhân viên");
        btnInfo.setFocusable(false);
        btnInfo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInfo.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnInfo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnInfo);

        btnReport.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReport.setText("Báo cáo");
        btnReport.setFocusable(false);
        btnReport.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnReport.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnReport.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnReport);

        btnLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);
        btnLogout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLogout.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnLogout.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btnLogout);

        btnDeleteAll.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDeleteAll.setText("Xóa tất cả hóa đơn");
        btnDeleteAll.setFocusable(false);
        btnDeleteAll.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteAll.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnDeleteAll.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeleteAll);

        btnCreateTab.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCreateTab.setText("Tạo hóa đơn mới");
        btnCreateTab.setFocusable(false);
        btnCreateTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCreateTab.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnCreateTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCreateTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateTabActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCreateTab);

        btnCloseTab.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCloseTab.setText("Đóng Tab");
        btnCloseTab.setFocusable(false);
        btnCloseTab.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCloseTab.setMargin(new java.awt.Insets(20, 20, 20, 20));
        btnCloseTab.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCloseTab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseTabActionPerformed(evt);
            }
        });
        jToolBar1.add(btnCloseTab);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 1116, Short.MAX_VALUE)
                    .addComponent(imageLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(imageLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tab.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        tab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabStateChanged(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        jPanel6.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nhập Mã Sản Phẩm:");

        txtMaSP.setFont(new java.awt.Font("Times New Roman", 1, 32)); // NOI18N

        btnTimKiemSP.setText("Tìm kiếm sản phẩm");
        btnTimKiemSP.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnTimKiemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemSPActionPerformed(evt);
            }
        });

        btnAddCTHD.setText("Thêm");
        btnAddCTHD.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnAddCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCTHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSP)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 238, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnTimKiemSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiemSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelHD.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("Tổng tiền hóa đơn:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Tổng tiền giảm giá:");

        txtTongTienHD.setEditable(false);
        txtTongTienHD.setForeground(new java.awt.Color(255, 0, 51));
        txtTongTienHD.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N

        txtTongTienGiamGia.setEditable(false);
        txtTongTienGiamGia.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Tổng số lượng sản phẩm:");

        txtTongSoLuongMH.setEditable(false);
        txtTongSoLuongMH.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 102));
        jLabel5.setText("Tiền khách hàng gửi:");

        txtTienKHGui.setForeground(new java.awt.Color(0, 153, 102));
        txtTienKHGui.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("VNĐ.");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 51));
        jLabel14.setText(".000 VNĐ.");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel15.setText("VNĐ.");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel18.setText("sản phẩm.");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 0, 0));
        jLabel19.setText("*Lưu ý: Không nhập phần nghìn (.000) phía sau. VD: 2.000 đ => Nhập số 2");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 102));
        jLabel20.setText("Tiền trả lại khách hàng:");

        txttienTraLai.setEditable(false);
        txttienTraLai.setForeground(new java.awt.Color(0, 204, 204));
        txttienTraLai.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 51));
        jLabel21.setText("VNĐ.");

        javax.swing.GroupLayout panelHDLayout = new javax.swing.GroupLayout(panelHD);
        panelHD.setLayout(panelHDLayout);
        panelHDLayout.setHorizontalGroup(
            panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelHDLayout.createSequentialGroup()
                        .addComponent(txtTongTienHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(panelHDLayout.createSequentialGroup()
                        .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTongSoLuongMH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTienKHGui, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(panelHDLayout.createSequentialGroup()
                        .addComponent(txttienTraLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel21))
                    .addGroup(panelHDLayout.createSequentialGroup()
                        .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addGap(0, 49, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHDLayout.createSequentialGroup()
                        .addComponent(txtTongTienGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)))
                .addContainerGap())
        );
        panelHDLayout.setVerticalGroup(
            panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongTienHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongTienGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTongSoLuongMH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienKHGui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttienTraLai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(12, 12, 12))
        );

        btnInHoaDon.setForeground(new java.awt.Color(0, 0, 0));
        btnInHoaDon.setText("Xuất hóa đơn");
        btnInHoaDon.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnInHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHoaDonActionPerformed(evt);
            }
        });

        btnThanhToan.setForeground(new java.awt.Color(0, 0, 0));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("Times New Roman", 1, 22)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtThongBaoThanhToan.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        txtThongBaoThanhToan.setForeground(new java.awt.Color(255, 0, 0));
        txtThongBaoThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(txtThongBaoThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtThongBaoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 102));
        jLabel16.setText("Thông tin hóa đơn");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("ID_HOADON:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("NGÀY LẬP:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("NHÂN VIÊN:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("KHÁCH HÀNG:");

        btnTimKH.setText("Tìm");
        btnTimKH.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTimKH.setRound(20);
        btnTimKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHActionPerformed(evt);
            }
        });

        cbbKH.setEditable(false);
        cbbKH.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        txtIDHD.setEditable(false);
        txtIDHD.setForeground(new java.awt.Color(255, 0, 51));
        txtIDHD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDHD.setFocusable(false);
        txtIDHD.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        txtNgayLap.setEditable(false);
        txtNgayLap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayLap.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        txtNhanVien.setEditable(false);
        txtNhanVien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        btnTimKHLe.setText("Khách Lẻ");
        btnTimKHLe.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTimKHLe.setRound(20);
        btnTimKHLe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKHLeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel16)
                .addGap(322, 397, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(cbbKH, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtIDHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTimKHLe, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIDHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel8)
                    .addComponent(btnTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTimKHLe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 102)));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 102));
        jLabel17.setText("Chi tiết hóa đơn");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("ID_MATHANG:");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 204));
        jLabel12.setText("SỐ LƯỢNG:");

        txtID_CTHD.setEditable(false);
        txtID_CTHD.setForeground(new java.awt.Color(255, 0, 51));
        txtID_CTHD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtID_CTHD.setFocusable(false);
        txtID_CTHD.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        txtSoLuong_CTHD.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        txtSoLuong_CTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtSoLuong_CTHDMousePressed(evt);
            }
        });

        btnThayDoiSL.setText("Thay Đổi");
        btnThayDoiSL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnThayDoiSL.setRound(20);
        btnThayDoiSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayDoiSLActionPerformed(evt);
            }
        });

        txtTen_CTHD.setEditable(false);
        txtTen_CTHD.setForeground(new java.awt.Color(0, 153, 102));
        txtTen_CTHD.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTen_CTHD.setFocusable(false);
        txtTen_CTHD.setFont(new java.awt.Font("Times New Roman", 1, 23)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setText("TÊN SẢN PHẨM:");

        btnXoaDong.setForeground(new java.awt.Color(255, 204, 0));
        btnXoaDong.setText("Xóa dòng này");
        btnXoaDong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnXoaDong.setRound(20);
        btnXoaDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel17)
                    .addComponent(btnXoaDong, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtID_CTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addComponent(txtTen_CTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong_CTHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnThayDoiSL, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtID_CTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTen_CTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtSoLuong_CTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateTabActionPerformed
        // TODO add your handling code here:
        frm_panel_BanHang_tabPhieuTam pt = new frm_panel_BanHang_tabPhieuTam(this);
        int index = (tab.getTabCount() + 1);
        if (index <= 5) {
            if (checkPhieuTamMax2()) {
                HoaDonDAO hdDAO = new HoaDonDAO();
                while (true) {
                    IDHd = randomIDHd();
                    if (hdDAO.kiemTraIDHD(IDHd).size() == 0) {
                        try {

                            //
                            Hoadon hd = new Hoadon();
                            hd.setIdHoadon(IDHd);
                            hd.setNgaylapHd(new Date());

                            //
                            Nhanvien nv = new Nhanvien();
                            nv.setManv(IdNhanVien);
                            hd.setManv(nv);

                            // Thêm vào CSDL.
                            hdDAO.insertHD(hd);

                            // Thêm thông tin vào tab.
                            pt.setIDHd(IDHd);
                            pt.setIsThanhToan(false); // Chưa thanh toán. Nếu true là thanh toán rồi có thể đóng tab.

                            // Load thông tin lên form.
                            txtIDHD.setText(IDHd);
                            java.util.Date utilDate = new Date();
                            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                            txtNgayLap.setText(sqlDate.toString());
                            txtNhanVien.setText(IdNhanVien);
                            txtThongBaoThanhToan.setText("");
                            panelHD.setBackground(Color.WHITE);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, "Hóa đơn chưa khởi tạo thành công - Hãy kiêm tra lại!");
                            continue;
                        }
                        break;
                    }
                }
                tab.addTab("Phiếu Tạm " + countPT + "  ", getIScaleImage("src\\BHX_IMG\\folderImages\\images\\icons\\page.png", 20, 20), pt, "Phiếu tạm !");
                danhSachPhieuTam.add(pt);
                tab.setSelectedComponent(pt);
                countPT++;
                return;
            }
            JOptionPane.showMessageDialog(this, "Bạn chỉ được phép làm việc với 2 tab phiếu tạm - hóa đơn !");
            return;
        }
        JOptionPane.showMessageDialog(this, "Bạn chỉ được phép tạo tối đa 5 Tab !");
    }//GEN-LAST:event_btnCreateTabActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }
        int count = 0;
        for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
            // Nếu chưa thanh toán.
            if (!banHang_tabPhieuTam.isIsThanhToan()) {
                count++;
            }
        }
        if (count > 0) {
            if (JOptionPane.showConfirmDialog(this, "Hiện tại có tất cả " + count + " hóa đơn chưa thanh toán \n Bạn có muốn xóa tất cả hóa đơn này không ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
                // Xóa phía dưới CSDL.
                HoaDonDAO hdDAO = new HoaDonDAO();
                for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
                    if (!banHang_tabPhieuTam.isIsThanhToan()) {
                        if (!hdDAO.deleteHD(banHang_tabPhieuTam.getIDHd())) {
                            // Nếu xóa không thành công thì out - báo lỗi.
                            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại trước khi xóa hóa đơn này !");
                            return;
                        }
                    }
                }
            } else {
                return;
            }
        }

        // Xóa toàn bộ danh sách hóa đơn đang lưu trữ.
        danhSachPhieuTam.clear();
        // set thông tin form về lại ban đầu.
        IDHd = "";
        countPT = 1;
        // Load thông tin lên form.
        clearForm();
        tab.removeAll();

        //
        setTxtTongTienHD(BigDecimal.ZERO);
        setTxtTongTienGiamGiaHD(BigDecimal.ZERO);
        setTxtTongSoLuongMhHD(BigDecimal.ZERO);
    }//GEN-LAST:event_btnDeleteAllActionPerformed

    private void btnAddCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCTHDActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng khởi tạo phiếu Tạm - Hóa đơn trước !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }

        if (!txtMaSP.getText().toString().isEmpty() && !IDHd.isEmpty()) {
            try {
                MatHangDAO mhDAO = new MatHangDAO();

                // Kiểm tra mặt hàng còn tồn kho hay không ? => Kiểm tra hết hàng.
                if (mhDAO.selectTonKhoMatHang(txtMaSP.getText().trim()) <= 0) {
                    JOptionPane.showMessageDialog(this, "Mặt hàng " + txtMaSP.getText().trim() + " đã hết hàng !", "Cảnh báo !", JOptionPane.WARNING_MESSAGE, null);
                    return;
                }

                // Nếu còn hàng thì thêm vào chi tiết hóa đơn.
                ChitiethoadonObj cthd = mhDAO.getDataTableMatHangWithObjectCTHD(txtMaSP.getText().trim(), IDHd).get(0);
                cthd.setMaHD(IDHd);

                // Set số lương cho sản phẩm cân kí.
                if ("true".equals(cthd.getIsKilogram().toLowerCase())) {
                    frm_CanKi canKiMH = new frm_CanKi(this, cthd.getTenSp(), cthd);
                    this.setEnabled(false);
                    canKiMH.setVisible(true);
                    canKiMH.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            // Nếu chưa cân kí không thêm vào.
                            if (cthd.getSoLuong().equals(new BigDecimal(-1))) {
                                return;
                            }
                            if (danhSachPhieuTam.get(tab.getSelectedIndex()).timKiemCTHD(cthd)) {
                                danhSachPhieuTam.get(tab.getSelectedIndex()).timKiemCTHDAndSumCTHD(cthd);
                                return;
                            }
                            danhSachPhieuTam.get(tab.getSelectedIndex()).setListCTHD(cthd);
                        }
                    });
                } else {
                    // Còn hàng nhưng không đủ só lượng.
                    // Tìm sản phẩm đã tồn tại trong tab và kiểm tra số lượng thêm vào cộng với số lượng hiện có có đủ để bán hay không?
                    try {
                        for (ChitiethoadonObj cthd_tow : this.getDanhSachPhieuTamToTabActive()) {
                            if (cthd_tow.getMaSp().equals(cthd.getMaSp())) {
                                BigDecimal sum_To_Row = cthd_tow.getSoLuong().add(cthd.getSoLuong()); // Cộng số lượng hiện tại với số lượng hiện có trong row chi tiết hóa đơn trong tab active.
                                // Còn hàng nhưng không đủ só lượng.
                                // Kiểm tra số lượng sau khi đã thay đỏi có đủ để bán không?
                                // Nếu mặt hàng còn hàng nhưng không đủ số lượng để bán đối với sản phẩm không cân ký.
                                double soLuongTonKho = mhDAO.selectTonKhoMatHang(cthd_tow.getMaSp());
                                if (soLuongTonKho > 0) {
                                    double soLuongObj = soLuongTonKho - sum_To_Row.doubleValue();
                                    if (soLuongObj < 0) {
                                        JOptionPane.showMessageDialog(this, "Mặt hàng " + cthd.getMaSp().trim() + " số lượng hiện không đủ để bán !" + "\nSố lượng hiện có trong kho: " + soLuongTonKho, "Cảnh báo !", JOptionPane.WARNING_MESSAGE, null);
                                        return;
                                    }
                                }
                                break;
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Lỗi hệ thống: Trong quá trình tìm sản phẩm đã tồn tại trong tab active - ERROR: Không thể tìm hoặc lỗi trong quá trình tìm !");
                        return;
                    }

                    // Kiểm tra số lượng sau khi đã thay đỏi có đủ để bán không?
                    // Nếu mặt hàng còn hàng nhưng không đủ số lượng để bán đối với sản phẩm không cân ký.
                    double soLuongTonKho = mhDAO.selectTonKhoMatHang(cthd.getMaSp());
                    if (soLuongTonKho > 0) {
                        double soLuongObj = soLuongTonKho - cthd.getSoLuong().doubleValue();
                        if (soLuongObj < 0) {
                            JOptionPane.showMessageDialog(this, "Mặt hàng " + cthd.getMaSp().trim() + " số lượng hiện không đủ để bán !" + "\nSố lượng hiện có trong kho: " + soLuongTonKho, "Cảnh báo !", JOptionPane.WARNING_MESSAGE, null);
                            return;
                        }
                    }

                    //
                    if (danhSachPhieuTam.get(tab.getSelectedIndex()).timKiemCTHD(cthd)) {
                        danhSachPhieuTam.get(tab.getSelectedIndex()).timKiemCTHDAndSumCTHD(cthd);
                        return;
                    }
                    danhSachPhieuTam.get(tab.getSelectedIndex()).setListCTHD(cthd);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm này !");
                return;
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Hãy nhập ID mặt hàng và Click vào Tab Phiếu Tạm - Hóa Đơn đang làm việc !");
    }//GEN-LAST:event_btnAddCTHDActionPerformed

    public ArrayList<frm_panel_BanHang_tabPhieuTam> getDanhSachPhieuTam() {
        return danhSachPhieuTam;
    }

    public ArrayList<ChitiethoadonObj> getDanhSachPhieuTamToTabActive() {
        return danhSachPhieuTam.get(tab.getSelectedIndex()).getListCTHD();
    }

    public void setDanhSachPhieuTam(ArrayList<frm_panel_BanHang_tabPhieuTam> danhSachPhieuTam) {
        this.danhSachPhieuTam = danhSachPhieuTam;
    }

    private void tabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabStateChanged
        // TODO add your handling code here:
        // Khi Chọn Tab load lại thông tin Hóa đơn và danh sách chi tiết hóa đơn của háo đơn đó.
        if (tab.countComponents() > 0) {
            try {
                frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
                for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
                    if (banHang_tabPhieuTam.getIDHd() == tabActive.getIDHd()) {
                        // Load lại thông tin ID HÓA ĐƠN NHAN VIÊN NGÀY LẬP CHO FORM.
                        HoaDonDAO hdDAO = new HoaDonDAO();
                        Hoadon hd;
                        hd = hdDAO.selectWithID(tabActive.getIDHd()).get(0);
                        // Load thông tin lên form.
                        txtIDHD.setText(hd.getIdHoadon());
                        txtNgayLap.setText(hd.getNgaylapHd().toString());
                        txtNhanVien.setText(hd.getManv().getManv());

                        // Load thông tin hóa đơn.
                        banHang_tabPhieuTam.loadListCTHD();
                        //
                        txtID_CTHD.setText("");
                        txtSoLuong_CTHD.setText("");
                        txtTen_CTHD.setText("");
                        txtMaSP.setText("");

                        // Nếu đã thanh toán.
                        if (tabActive.isIsThanhToan()) {
                            txtThongBaoThanhToan.setText("Đã Thanh Toán Thành Công !");
                            panelHD.setBackground(Color.orange);
                        }

                        // Nếu chưa thanh toán thì set về lại giao diện màu trắng.
                        if (!tabActive.isIsThanhToan()) {
                            txtThongBaoThanhToan.setText("");
                            panelHD.setBackground(Color.WHITE);
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                return;
            }
        }
    }//GEN-LAST:event_tabStateChanged

    private void btnCloseTabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseTabActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }

        // Xóa dữ liệu ra khỏi dánh sách.
        if (danhSachPhieuTam.size() > 0) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có muốn đóng Tab này không !", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
                frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
                // Nếu chưa thanh toán mà xóa thì xóa phái csdl.
                if (!tabActive.isIsThanhToan()) {
                    if (JOptionPane.showConfirmDialog(this, "HÓA ĐƠN " + tabActive.getIDHd() + "\nHiện tại hóa đơn này chưa thanh toán \n Bạn có muốn xóa hóa đơn này không ?", "Thông báo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {

                        // Xóa phía dưới CSDL do chưa thanh toán.
                        HoaDonDAO hdDAO = new HoaDonDAO();
                        if (!hdDAO.deleteHD(tabActive.getIDHd())) {
                            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại trước khi xóa hóa đơn này - Xóa không thành công !");
                            return;
                        }
                    } else {
                        // Nếu thoát.
                        return;
                    }
                }
                // Xóa dữ liệu trên giao diện.
                danhSachPhieuTam.remove(tab.getSelectedIndex());
                clearForm();
                //
                setTxtTongTienHD(BigDecimal.ZERO);
                setTxtTongTienGiamGiaHD(BigDecimal.ZERO);
                setTxtTongSoLuongMhHD(BigDecimal.ZERO);
                txtThongBaoThanhToan.setText("");
                panelHD.setBackground(Color.WHITE);
                //
                tab.remove(tabActive);
                return;
            }
        }
    }//GEN-LAST:event_btnCloseTabActionPerformed

    private void btnTimKiemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemSPActionPerformed
        // TODO add your handling code here:
        frm_TimKiemMatHang tkMH = new frm_TimKiemMatHang(this);
        this.setEnabled(false);
        tkMH.setVisible(true);
    }//GEN-LAST:event_btnTimKiemSPActionPerformed

    private void btnThayDoiSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayDoiSLActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }

        //
        if (txtID_CTHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng chi tiết hóa đơn cần chỉnh sửa !");
            return;
        }
        //
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            MatHang mh = mhDAO.kiemTraIsProductKilogram(txtID_CTHD.getText()).get(0);

            if (mh.getIsProductKilogram().toLowerCase().equals("true")) {
                JOptionPane.showMessageDialog(this, "Sản phẩm cân kí, không được phép chỉnh sửa số lượng !");
                return;
            }

            if (!isBigDecimal(txtSoLuong_CTHD.getText())) {
                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm phải là số nguyên và lớn hơn 0 !");
                return;
            }

            danhSachPhieuTam.forEach(item -> {
                // Kiểm tra số lượng sau khi đã thay đỏi có đủ để bán không?
                // Nếu mặt hàng còn hàng nhưng không đủ số lượng để bán đối với sản phẩm không cân ký.
                double soLuongTonKho = mhDAO.selectTonKhoMatHang(item.getIDMHRow());
                if (soLuongTonKho > 0) {
                    double soLuongObj = soLuongTonKho - convertToBigDecimal(txtSoLuong_CTHD.getText()).doubleValue();
                    if (soLuongObj < 0) {
                        JOptionPane.showMessageDialog(this, "Mặt hàng " + txtMaSP.getText().trim() + " sau khi thay đổi số lượng không đủ để bán !" + "\nSố lượng hiện có: " + soLuongTonKho, "Cảnh báo !", JOptionPane.WARNING_MESSAGE, null);
                        return;
                    }
                }
            });

            danhSachPhieuTam.get(tab.getSelectedIndex()).getListCTHD().forEach(item -> {
                if (item.getMaSp().equals(txtID_CTHD.getText())) {
                    // Nếu ok thì set lại.
                    item.setSoLuong(convertToBigDecimal(txtSoLuong_CTHD.getText()));
                }
            });
            danhSachPhieuTam.get(tab.getSelectedIndex()).loadListCTHD();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnThayDoiSLActionPerformed

    private void txtSoLuong_CTHDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSoLuong_CTHDMousePressed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }

        //
        if (txtID_CTHD.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng chi tiết hóa đơn cần chỉnh sửa !");
            return;
        }
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            MatHang mh = mhDAO.kiemTraIsProductKilogram(txtID_CTHD.getText()).get(0);
            if (mh.getIsProductKilogram().toLowerCase().equals("true")) {
                JOptionPane.showMessageDialog(this, "Sản phẩm cân kí, không được phép chỉnh sửa số lượng !");
                return;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_txtSoLuong_CTHDMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int count = 0;
        for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
            // Nếu chưa thanh toán.
            if (!banHang_tabPhieuTam.isIsThanhToan()) {
                count++;
            }
        }
        if (count > 0) {
            if (JOptionPane.showConfirmDialog(this, "Hiện tại có tất cả " + count + " hóa đơn chưa thanh toán \n Nếu thoát tất cả sẽ bị xóa và không thể khôi phục lại !", "Thông báo", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null) == JOptionPane.OK_OPTION) {
                // Xóa phía dưới CSDL.
                HoaDonDAO hdDAO = new HoaDonDAO();
                for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
                    // Nếu chưa thành toán mới xóa phía CSDL.
                    if (!banHang_tabPhieuTam.isIsThanhToan()) {
                        if (!hdDAO.deleteHD(banHang_tabPhieuTam.getIDHd())) {
                            // Nếu xóa không thành công thì out - báo lỗi.
                            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra lại trước khi xóa hóa đơn này !");
                            return;
                        }
                    }
                }
            } else {
                setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                return;
            }
        }

        // Xóa toàn bộ danh sách hóa đơn đang lưu trữ.
        danhSachPhieuTam.clear();
        // set thông tin form về lại ban đầu.
        IDHd = "";
        countPT = 1;
        // Load thông tin lên form.
        clearForm();
        tab.removeAll();

        //
        setTxtTongTienHD(BigDecimal.ZERO);
        setTxtTongTienGiamGiaHD(BigDecimal.ZERO);
        setTxtTongSoLuongMhHD(BigDecimal.ZERO);

        // Kiểm tra form main có không thì bật lại.
        if (this.main != null) {
            this.main.setEnabled(true);
        }

        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnXoaDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDongActionPerformed
        // TODO add your handling code here:
        //
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }

        //
        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }

        // Kiểm tra có danh sách sản phẩm hay không:
        if (danhSachPhieuTam.get(tab.getSelectedIndex()).getListCTHD().size() <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào hóa đơn !");
            return;
        }

        //
        try {
            // Lấy vị trí cần xóa:
            int index = danhSachPhieuTam.get(tab.getSelectedIndex()).getSelectIndexTable();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng chi tiết hóa đơn cần xóa !");
                return;
            }
            // Xóa nó đi
            danhSachPhieuTam.get(tab.getSelectedIndex()).getListCTHD().remove(index);
            // Load lại.
            danhSachPhieuTam.get(tab.getSelectedIndex()).loadListCTHD();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnXoaDongActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        // Xử lý thanh toán hóa đơn.
        // Lấy Tab hiện tại.
        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();

        // KHông có tab nào.
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab nào !");
            return;
        }

        // Xử lí hóa đơn có sản phẩm nào được thêm vào hay chưa.
        int size = this.getDanhSachPhieuTamToTabActive().size();
        if (size <= 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng thêm sản phẩm vào hóa đơn trước khi thanh toán hóa đơn có ID: " + tabActive.getIDHd());
            return;
        }

        // Xử lý nhân viên đã nhập số tiền khách gửi lại hay chưa.
        if (txtTienKHGui.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập số tiền khách hàng gửi trước khi thực hiện thanh toán cho hóa đơn có ID: " + tabActive.getIDHd());
            return;
        }

        // Kiểm tra đã thanh toán chưa. => true là đã thanh toán.
        if (!tabActive.isIsThanhToan()) {
            // Xử lí nếu chưa thanh toán.
            ArrayList<ChitietHoadon> listCTHD_New = new ArrayList<>();
            // Lấy list chi tiết hóa đơn trong tab đang làm việc lưu xuống database.
            for (frm_panel_BanHang_tabPhieuTam banHang_tabPhieuTam : danhSachPhieuTam) {
                if (banHang_tabPhieuTam.getIDHd() == tabActive.getIDHd()) {

                    // Lấy thông tin chi tiết hóa đơn lưu vào danh sách thanh toán.
                    for (ChitiethoadonObj chitietHoadonObj : banHang_tabPhieuTam.getListCTHD()) {
                        // 
                        MatHang mh = new MatHang();
                        mh.setMamh(chitietHoadonObj.getMaSp());
                        //
                        Hoadon hd = new Hoadon();
                        hd.setIdHoadon(chitietHoadonObj.getMaHD());
                        //
                        ChitietHoadon cthd_New = new ChitietHoadon();
                        cthd_New.setHoadon(hd);
                        cthd_New.setMatHang(mh);
                        cthd_New.setSoluong(chitietHoadonObj.getSoLuong());
                        // Thêm vào chi tiết hóa đơn.
                        listCTHD_New.add(cthd_New);
                    }

                    // Đưa vào CSDL.
                    try {
                        // Trước khi lưu thông tin chi tiết hóa đơn, cần cập nhật thông tin tiền khách gửi trước.
                        HoaDonDAO hd_DAO = new HoaDonDAO();
                        BigDecimal tongTienHD = danhSachPhieuTam.get(tab.getSelectedIndex()).getTongtien();
                        if (Double.parseDouble(txtTienKHGui.getText() + "000") < tongTienHD.doubleValue()) {
                            JOptionPane.showMessageDialog(this, "Số tiền khách hàng gửi để thanh toán phải lớn hơn tổng tiền của hóa đơn !" + "\nSố tiền bạn nhập: " + txtTienKHGui.getText() + ".000 đ" + "\nSố tiền hóa đơn: " + formatterCurrencyVND(tongTienHD), "Lỗi", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        if (!hd_DAO.updateHD(banHang_tabPhieuTam.getIDHd(), convertToBigDecimal(txtTienKHGui.getText() + "000"))) {
                            JOptionPane.showMessageDialog(this, "Hãy kiểm tra số tiền khách gửi " + "\nKhông thành công khi cập nhật số tiền khách gửi cho hóa đơn !");
                            return;
                        }
                        ChitiethoadonDAO cthd_DAO = new ChitiethoadonDAO();
                        cthd_DAO.insertData(listCTHD_New);

                        // Hoàn tất xong tính tiền thối lại.
                        BigDecimal tienThoiLai = convertToBigDecimal(txtTienKHGui.getText() + "000").subtract(tongTienHD);
                        txttienTraLai.setText(formatterCurrencyVND(tienThoiLai));
                    } catch (Exception e) {
                        // Nếu có lỗi thông báo và out.
                        JOptionPane.showMessageDialog(this, "Thanh toán hóa đơn " + tabActive.getIDHd() + " Không thành công !");
                        return;
                    }

                    // Set thông tin hóa đơn này về trạng thái đã thanh toán.
                    banHang_tabPhieuTam.setIsThanhToan(true);

                    // Thành công thây đổi giáo diện.
                    txtThongBaoThanhToan.setText("Đã Thanh Toán Thành Công !");
                    panelHD.setBackground(Color.orange);
                    tabActive.setBackground(Color.orange);
                }
            }
        }
        // Nếu thanh toán rồi thì thông báo xóa nó đi.
        JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
        return;

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTimKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab - hóa đơn nào !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }
    }//GEN-LAST:event_btnTimKHActionPerformed

    private void btnTimKHLeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKHLeActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab - Hóa đơn nào !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            // Nếu thanh toán rồi thì thông báo xóa nó đi.
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nTrạng thái: Đã hoàn tất thanh toán !" + "\nVui lòng in hóa đơn và đóng đóng tab hóa đơn này !");
            return;
        }

        // Set hóa đơn khách lẻ.
        danhSachKH.forEach(item -> {
            if (item.getMakh().toUpperCase().equals("KHACH-HANG-BAN-LE")) {
                cbbKH.setSelectedItem(item);
            }
        });
    }//GEN-LAST:event_btnTimKHLeActionPerformed

    private void btnInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoActionPerformed
        // TODO add your handling code here:
        // Kiểm tả thông tin nhân viên có chưa.
        if (IdNhanVien.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không thể xem thông tin nhân viên !");
            return;
        }

        // Lấy thông tin truyên cho frm.
        frm_QuanLyNhanVien Info_QLNV = new frm_QuanLyNhanVien(this, this.IdNhanVien.trim());
        this.setEnabled(false);
        Info_QLNV.setVisible(true);
    }//GEN-LAST:event_btnInfoActionPerformed

    private void btnInHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHoaDonActionPerformed
        // TODO add your handling code here:
        if (tab.countComponents() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có Tab - hóa đơn nào !");
            return;
        }

        frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
        if (tabActive.isIsThanhToan()) {
            try {
                //
                ReportManager.getInstance().compileReport();
                //
                ReportManager.getInstance().printReportHoaDon(getData());
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nXuất hóa đơn không thành công !");
                return;
            }
            JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nXuất hóa đơn thành công !");
            return;
        }
        JOptionPane.showMessageDialog(this, "Hóa đơn ID: " + tabActive.getIDHd() + "\nChưa thanh toán !");
    }//GEN-LAST:event_btnInHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(frm_Main_BanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Main_BanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Main_BanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Main_BanHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Main_BanHang().setVisible(true);
            }
        });
    }

    private ReportHoaDonObj getData() {
        // Lấy hóa đơn từ database lên.
        ReportHoaDonObj hdObj_report = null;
        try {
            frm_panel_BanHang_tabPhieuTam tabActive = (frm_panel_BanHang_tabPhieuTam) tab.getSelectedComponent();
            if (tabActive.isIsThanhToan()) {
                try {
                    HoaDonDAO hd_DAO_report = new HoaDonDAO();
                    String idhd = tabActive.getIDHd();
                    hdObj_report = hd_DAO_report.getHoaDonAndChiTiet(idhd);
                } catch (Exception e) {
                    return hdObj_report;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hdObj_report;
    }

    private void clearForm() {
        txtIDHD.setText("");
        txtNgayLap.setText("");
        txtNhanVien.setText("");
        txtID_CTHD.setText("");
        txtSoLuong_CTHD.setText("");
        txtTen_CTHD.setText("");
        txtTongSoLuongMH.setText("");
        txtTongTienGiamGia.setText("");
        txtTongTienHD.setText("");
        txtMaSP.setText("");
        txtTienKHGui.setText("");
        txttienTraLai.setText("");
        txtThongBaoThanhToan.setText("");
        panelHD.setBackground(Color.WHITE);
        // Set hóa đơn khách lẻ.
        danhSachKH.forEach(item -> {
            if (item.getMakh().toUpperCase().equals("KHACH-HANG-BAN-LE")) {
                cbbKH.setSelectedItem(item);
            }
        });
    }

    private ImageIcon getIScaleImage(String url, int w, int h) {
        ImageIcon icon = new ImageIcon(url);
        Image img = icon.getImage();
        Image scale = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
        ImageIcon scalIcon = new ImageIcon(scale);
        return scalIcon;
    }

    private boolean checkPhieuTamMax2() {
        int count = 1;
        frm_panel_BanHang_tabPhieuTam pn = new frm_panel_BanHang_tabPhieuTam();
        for (int i = 0; i < tab.getTabCount(); i++) {
            try {
                frm_panel_BanHang_tabPhieuTam pN = (frm_panel_BanHang_tabPhieuTam) tab.getTabComponentAt(i);
                count++;
            } catch (Exception e) {
            }
        }
        if (count <= 2) {
            return true;
        }
        return false;
    }

    public void loadCbbKhachHang() {
        try {
            KhachHangDAO khDAO = new KhachHangDAO();
            danhSachKH = new ArrayList<>();
            danhSachKH = khDAO.select();
            cbbKH.removeAllItems();
            danhSachKH.forEach(item -> {
                cbbKH.addItem(item);
            });
            // Set hóa đơn khách lẻ.
            danhSachKH.forEach(item -> {
                if (item.getMakh().toUpperCase().equals("KHACH-HANG-BAN-LE")) {
                    cbbKH.setSelectedItem(item);
                }
            });
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String randomIDHd() {
        StringBuilder invoice = new StringBuilder("HD");
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = random.nextInt(10);
            invoice.append(randomNumber);
        }

        return invoice.toString();
    }

    public void setInfoCTHD(String Id, String ten, BigDecimal soLuong) {
        if (Id.isEmpty()) {
            txtID_CTHD.setText("");
            txtTen_CTHD.setText("");
            txtSoLuong_CTHD.setText("");
            return;
        }

        txtID_CTHD.setText(Id);
        txtTen_CTHD.setText(ten);
        try {
            MatHangDAO mhDAO = new MatHangDAO();
            MatHang mh = mhDAO.kiemTraIsProductKilogram(txtID_CTHD.getText()).get(0);
            txtSoLuong_CTHD.setText(soLuong.setScale(3, RoundingMode.HALF_UP).toString());
            if (mh.getIsProductKilogram().toLowerCase().equals("false")) {
                txtSoLuong_CTHD.setText(soLuong.setScale(0, RoundingMode.HALF_UP).toString());
                return;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public static String formatterCurrencyVND(BigDecimal price) {
        Locale locale = new Locale("vi", "VN");
        Currency currency = Currency.getInstance("VND");
        DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
        df.setCurrency(currency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        return numberFormat.format(price);
    }

    public void setTxtTongSoLuongMhHD(BigDecimal tong) {
        txtTongSoLuongMH.setText(tong.setScale(0, RoundingMode.HALF_UP).toString());
    }

    public void setTxtTongTienGiamGiaHD(BigDecimal tong) {
        txtTongTienGiamGia.setText(formatterCurrencyVND(tong));
    }

    public void setTxtTongTienHD(BigDecimal tong) {
        txtTongTienHD.setText(formatterCurrencyVND(tong));
    }

    public void setTxtMaSP(String maSP) {
        txtMaSP.setText(maSP);
    }

    public static BigDecimal convertToBigDecimal(String str) {
        try {
            return new BigDecimal(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static boolean isBigDecimal(String str) {
        try {
            BigDecimal big = new BigDecimal(str);
            return big.compareTo(new BigDecimal(0)) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void checkInput() {
        String text = txtTienKHGui.getText() + "000";
        try {
            Double.parseDouble(text);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng chỉ nhập số thực - VD: 1.600.000 Đồng => Nhập 1600 (Không nhập phần nghìn)!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            try {
                txtTienKHGui.setText("");
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BHX_Swings.bhx.swing.button.ButtonCustom btnAddCTHD;
    private javax.swing.JButton btnCloseTab;
    private javax.swing.JButton btnCreateTab;
    private javax.swing.JButton btnDeleteAll;
    private BHX_Swings.bhx.swing.button.btn2 btnInHoaDon;
    private javax.swing.JButton btnInfo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnReport;
    private BHX_Swings.bhx.swing.button.btn2 btnThanhToan;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnThayDoiSL;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnTimKH;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnTimKHLe;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnTimKiemSP;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnXoaDong;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbKH;
    private javax.swing.JLabel imageLogo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel panelHD;
    private javax.swing.JTabbedPane tab;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtIDHD;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtID_CTHD;
    private javax.swing.JTextField txtMaSP;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNgayLap;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNhanVien;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtSoLuong_CTHD;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTen_CTHD;
    private javax.swing.JLabel txtThongBaoThanhToan;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTienKHGui;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTongSoLuongMH;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTongTienGiamGia;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTongTienHD;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txttienTraLai;
    // End of variables declaration//GEN-END:variables
}
