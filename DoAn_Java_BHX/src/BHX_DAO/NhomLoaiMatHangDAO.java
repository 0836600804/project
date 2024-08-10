package BHX_DAO;

import BHX_MODEL.Database.model.LoaiMathang;
import BHX_MODEL.Database.model.MatHang;
import BHX_MODEL.Database.model.NhomLoaiMathang;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhomLoaiMatHangDAO {
    private ArrayList<NhomLoaiMathang> danhSachNLMH;

    public ArrayList<NhomLoaiMathang> select() {
        DbConnection conn = new DbConnection();
        this.danhSachNLMH = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT * FROM NHOM_LOAI_MATHANG";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MANHOMLOAI = rs.getString(1);
                String TENNHOMLOAI = rs.getString(3);
                String PICTURE = rs.getString(2);
                NhomLoaiMathang nlmh = new NhomLoaiMathang();
                nlmh.setManhomLoai(MANHOMLOAI);
                nlmh.setTennhomLoai(TENNHOMLOAI);
                nlmh.setPicture(PICTURE);
                this.danhSachNLMH.add(nlmh);
            }
        } catch (SQLException e) {
            this.danhSachNLMH.clear();
            return this.danhSachNLMH;
        } finally {
            conn.getClose();
        }
        return this.danhSachNLMH;
    }
}
