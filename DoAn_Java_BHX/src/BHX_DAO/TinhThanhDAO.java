package BHX_DAO;

import BHX_MODEL.Database.model.Tinhthanh;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TinhThanhDAO {

    public TinhThanhDAO() {

    }

    public ArrayList<Tinhthanh> getAllTinhThanh() {
        DbConnection conn = new DbConnection();
        ArrayList<Tinhthanh> listTinhThanh = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MATINHTHANH, TENTINHTHANH, CAP FROM TINHTHANH";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String maTinhThanh = rs.getString("MATINHTHANH");
                String tenTinhThanh = rs.getString("TENTINHTHANH");
                String cap = rs.getString("CAP");

                Tinhthanh tinhThanh = new Tinhthanh();
                tinhThanh.setMatinhthanh(maTinhThanh);
                tinhThanh.setTentinhthanh(tenTinhThanh);
                tinhThanh.setCap(cap);

                listTinhThanh.add(tinhThanh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listTinhThanh;
    }
}
