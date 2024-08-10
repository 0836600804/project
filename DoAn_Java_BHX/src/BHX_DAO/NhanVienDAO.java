package BHX_DAO;

import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.QuequanNhanvien;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class NhanVienDAO {

    private static ArrayList<Nhanvien> listNV = null;

    public ArrayList<Nhanvien> select() {
        DbConnection conn = new DbConnection();
        ArrayList<Nhanvien> listNV = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MANV, TENNV, NGAYSINH, GIOITINH, TRINHDOHOCVAN, CHUCVU, CCCD, NGAYVAOLAM, HESOLUONG, PHONE, PICTURE FROM NHANVIEN";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MANV = rs.getString(1);
                String TENNV = rs.getString(2);
                Date NGAYSINH = rs.getDate(3);
                String GIOITINH = rs.getString(4);
                String TRINHDOHOCVAN = rs.getString(5);
                String CHUCVU = rs.getString(6);
                String CCCD = rs.getString(7);
                Date NGAYVAOLAM = rs.getDate(8);
                BigDecimal HESOLUONG = rs.getBigDecimal(9);
                String PHONE = rs.getString(10);
                String PICTURE = rs.getString(11);

                Nhanvien nv = new Nhanvien();
                nv.setManv(MANV);
                nv.setTennv(TENNV);
                nv.setNgaysinh(NGAYSINH);
                nv.setGioitinh(GIOITINH);
                nv.setTrinhdohocvan(TRINHDOHOCVAN);
                nv.setChucvu(CHUCVU);
                nv.setCccd(CCCD);
                nv.setNgayvaolam(NGAYVAOLAM);
                nv.setHesoluong(HESOLUONG);
                nv.setPhone(PHONE);
                nv.setPicture(PICTURE);

                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return listNV;
    }

    public Nhanvien selectWithID(String id) {
        DbConnection conn = new DbConnection();
        Nhanvien n_v = null;
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT MANV, TENNV, NGAYSINH, GIOITINH, TRINHDOHOCVAN, CHUCVU, CCCD, NGAYVAOLAM, HESOLUONG, PHONE, PICTURE FROM NHANVIEN WHERE MANV = '" + id + "'";
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                String MANV = rs.getString(1);
                String TENNV = rs.getString(2);
                Date NGAYSINH = rs.getDate(3);
                String GIOITINH = rs.getString(4);
                String TRINHDOHOCVAN = rs.getString(5);
                String CHUCVU = rs.getString(6);
                String CCCD = rs.getString(7);
                Date NGAYVAOLAM = rs.getDate(8);
                BigDecimal HESOLUONG = rs.getBigDecimal(9);
                String PHONE = rs.getString(10);
                String PICTURE = rs.getString(11).toString();

                n_v = new Nhanvien();
                n_v.setManv(MANV);
                n_v.setTennv(TENNV);
                n_v.setNgaysinh(NGAYSINH);
                n_v.setGioitinh(GIOITINH);
                n_v.setTrinhdohocvan(TRINHDOHOCVAN);
                n_v.setChucvu(CHUCVU);
                n_v.setCccd(CCCD);
                n_v.setNgayvaolam(NGAYVAOLAM);
                n_v.setHesoluong(HESOLUONG);
                n_v.setPhone(PHONE);
                n_v.setPicture(PICTURE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return n_v;
    }

    public void updateNhanVien(Nhanvien nhanVien) {
        DbConnection conn = new DbConnection();
        try {
            PreparedStatement ps = conn.getConn().prepareStatement("UPDATE NHANVIEN SET TENNV=?, NGAYSINH=?, GIOITINH=?, TRINHDOHOCVAN=?, CHUCVU=?, PICTURE=?, CCCD=?, NGAYVAOLAM=?, HESOLUONG=?, PHONE=? WHERE MANV=?");
            ps.setString(1, nhanVien.getTennv());
            ps.setDate(2, new java.sql.Date(nhanVien.getNgaysinh().getTime()));
            ps.setString(3, nhanVien.getGioitinh());
            ps.setString(4, nhanVien.getTrinhdohocvan());
            ps.setString(5, nhanVien.getChucvu());
            ps.setString(6, nhanVien.getPicture());
            ps.setString(7, nhanVien.getCccd());
            ps.setDate(8, new java.sql.Date(nhanVien.getNgayvaolam().getTime()));
            ps.setBigDecimal(9, nhanVien.getHesoluong());
            ps.setString(10, nhanVien.getPhone());
            ps.setString(11, nhanVien.getManv());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
    }

    public void updateQueQuan(String maNhanVien, QuequanNhanvien queQuan) {
        DbConnection conn = new DbConnection();
        try {
            Statement st = conn.getConn().createStatement();

            // Kiểm tra xem quê quán của nhân viên đã tồn tại trong CSDL hay chưa
            String checkQuery = "SELECT COUNT(*) FROM QUEQUAN_NHANVIEN WHERE MANV = '" + maNhanVien + "'";
            ResultSet rs = st.executeQuery(checkQuery);
            rs.next();
            int count = rs.getInt(1);

            if (count > 0) {
                // Nếu quê quán đã tồn tại, thực hiện cập nhật thông tin quê quán
                String updateQuery = "UPDATE QUEQUAN_NHANVIEN SET ";
                if (queQuan.getQuanHuyen() != null) {
                    updateQuery += "MAQUAN_HUYEN = '" + queQuan.getQuanHuyen().getMaquanHuyen() + "', ";
                } else {
                    updateQuery += "MAQUAN_HUYEN = NULL, ";
                }
                if (queQuan.getXaPhuong() != null) {
                    updateQuery += "MAXA_PHUONG = '" + queQuan.getXaPhuong().getMaxaPhuong() + "', ";
                } else {
                    updateQuery += "MAXA_PHUONG = NULL, ";
                }
                if (queQuan.getTinhthanh() != null) {
                    updateQuery += "MATINHTHANH = '" + queQuan.getTinhthanh().getMatinhthanh() + "', ";
                } else {
                    updateQuery += "MATINHTHANH = NULL, ";
                }
                // Kiểm tra nếu có đường thì gán, không có thì không gán vào câu lệnh SQL
                if (queQuan.getTenduong() != null) {
                    updateQuery += "TENDUONG = N'" + queQuan.getTenduong() + "'";
                } else {
                    updateQuery += "TENDUONG = NULL, ";
                }
                // Loại bỏ dấu phẩy cuối cùng nếu có
                if (updateQuery.endsWith(", ")) {
                    updateQuery = updateQuery.substring(0, updateQuery.length() - 2);
                }
                updateQuery += " WHERE MANV = '" + maNhanVien + "'";
                st.executeUpdate(updateQuery);
            } else {
                // Nếu quê quán chưa tồn tại, thực hiện thêm mới thông tin quê quán
                String insertQuery = "INSERT INTO QUEQUAN_NHANVIEN (MANV";
                String valuesQuery = "VALUES ('" + maNhanVien + "'";

                // Kiểm tra và thêm các cột có giá trị vào câu lệnh SQL
                if (queQuan.getQuanHuyen() != null) {
                    insertQuery += ", MAQUAN_HUYEN";
                    valuesQuery += ", '" + queQuan.getQuanHuyen().getMaquanHuyen() + "'";
                }else{
                    insertQuery += ", MAQUAN_HUYEN";
                    valuesQuery += ", NULL ";
                }
                if (queQuan.getXaPhuong() != null) {
                    insertQuery += ", MAXA_PHUONG";
                    valuesQuery += ", '" + queQuan.getXaPhuong().getMaxaPhuong() + "'";
                }else{
                    insertQuery += ", MAXA_PHUONG";
                    valuesQuery += ", NULL ";
                }
                if (queQuan.getTinhthanh() != null) {
                    insertQuery += ", MATINHTHANH";
                    valuesQuery += ", '" + queQuan.getTinhthanh().getMatinhthanh() + "'";
                }else{
                    insertQuery += ", MATINHTHANH";
                    valuesQuery += ", NULL ";
                }
                // Kiểm tra nếu có đường thì thêm vào câu lệnh SQL
                if (queQuan.getTenduong() != null) {
                    insertQuery += ", TENDUONG";
                    valuesQuery += ", N'" + queQuan.getTenduong() + "'";
                }else{
                    insertQuery += ", TENDUONG";
                    valuesQuery += ", NULL ";
                }
                // Hoàn thành câu lệnh SQL INSERT
                insertQuery += ") ";
                valuesQuery += ")";

                st.executeUpdate(insertQuery + valuesQuery);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
    }
}
