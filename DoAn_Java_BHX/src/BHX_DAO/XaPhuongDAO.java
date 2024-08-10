package BHX_DAO;

import BHX_MODEL.Database.model.QuanHuyen;
import BHX_MODEL.Database.model.XaPhuong;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class XaPhuongDAO {

    public XaPhuongDAO() {

    }

    public ArrayList<XaPhuong> getAllXaPhuong() {
        DbConnection conn = new DbConnection();
        ArrayList<XaPhuong> listXaPhuong = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAXA_PHUONG, TENXA_PHUONG, MAQUAN_HUYEN, CAP FROM XA_PHUONG";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maXaPhuong = rs.getString("MAXA_PHUONG");
                String tenXaPhuong = rs.getString("TENXA_PHUONG");
                String maQuanHuyen = rs.getString("MAQUAN_HUYEN");
                String cap = rs.getString("CAP");

                XaPhuong xaPhuong = new XaPhuong();
                xaPhuong.setMaxaPhuong(maXaPhuong);
                xaPhuong.setTenxaPhuong(tenXaPhuong);
                xaPhuong.setMaquanHuyen(new QuanHuyen(maQuanHuyen));
                xaPhuong.setCap(cap);

                listXaPhuong.add(xaPhuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listXaPhuong;
    }

    public ArrayList<XaPhuong> loadXaPhuongWithIDHuyen(String maQuanHuyen) {
        DbConnection conn = new DbConnection();
        ArrayList<XaPhuong> listXaPhuong = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAXA_PHUONG, TENXA_PHUONG, MAQUAN_HUYEN, CAP FROM XA_PHUONG WHERE MAQUAN_HUYEN = '" + maQuanHuyen + "'";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maXaPhuong = rs.getString("MAXA_PHUONG");
                String tenXaPhuong = rs.getString("TENXA_PHUONG");
                String maQuanHuyen_ = rs.getString("MAQUAN_HUYEN");
                String cap = rs.getString("CAP");

                XaPhuong xaPhuong = new XaPhuong();
                xaPhuong.setMaxaPhuong(maXaPhuong);
                xaPhuong.setTenxaPhuong(tenXaPhuong);
                xaPhuong.setMaquanHuyen(new QuanHuyen(maQuanHuyen_));
                xaPhuong.setCap(cap);

                listXaPhuong.add(xaPhuong);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listXaPhuong;
    }
}
