package BHX_DAO;

import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.QuequanNhanvien;
import BHX_MODEL.Database.model.Tinhthanh;
import BHX_MODEL.Database.model.XaPhuong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QueQuanNVDAO {

    private static ArrayList<QuequanNhanvien> listKH = null;

    public QuequanNhanvien loadQueQuanNhanVien(String maNV) {
        DbConnection conn = new DbConnection();
        QuequanNhanvien queQuan = null;
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAQUAN_HUYEN, MAXA_PHUONG, MATINHTHANH, TENDUONG FROM QUEQUAN_NHANVIEN WHERE MANV = '" + maNV + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String maQuanHuyen = rs.getString(1);
                String maXaPhuong = rs.getString(2);
                String maTinhThanh = rs.getString(3);
                String tenDuong = rs.getString(4);

                queQuan = new QuequanNhanvien();
                queQuan.setNhanvien(new Nhanvien(maNV));
                queQuan.setQuanHuyen(new QuanHuyen(maQuanHuyen));
                queQuan.setXaPhuong(new XaPhuong(maXaPhuong));
                queQuan.setTinhthanh(new Tinhthanh(maTinhThanh));
                queQuan.setTenduong(tenDuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return queQuan;
    }

    public String getTenTinhThanh(String maTinhThanh) {
        DbConnection conn = new DbConnection();
        String tenTinhThanh = null;
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT TENTINHTHANH FROM TINHTHANH WHERE MATINHTHANH = '" + maTinhThanh + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tenTinhThanh = rs.getString("TENTINHTHANH");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return tenTinhThanh;
    }

    public String getTenQuanHuyen(String maQuanHuyen) {
        DbConnection conn = new DbConnection();
        String tenQuanHuyen = null;
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT TENQUAN_HUYEN FROM QUAN_HUYEN WHERE MAQUAN_HUYEN = '" + maQuanHuyen + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                tenQuanHuyen = rs.getString("TENQUAN_HUYEN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return tenQuanHuyen;
    }

    public String getTenXaPhuong(String maXaPhuong) {
        String tenXaPhuong = null;
        if (maXaPhuong != null && !maXaPhuong.isEmpty()) {
            DbConnection conn = new DbConnection();
            try {
                Statement st = conn.getConn().createStatement();
                String sql = "SELECT TENXA_PHUONG FROM XA_PHUONG WHERE MAXA_PHUONG = '" + maXaPhuong + "'";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    tenXaPhuong = rs.getString("TENXA_PHUONG");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn.getClose();
            }
        }
        return tenXaPhuong;
    }
}
