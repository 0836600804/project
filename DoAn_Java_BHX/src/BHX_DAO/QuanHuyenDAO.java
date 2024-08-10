package BHX_DAO;

import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.Tinhthanh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanHuyenDAO {

    public QuanHuyenDAO() {

    }

    public ArrayList<QuanHuyen> getAllQuanHuyen() {
        DbConnection conn = new DbConnection();
        ArrayList<QuanHuyen> listQuanHuyen = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAQUAN_HUYEN, TENQUAN_HUYEN, CAP, MATINHTHANH FROM QUAN_HUYEN";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maQuanHuyen = rs.getString("MAQUAN_HUYEN");
                String tenQuanHuyen = rs.getString("TENQUAN_HUYEN");
                String cap = rs.getString("CAP");
                String maTinhThanh = rs.getString("MATINHTHANH");

                QuanHuyen quanHuyen = new QuanHuyen();
                quanHuyen.setMaquanHuyen(maQuanHuyen);
                quanHuyen.setTenquanHuyen(tenQuanHuyen);
                quanHuyen.setCap(cap);
                quanHuyen.setMatinhthanh(new Tinhthanh(maTinhThanh));

                listQuanHuyen.add(quanHuyen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listQuanHuyen;
    }

    public ArrayList<QuanHuyen> loadQuanHuyenWithIDTinh(String maTinhThanh) {
        DbConnection conn = new DbConnection();
        ArrayList<QuanHuyen> listQuanHuyen = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAQUAN_HUYEN, TENQUAN_HUYEN, CAP, MATINHTHANH FROM QUAN_HUYEN WHERE MATINHTHANH = '" + maTinhThanh + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maQuanHuyen = rs.getString("MAQUAN_HUYEN");
                String tenQuanHuyen = rs.getString("TENQUAN_HUYEN");
                String cap = rs.getString("CAP");
                String maTinhThanh_ = rs.getString("MATINHTHANH");

                QuanHuyen quanHuyen = new QuanHuyen();
                quanHuyen.setMaquanHuyen(maQuanHuyen);
                quanHuyen.setTenquanHuyen(tenQuanHuyen);
                quanHuyen.setCap(cap);
                quanHuyen.setMatinhthanh(new Tinhthanh(maTinhThanh_));

                listQuanHuyen.add(quanHuyen);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listQuanHuyen;
    }

}
