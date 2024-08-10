package BHX_DAO;

import BHX_MODEL.Database.model.LoaiMathang;
import BHX_MODEL.Database.model.MatHang;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LoaiMatHangDAO {

   private ArrayList<MatHang> danhSachMH;
   private ArrayList<LoaiMathang> danhSachLoaiMH;

   public ArrayList<MatHang> selectMatHangWithIDLoaiMH(String maLoai) {
      DbConnection conn = new DbConnection();
      this.danhSachMH = new ArrayList<>();
      try {
         Statement st = conn.getConn().createStatement();
         String sql = "SELECT mh.MAMH, mh.TENMH, mh.PICTURE, mh.DONVITINH, mh.GIA_BAN FROM MAT_HANG mh, LOAI_MATHANG lmh WHERE mh.MALOAI = lmh.MALOAI AND lmh.MALOAI = ?";
         PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
         pstmt.setString(1, maLoai);
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

   public ArrayList<LoaiMathang> select() {
      DbConnection conn = new DbConnection();
      this.danhSachLoaiMH = new ArrayList<>();
      try {
         Statement st = conn.getConn().createStatement();
         String sql = "SELECT * FROM LOAI_MATHANG";
         ResultSet rs = st.executeQuery(sql);
         while (rs.next()) {
            String MALOAI = rs.getString(1);
            String TENLOAI = rs.getString(2);
            String PICTURE = rs.getString(3);
            LoaiMathang lmh = new LoaiMathang();
            lmh.setMaloai(MALOAI);
            lmh.setTenloai(TENLOAI);
            lmh.setPicture(PICTURE);
            this.danhSachLoaiMH.add(lmh);
         }
      } catch (SQLException e) {
         this.danhSachLoaiMH.clear();
         return this.danhSachLoaiMH;
      } finally {
         conn.getClose();
      }
      return this.danhSachLoaiMH;
   }
}
