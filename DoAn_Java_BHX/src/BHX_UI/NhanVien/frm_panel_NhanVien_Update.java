/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BHX_UI.NhanVien;

import BHX_DAO.NhanVienDAO;
import BHX_DAO.QuanHuyenDAO;
import BHX_DAO.QueQuanNVDAO;
import BHX_DAO.TinhThanhDAO;
import BHX_DAO.XaPhuongDAO;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.QuequanNhanvien;
import BHX_MODEL.Database.model.Tinhthanh;
import BHX_MODEL.Database.model.XaPhuong;
import BHX_Swings.bhx.swing.datechooser.EventDateChooser;
import BHX_Swings.bhx.swing.datechooser.SelectedAction;
import BHX_Swings.bhx.swing.datechooser.SelectedDate;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.shape.Path;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author VanPhu
 */
public class frm_panel_NhanVien_Update extends javax.swing.JPanel {

    private String IdNV;
    private JFrame main;
    private ArrayList<Tinhthanh> dsTinhThanh = new ArrayList<>();
    private ArrayList<QuanHuyen> dsQuanHuyen = new ArrayList<>();
    private ArrayList<XaPhuong> dsPhuongXa = new ArrayList<>();
    private static String srcImg = "src/BHX_IMG/folderImages/images/staff/";
    private String srcImg_new = null;
    private String selectedFilePath = null;

