package BHX_DAO;

import BHX_MODEL.Database.model.Khachhang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class KhachHangDAO {

    private static ArrayList<Khachhang> listKH = null;

    public ArrayList<Khachhang> select() {
        DbConnection conn = new DbConnection();
        this.listKH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MAKH, TENKH, NGAYSINH, GIOITINH, CCCD, EMAIL, PHONE FROM KHACHHANG";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MAKH = rs.getString(1);
                String TENKH = rs.getString(2);
                Date NGAYSINH = rs.getDate(3);
                String GIOITINH = rs.getString(4);
                String CCCD = rs.getString(5);
                String EMAIL = rs.getString(6);
                String PHONE = rs.getString(7);
                Khachhang kh = new Khachhang();
                kh.setMakh(MAKH);
                kh.setTenkh(TENKH);
                kh.setNgaysinh(NGAYSINH);
                kh.setGioitinh(GIOITINH);
                kh.setEmail(EMAIL);
                kh.setCccd(CCCD);
                kh.setPhone(PHONE);
                this.listKH.add(kh);
            }
        } catch (SQLException e) {
            this.listKH.clear();
            return this.listKH;
        } finally {
            conn.getClose();
        }
        return this.listKH;
    }
}
