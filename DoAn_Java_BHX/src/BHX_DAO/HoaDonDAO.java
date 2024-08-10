package BHX_DAO;

import BHX_MODEL.Database.model.Hoadon;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_PRINT_REPORT.ReportChiTietHoaDonObj;
import BHX_PRINT_REPORT.ReportHoaDonObj;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class HoaDonDAO {

    private static ArrayList<Hoadon> listHD = null;

    public ArrayList<Hoadon> kiemTraIDHD(String maHD) {
        DbConnection conn = new DbConnection();
        this.listHD = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "select * from HOADON WHERE ID_HOADON = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String ID_HOADON = rs.getString(1);
                Hoadon cd = new Hoadon();
                cd.setIdHoadon(ID_HOADON);
                this.listHD.add(cd);
            }
        } catch (SQLException e) {
            this.listHD.clear();
            return this.listHD;
        } finally {
            conn.getClose();
        }
        return this.listHD;
    }

    public ArrayList<Hoadon> selectWithID(String maHD) {
        DbConnection conn = new DbConnection();
        this.listHD = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "select ID_HOADON, NGAYLAP_HD, MANV, MAKH from HOADON WHERE ID_HOADON = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, maHD);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String ID_HOADON = rs.getString(1);
                Date ngayLap = rs.getDate(2);
                String Ma_NV = rs.getString(3);
                Hoadon cd = new Hoadon();
                cd.setIdHoadon(ID_HOADON);
                cd.setManv(new Nhanvien(Ma_NV));
                cd.setNgaylapHd(ngayLap);
                this.listHD.add(cd);
            }
        } catch (SQLException e) {
            this.listHD.clear();
            return this.listHD;
        } finally {
            conn.getClose();
        }
        return this.listHD;
    }

    public boolean insertHD(Hoadon hoadon) {
        DbConnection conn = new DbConnection();
        try {
            String sql = "INSERT INTO HOADON(ID_HOADON, NGAYLAP_HD, MANV) VALUES(?, ?, ?)";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, hoadon.getIdHoadon());

            //
            java.util.Date utilDate = hoadon.getNgaylapHd();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstmt.setDate(2, sqlDate);

            pstmt.setString(3, hoadon.getManv().getManv());
            int x = pstmt.executeUpdate();
            if (x > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.getClose();
        }
        return false;
    }

    public boolean deleteHD(String idHD) {
        DbConnection conn = new DbConnection();
        try {
            String sql = "DELETE FROM HOADON WHERE ID_HOADON = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, idHD);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.getClose();
        }
        return false;
    }

    public boolean updateHD(String idHD, BigDecimal tienKHGui) {
        DbConnection conn = new DbConnection();
        try {
            String sql = "UPDATE HOADON SET TIEN_KHACH_GUI = ? WHERE ID_HOADON = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setBigDecimal(1, tienKHGui);
            pstmt.setString(2, idHD);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conn.getClose();
        }
        return false;
    }

    public ReportHoaDonObj getHoaDonAndChiTiet(String idHoaDon) {
        ReportHoaDonObj reportHoaDon = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            DbConnection conn = new DbConnection();
            connection = conn.getConn();

            // Truy vấn để lấy thông tin hóa đơn
            String hoaDonQuery = "SELECT hd.ID_HOADON, hd.NGAYLAP_HD, hd.MANV, hd.MAKH, hd.TONGTIEN_HD, hd.TONGTIEN_GG, hd.TIEN_KHACH_GUI, hd.TONG_SO_LUONG, (hd.TIEN_KHACH_GUI - hd.TONGTIEN_HD) AS TONGTIEN_TL\n"
                    + "\nFROM HOADON hd\n"
                    + "\nWHERE hd.ID_HOADON = ?";
            statement = connection.prepareStatement(hoaDonQuery);
            statement.setString(1, idHoaDon);
            resultSet = statement.executeQuery();

            // Xử lý kết quả của thông tin hóa đơn
            if (resultSet.next()) {
                reportHoaDon = new ReportHoaDonObj();
                reportHoaDon.setID_HOADON(resultSet.getString("ID_HOADON"));
                reportHoaDon.setNGAYLAP_HD(resultSet.getString("NGAYLAP_HD"));
                reportHoaDon.setMANV(resultSet.getString("MANV") != null ? resultSet.getString("MANV") : "Nhân Viên.");
                reportHoaDon.setMAKH(resultSet.getString("MAKH") != null ? resultSet.getString("MAKH") : "Khách Bán Lẻ.");

                BigDecimal TONGTIEN_HD = resultSet.getBigDecimal("TONGTIEN_HD");
                BigDecimal TONGTIEN_GG = resultSet.getBigDecimal("TONGTIEN_GG");
                BigDecimal TIEN_KHACH_GUI = resultSet.getBigDecimal("TIEN_KHACH_GUI");
                int TONG_SO_LUONG = resultSet.getInt("TONG_SO_LUONG");
                BigDecimal TONGTIEN_TL = resultSet.getBigDecimal("TONGTIEN_TL");

                reportHoaDon.setTONGTIEN_HD(formatterCurrencyVND(TONGTIEN_HD));
                reportHoaDon.setTONGTIEN_GG(formatterCurrencyVND(TONGTIEN_GG));
                reportHoaDon.setTIEN_KHACH_GUI(formatterCurrencyVND(TIEN_KHACH_GUI));
                reportHoaDon.setTONG_SO_LUONG(String.valueOf(TONG_SO_LUONG));
                reportHoaDon.setTONGTIEN_TL(formatterCurrencyVND(TONGTIEN_TL));
            }

            // Đóng statement để sử dụng lại cho truy vấn tiếp theo
            statement.close();

            // Truy vấn để lấy các chi tiết hóa đơn
            String chiTietQuery = "SELECT cthd.SOLUONG, cthd.THANH_TIEN, cthd.THANH_TIEN_GG, mh.TENMH, mh.GIA_BAN, mh.IsProductKilogram "
                    + "\nFROM CHITIET_HOADON cthd, MAT_HANG mh "
                    + "\nWHERE cthd.MAMH = mh.MAMH AND cthd.ID_HOADON = ?";
            statement = connection.prepareStatement(chiTietQuery);
            statement.setString(1, idHoaDon);
            resultSet = statement.executeQuery();

            // Xử lý kết quả của các chi tiết hóa đơn
            ArrayList<ReportChiTietHoaDonObj> danhSachCTHD = new ArrayList<>();
            while (resultSet.next()) {
                ReportChiTietHoaDonObj chiTietHoaDon = new ReportChiTietHoaDonObj();

                BigDecimal THANH_TIEN = resultSet.getBigDecimal("THANH_TIEN");
                BigDecimal THANH_TIEN_GG = resultSet.getBigDecimal("THANH_TIEN_GG");
                BigDecimal GIA_BAN = resultSet.getBigDecimal("GIA_BAN");
                BigDecimal SOLUONG = resultSet.getBigDecimal("SOLUONG");
                chiTietHoaDon.setTHANH_TIEN(formatterCurrencyVND(THANH_TIEN));
                chiTietHoaDon.setTHANH_TIEN_GG(formatterCurrencyVND(THANH_TIEN_GG));
                chiTietHoaDon.setSOLUONG(SOLUONG.setScale(3, RoundingMode.HALF_UP).toString());
                chiTietHoaDon.setTENMH(resultSet.getString("TENMH"));
                chiTietHoaDon.setGIA_BAN(formatterCurrencyVND(GIA_BAN));

                String IsProductKilogram = resultSet.getString("IsProductKilogram");
                if (IsProductKilogram.toLowerCase().equals("false")) {
                    chiTietHoaDon.setSOLUONG(SOLUONG.setScale(0, RoundingMode.HALF_UP).toString());
                }

                danhSachCTHD.add(chiTietHoaDon);
            }

            // Đặt danh sách chi tiết hóa đơn vào đối tượng hóa đơn
            if (reportHoaDon != null) {
                reportHoaDon.setDanhSachCTHD(danhSachCTHD);
            }

            // Trả về thông tin hóa đơn và các chi tiết hóa đơn tương ứng
            return reportHoaDon;

        } catch (SQLException e) {
            e.printStackTrace();
            // Xử lý ngoại lệ
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Trả về null nếu có lỗi xảy ra
        return null;
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

}
