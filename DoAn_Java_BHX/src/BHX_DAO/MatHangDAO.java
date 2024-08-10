package BHX_DAO;

import BHX_MODEL.Database.model.Hoadon;
import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Object.model.ChitiethoadonObj;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class MatHangDAO {

    private ArrayList<ChitiethoadonObj> list;
    private ArrayList<MatHang> danhSachMH;
    private ArrayList<String> danhSachDVT;

    public MatHangDAO() {
    }

    public ArrayList<ChitiethoadonObj> getDataTableMatHangWithObjectCTHD(String maSP, String maHD) {
        DbConnection conn = new DbConnection();
        this.list = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN, gg.SO_PHAN_TRAM, gg.ID, mh.IsProductKilogram\n"
                    + "FROM MAT_HANG mh\n"
                    + "LEFT JOIN (\n"
                    + "    SELECT MAMH, MAX(LAN) AS MAX_LAN\n"
                    + "    FROM GIAM_GIA\n"
                    + "    GROUP BY MAMH\n"
                    + ") max_gg ON mh.MAMH = max_gg.MAMH\n"
                    + "LEFT JOIN GIAM_GIA gg ON max_gg.MAMH = gg.MAMH AND max_gg.MAX_LAN = gg.LAN\n"
                    + "WHERE mh.MAMH = ?;";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maSP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String maMH = rs.getString(1);
                String tenMH = rs.getString(2);
                String pic = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal giaBan = rs.getBigDecimal(5);
                BigDecimal phanTram = rs.getBigDecimal(6);
                String ID = rs.getString(7);
                String IsProductKilogram = rs.getString(8);
                if (maMH == null) {
                    maMH = ""; // hoặc giá trị mặc định khác
                }
                if (tenMH == null) {
                    tenMH = "";
                }
                if (pic == null) {
                    pic = "";
                }
                if (dvt == null) {
                    dvt = "";
                }
                if (giaBan == null) {
                    giaBan = BigDecimal.ZERO; // hoặc giá trị mặc định khác
                }
                if (phanTram == null) {
                    phanTram = BigDecimal.ZERO; // hoặc giá trị mặc định khác
                }
                if (ID == null) {
                    ID = "";
                }

                if ("true".equals(IsProductKilogram.toLowerCase())) {

                }
//                String maHD, String maSp, String tenSp, String hinhAnhSp, String dvt, String ID, BigDecimal giaBanSp, BigDecimal giamGia, BigDecimal soLuong
                ChitiethoadonObj cd = new ChitiethoadonObj(maHD, maSP, tenMH, pic, dvt, ID, giaBan, phanTram, new BigDecimal(1), IsProductKilogram);
                if ("true".equals(IsProductKilogram.toLowerCase())) {
                    cd = new ChitiethoadonObj(maHD, maSP, tenMH, pic, dvt, ID, giaBan, phanTram, new BigDecimal(-1), IsProductKilogram);
                }
                this.list.add(cd);
            }
        } catch (SQLException e) {
            this.list.clear();
            return this.list;
        } finally {
            conn.getClose();
        }
        return this.list;
    }

    public ArrayList<MatHang> select() {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT * FROM MAT_HANG";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(8);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> locTheoNhomLoai(String maNhomLoai) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh, NHOM_LOAI_MATHANG nl, LOAI_MATHANG l\n"
                    + " WHERE mh.MALOAI = l.MALOAI AND l.MANHOM_LOAI = nl.MANHOM_LOAI AND nl.MANHOM_LOAI = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maNhomLoai);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(5);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> locTheoLoai(String maNhomLoai) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh,  LOAI_MATHANG l\n"
                    + "WHERE mh.MALOAI = l.MALOAI AND l.MALOAI = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maNhomLoai);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(5);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> timKiem(String search) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh "
                    + "WHERE mh.TENMH LIKE ? OR mh.MAMH LIKE ? OR mh.DONVITINH LIKE ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, "%" + search + "%");
            pstmt.setString(2, "%" + search + "%");
            pstmt.setString(3, "%" + search + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(5);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }

        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> locTheoDVT(String dvtSP) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh\n"
                    + "WHERE mh.DONVITINH = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, dvtSP);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(5);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> locTheoNhom(String maNhom, String maLoai, String dvtSP) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            String sql_maNhom = (maNhom.isEmpty() || maNhom == null) ? "" : " AND nl.MANHOM_LOAI = ? ";
            String sql_maLoai = (maLoai.isEmpty() || maLoai == null) ? "" : " AND l.MALOAI = ? ";
            String sql_dvt = (dvtSP.isEmpty() || dvtSP == null) ? "" : " AND mh.DONVITINH = ? ";
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh, NHOM_LOAI_MATHANG nl, LOAI_MATHANG l\n"
                    + "WHERE mh.MALOAI = l.MALOAI AND l.MANHOM_LOAI = nl.MANHOM_LOAI " + sql_maNhom + sql_maLoai + sql_dvt;
            if (!sql_maNhom.isEmpty() || !sql_maLoai.isEmpty() || !sql_dvt.isEmpty()) {
                PreparedStatement pstmt = conn.getConn().prepareStatement(sql);

                int parameterIndex = 1;

                if (!sql_maNhom.isEmpty()) {
                    pstmt.setString(parameterIndex++, maNhom);
                }

                if (!sql_maLoai.isEmpty()) {
                    pstmt.setString(parameterIndex++, maLoai);
                }

                if (!sql_dvt.isEmpty()) {
                    pstmt.setString(parameterIndex, dvtSP);
                }
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    String MaSP = rs.getString(1);
                    String TenSP = rs.getString(2);
                    String HinhSP = rs.getString(3);
                    String dvt = rs.getString(4);
                    BigDecimal GiaBan = rs.getBigDecimal(5);
                    MatHang mh = new MatHang();
                    mh.setMamh(MaSP);
                    mh.setTenmh(TenSP);
                    mh.setPicture(HinhSP);
                    mh.setGiaBan(GiaBan);
                    mh.setDonvitinh(dvt);
                    this.danhSachMH.add(mh);
                }
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> locTheoGiaThanh(int orderby) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sortOrder = (orderby == 0) ? "ASC" : "DESC";
            String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh "
                    + "ORDER BY mh.GIA_BAN " + sortOrder;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MaSP = rs.getString(1);
                String TenSP = rs.getString(2);
                String HinhSP = rs.getString(3);
                String dvt = rs.getString(4);
                BigDecimal GiaBan = rs.getBigDecimal(5);
                MatHang mh = new MatHang();
                mh.setMamh(MaSP);
                mh.setTenmh(TenSP);
                mh.setPicture(HinhSP);
                mh.setGiaBan(GiaBan);
                mh.setDonvitinh(dvt);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<MatHang> kiemTraIsProductKilogram(String ma) {
        DbConnection conn = new DbConnection();
        this.danhSachMH = new ArrayList<>();
        try {
            String sql = "SELECT mh.IsProductKilogram FROM MAT_HANG mh\n"
                    + "WHERE mh.MAMH = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, ma);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String IsProductKilogram = rs.getString(1);
                MatHang mh = new MatHang();
                mh.setIsProductKilogram(IsProductKilogram);
                this.danhSachMH.add(mh);
            }
        } catch (SQLException e) {
            this.danhSachMH.clear();
            return this.danhSachMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachMH;
    }

    public ArrayList<String> selectDVT() {
        DbConnection conn = new DbConnection();
        this.danhSachDVT = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT DONVITINH FROM MAT_HANG GROUP BY DONVITINH";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String tenDVT = rs.getString(1);
                this.danhSachDVT.add(tenDVT);
            }
        } catch (SQLException e) {
            this.danhSachDVT.clear();
            return this.danhSachDVT;
        } finally {
            conn.getClose();
        }
        return this.danhSachDVT;
    }

    public double selectTonKhoMatHang(String maMH) {
        DbConnection conn = new DbConnection();
        BigDecimal soLTON = BigDecimal.ZERO;
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT SO_LUONG_TON_HIENTAI FROM MAT_HANG WHERE MAMH = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maMH);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                soLTON = rs.getBigDecimal(1);
            }
        } catch (SQLException e) {
            this.danhSachDVT.clear();
            return soLTON.doubleValue();
        } finally {
            conn.getClose();
        }
        return soLTON.doubleValue();
    }
}