    /**
     * Creates new form frm_panel_NhanVien
     */
    public frm_panel_NhanVien_Update() {
        initComponents();
        dateChooserNS.setTextRefernce(txtNgaySinh);
        dateChooserNS.setDateFormat("yyyy-MM-dd");
        dateChooserNS.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooserNS.hidePopup();
                }
            }
        });

        dateChooserNVL.setTextRefernce(txtNgayVL);
        dateChooserNVL.setDateFormat("yyyy-MM-dd");
        dateChooserNVL.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooserNVL.hidePopup();
                }
            }
        });
        image.setSize(600, 600);
        loadCbbTinh();
    }

    public frm_panel_NhanVien_Update(String IdNV) {
        this.main = main;
        this.IdNV = IdNV;
        initComponents();
        dateChooserNS.setTextRefernce(txtNgaySinh);
        dateChooserNS.setDateFormat("yyyy-MM-dd");
        dateChooserNS.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooserNS.hidePopup();
                }
            }
        });

        dateChooserNVL.setTextRefernce(txtNgayVL);
        dateChooserNVL.setDateFormat("yyyy-MM-dd");
        dateChooserNVL.addEventDateChooser(new EventDateChooser() {
            @Override
            public void dateSelected(SelectedAction action, SelectedDate date) {
                if (action.getAction() == SelectedAction.DAY_SELECTED) {
                    dateChooserNVL.hidePopup();
                }
            }
        });
        image.setSize(600, 600);
        loadCbbTinh();
        cbbTinh.setSelectedIndex(-1);
        cbbQuan.setSelectedIndex(-1);
        cbbXa.setSelectedIndex(-1);
    }

    public void loadCbbTinh() {
        try {
            TinhThanhDAO ttDAO = new TinhThanhDAO();
            dsTinhThanh.clear();
            dsTinhThanh = ttDAO.getAllTinhThanh();
            cbbTinh.removeAllItems();
            for (Tinhthanh tinhthanh : dsTinhThanh) {
                cbbTinh.addItem(tinhthanh);
            }
            cbbTinh.setSelectedIndex(-1);
            cbbQuan.removeAllItems();
            cbbXa.removeAllItems();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadCbbHuyen() {
        try {
            QuanHuyenDAO qhDAO = new QuanHuyenDAO();
            dsQuanHuyen.clear();
            dsQuanHuyen = qhDAO.getAllQuanHuyen();
            cbbQuan.removeAllItems();
            for (QuanHuyen quanHuyen : dsQuanHuyen) {
                cbbQuan.addItem(quanHuyen);
            }
            cbbQuan.setSelectedIndex(-1);
            cbbXa.removeAllItems();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void loadCbbXa() {
        try {
            XaPhuongDAO xpDAO = new XaPhuongDAO();
            dsPhuongXa.clear();
            dsPhuongXa = xpDAO.getAllXaPhuong();
            cbbXa.removeAllItems();
            for (XaPhuong xaPhuong : dsPhuongXa) {
                cbbXa.addItem(xaPhuong);
            }
            cbbXa.setSelectedIndex(-1);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
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
                    txtNgaySinh.setText(nv.getNgaysinh().toString());
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
                    txtDuong.setText((!tenDuong.isEmpty() ? tenDuong : ""));
                    // Load tỉnh.
                    Tinhthanh tt = new Tinhthanh(qqnv.getTinhthanh().getMatinhthanh());
                    cbbTinh.setSelectedItem(tt);
                    // Load quận.
                    QuanHuyen qh = new QuanHuyen(qqnv.getQuanHuyen().getMaquanHuyen());
                    cbbQuan.setSelectedItem(qh);
                    // Load xã.
                    XaPhuong xp = new XaPhuong(qqnv.getXaPhuong().getMaxaPhuong());
                    cbbXa.setSelectedItem(xp);
                } else {
                    // Nếu nhân viên này chưa cập nhật quê quán thì laod lại Tỉnh như thường.
                    loadCbbTinh();
                    cbbTinh.setSelectedIndex(-1);
                    cbbQuan.setSelectedIndex(-1);
                    cbbXa.setSelectedIndex(-1);
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

    private void kiemTraThongTin(StringBuilder str) {
        if (txtTen.getText().isEmpty()) {
            str.append("Vui lòng nhập tên nhân viên !\n");
        }
        if (txtNgaySinh.getText().isEmpty()) {
            str.append("Vui lòng chọn ngày sinh !\n");
        }
        if (txtChucVu.getText().isEmpty()) {
            str.append("Vui lòng nhập chức vụ nhân viên !\n");
        }
        if (txtNgayVL.getText().isEmpty()) {
            str.append("Vui lòng chọn ngày vào làm !\n");
        }
        if (txtHSL.getText().isEmpty()) {
            str.append("Vui lòng nhập hệ số lương !\n");
        } else {
            try {
                double hsl = Double.parseDouble(txtHSL.getText());
                if (hsl < 0) {
                    str.append("Vui lòng nhập hệ số lương lớn hơn không !\n");
                }
            } catch (NumberFormatException e) {
                str.append("Vui lòng nhập hệ số lương là số và lớn hơn không !\n");
            }
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

        dateChooserNS = new BHX_Swings.bhx.swing.datechooser.DateChooser();
        dateChooserNVL = new BHX_Swings.bhx.swing.datechooser.DateChooser();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        image = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtID = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        txtTen = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel6 = new javax.swing.JLabel();
        txtNgaySinh = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtHocVan = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel9 = new javax.swing.JLabel();
        txtChucVu = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnUpdate = new BHX_Swings.bhx.swing.button.ButtonCustom();
        btnLoadSt = new BHX_Swings.bhx.swing.button.ButtonCustom();
        txtNgayVL = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel13 = new javax.swing.JLabel();
        txtSDT = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        btnCNSinh = new BHX_Swings.bhx.swing.button.ButtonCustom();
        jPanel2 = new javax.swing.JPanel();
        rdoNam = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        rdoNu = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        rdoKhac = new BHX_Swings.bhx.swing.radio_button.RadioButtonCustom();
        txtHSL = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        txtCCCD = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        btnCNVL = new BHX_Swings.bhx.swing.button.ButtonCustom();
        btnNew = new BHX_Swings.bhx.swing.button.ButtonCustom();
        btnNull = new BHX_Swings.bhx.swing.button.ButtonCustom();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbTinh = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel16 = new javax.swing.JLabel();
        cbbQuan = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        jLabel17 = new javax.swing.JLabel();
        cbbXa = new BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion();
        txtDuong = new BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion();
        jLabel18 = new javax.swing.JLabel();
        btnReset = new BHX_Swings.bhx.swing.button.ButtonCustom();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 102));
        jLabel1.setText("Cập nhật thông tin nhân viên");

        image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        image.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 0, 0));
        jLabel3.setText("Mã nhân viên:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 102));
        jLabel4.setText("Hình ảnh Nhân viên");

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

        txtNgaySinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

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

        btnUpdate.setText("Cập nhật Nhân viên");
        btnUpdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnLoadSt.setText("Load StartUp");
        btnLoadSt.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLoadSt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadStActionPerformed(evt);
            }
        });

        txtNgayVL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 102));
        jLabel13.setText("Số điện thoại:");

        txtSDT.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        btnCNSinh.setText("Chọn Ngày");
        btnCNSinh.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCNSinh.setRound(15);
        btnCNSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCNSinhActionPerformed(evt);
            }
        });

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
                .addComponent(rdoNam, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdoNu, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(rdoKhac, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addGap(520, 520, 520))
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

        btnCNVL.setText("Chọn Ngày");
        btnCNVL.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnCNVL.setRound(15);
        btnCNVL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCNVLActionPerformed(evt);
            }
        });

        btnNew.setText("Load Ảnh Mới");
        btnNew.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnNull.setText("Set Null");
        btnNull.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNull.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNullActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 102));
        jLabel14.setText("Địa chỉ:");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 102));
        jLabel15.setText("Tỉnh thành:");

        cbbTinh.setEditable(false);
        cbbTinh.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cbbTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTinhActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 153, 102));
        jLabel16.setText("Quận - Huyện:");

        cbbQuan.setEditable(false);
        cbbQuan.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        cbbQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbQuanActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 153, 102));
        jLabel17.setText("Xã - Phường:");

        cbbXa.setEditable(false);
        cbbXa.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N

        txtDuong.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 102));
        jLabel18.setText("Đường:");

        btnReset.setText("Reset Adress");
        btnReset.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbbXa, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLoadSt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(786, 786, 786)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHSL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNgayVL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCNVL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtChucVu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHocVan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnCNSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btnCNVL, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel14)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                            .addComponent(cbbQuan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbXa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel4)
                            .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNull, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadSt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCNSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCNSinhActionPerformed
        // TODO add your handling code here:
        dateChooserNS.showPopup();
    }//GEN-LAST:event_btnCNSinhActionPerformed

    private void btnCNVLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCNVLActionPerformed
        // TODO add your handling code here:
        dateChooserNVL.showPopup();
    }//GEN-LAST:event_btnCNVLActionPerformed

    private void btnLoadStActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadStActionPerformed
        // TODO add your handling code here:
        if (!IdNV.isEmpty()) {
            try {
                loadInfo(IdNV);
            } catch (Exception e) {
            }
            return;
        }
        JOptionPane.showMessageDialog(this, "Load thông tin không thành công !");
    }//GEN-LAST:event_btnLoadStActionPerformed

    private void cbbQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbQuanActionPerformed
        // TODO add your handling code here:
        QuanHuyen qh = (QuanHuyen) cbbQuan.getSelectedItem();
        if (qh != null) {
            XaPhuongDAO xp = new XaPhuongDAO();
            dsPhuongXa = xp.loadXaPhuongWithIDHuyen(qh.getMaquanHuyen());
            if (dsPhuongXa.size() > 0) {
                cbbXa.removeAllItems();
                for (XaPhuong xaPhuong : dsPhuongXa) {
                    cbbXa.addItem(xaPhuong);
                }
                cbbXa.setSelectedIndex(-1);
            }
        }
    }//GEN-LAST:event_cbbQuanActionPerformed

    private void btnNullActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNullActionPerformed
        // TODO add your handling code here:
        image.setIcon(null);
        srcImg_new = selectedFilePath = null;
        // Set hình ảnh null.png
        try {
            BufferedImage originalImage = ImageIO.read(new File("src/BHX_IMG/folderImages/images/staff/null.png"));
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
    }//GEN-LAST:event_btnNullActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "bmp"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            selectedFilePath = selectedFile.getAbsolutePath();
            srcImg_new = selectedFile.getName();
            try {
                BufferedImage originalImage = ImageIO.read(new File(selectedFilePath));
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
        }
    }//GEN-LAST:event_btnNewActionPerformed

    private void cbbTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTinhActionPerformed
        // TODO add your handling code here:
        Tinhthanh tt = (Tinhthanh) cbbTinh.getSelectedItem();
        if (tt != null) {
            QuanHuyenDAO qh = new QuanHuyenDAO();
            dsQuanHuyen = qh.loadQuanHuyenWithIDTinh(tt.getMatinhthanh());
            if (dsQuanHuyen.size() > 0) {
                cbbQuan.removeAllItems();
                for (QuanHuyen quanHuyen : dsQuanHuyen) {
                    cbbQuan.addItem(quanHuyen);
                }
                cbbQuan.setSelectedIndex(-1);
                cbbXa.removeAllItems();
            }
        }
    }//GEN-LAST:event_cbbTinhActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        // Kiểm tra thông tin trước khi đưa xuống CSDL.
        if (txtID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng kiểm tra Mã nhân viên - Không xác định được nhân viên cần cập nhật thông tin !");
            return;
        }
        StringBuilder str = new StringBuilder();
        kiemTraThongTin(str);
        if (str.length() > 0) {
            JOptionPane.showMessageDialog(this, str, "Cảnh báo !", JOptionPane.WARNING_MESSAGE, null);
            return;
        }

        // Xử lí hợp lệ.
        try {
            // Lấy thông tin ép thành đối tượng.
            Nhanvien nv = new Nhanvien();
            if (selectedFilePath != null && srcImg_new != null) {
                // Xử lí Load file ảnh vào thư mục lưu ảnh.
                String sourceFilePath = selectedFilePath;
                String destinationDirectory = srcImg;
                try {
                    File sourceFile = new File(sourceFilePath);
                    if (!sourceFile.exists() || !sourceFile.isFile()) {
                        System.out.println("Tệp nguồn không tồn tại hoặc không phải là một tệp.");
                        return;
                    }
                    File destinationDirectoryFile = new File(destinationDirectory);
                    if (!destinationDirectoryFile.exists() || !destinationDirectoryFile.isDirectory()) {
                        System.out.println("Thư mục đích không tồn tại hoặc không phải là một thư mục.");
                        return;
                    }
                    File destinationFile = new File(destinationDirectoryFile, sourceFile.getName());
                    Files.copy(sourceFile.toPath(), destinationFile.toPath());
                    nv.setPicture(srcImg_new);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Không thể load hình ảnh vào thư mục !");
                    return;
                }
            } else {
                nv.setPicture("null.png");
            }

            nv.setManv(txtID.getText());
            nv.setTennv(txtTen.getText());
            if (rdoNam.isSelected() == true) {
                nv.setGioitinh("Nam");
            } else if (rdoNu.isSelected() == true) {
                nv.setGioitinh("Nữ");
            } else {
                nv.setGioitinh("Khác");
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                Date ngaySinh = sdf.parse(txtNgaySinh.getText());
                Date ngayVaoLam = sdf.parse(txtNgayVL.getText());

                nv.setNgaysinh(ngaySinh);
                nv.setNgayvaolam(ngayVaoLam);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thất bại - Sai định dạng ngày tháng năm !");
                return;
            }

            nv.setPhone(txtSDT.getText());
            nv.setChucvu(txtChucVu.getText());
            nv.setHesoluong(new BigDecimal(txtHSL.getText()));
            nv.setTrinhdohocvan(txtHocVan.getText());
            nv.setCccd(txtCCCD.getText());
            NhanVienDAO nvDAO = new NhanVienDAO();

            // Quê quán.
            QuequanNhanvien qqnv = new QuequanNhanvien();
            qqnv.setNhanvien(nv);

            Object tinhThanhItem = cbbTinh.getSelectedItem();
            Tinhthanh tinhThanh = tinhThanhItem != null ? (Tinhthanh) tinhThanhItem : null;

            Object quanHuyenItem = cbbQuan.getSelectedItem();
            QuanHuyen quanHuyen = quanHuyenItem != null ? (QuanHuyen) quanHuyenItem : null;

            Object xaPhuongItem = cbbXa.getSelectedItem();
            XaPhuong xaPhuong = xaPhuongItem != null ? (XaPhuong) xaPhuongItem : null;

            boolean atLeastOneSelected = tinhThanh != null && quanHuyen != null && xaPhuong != null && ( txtDuong.getText() != "");

            if (!atLeastOneSelected) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin địa chỉ - quê quán !" + "\nNếu không, không cần nhập => Nhấn nút Reset và để trống !");
                return;
            } else {
                qqnv.setTenduong(txtDuong.getText());
                qqnv.setTinhthanh(tinhThanh);
                qqnv.setQuanHuyen(quanHuyen);
                qqnv.setXaPhuong(xaPhuong);
                nvDAO.updateQueQuan(IdNV, qqnv);
            }

            //
            nvDAO.updateNhanVien(nv);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thất bại !");
            return;
        }
        JOptionPane.showMessageDialog(this, "Cập nhật thông tin nhân viên thành công !");
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtDuong.setText("");
        cbbTinh.setSelectedIndex(-1);
        cbbQuan.setSelectedIndex(-1);
        cbbXa.setSelectedIndex(-1);

    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private BHX_Swings.bhx.swing.button.ButtonCustom btnCNSinh;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnCNVL;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnLoadSt;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnNew;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnNull;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnReset;
    private BHX_Swings.bhx.swing.button.ButtonCustom btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbQuan;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbTinh;
    private BHX_Swings.bhx.swing.combobox.ComboBoxSuggestion cbbXa;
    private BHX_Swings.bhx.swing.datechooser.DateChooser dateChooserNS;
    private BHX_Swings.bhx.swing.datechooser.DateChooser dateChooserNVL;
    private javax.swing.JLabel image;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtDuong;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtHSL;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtHocVan;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtID;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNgaySinh;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtNgayVL;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtSDT;
    private BHX_Swings.bhx.swing.textfield_suggestion.TextFieldSuggestion txtTen;
    // End of variables declaration//GEN-END:variables
}
