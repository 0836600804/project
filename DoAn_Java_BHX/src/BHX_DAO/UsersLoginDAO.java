package BHX_DAO;

import BHX_MODEL.Database.model.LoaiPhanquyen;
import BHX_MODEL.Database.model.Nhanvien;
import BHX_MODEL.Database.model.UsersLogin;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class UsersLoginDAO {

    private static ArrayList<UsersLogin> listUSERS = null;

    public ArrayList<UsersLogin> select() {
        DbConnection conn = new DbConnection();
        this.listUSERS = new ArrayList<>();
        try {
            Statement st = conn.getConn().createStatement();
            String sql = "SELECT ID, MANV, PASSWORD, IsLoginFirst, MA_LOAI_PQ FROM USERS_LOGIN";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int ID = rs.getInt(1);
                Nhanvien nv = new Nhanvien(rs.getString(2));
                String PASSWORD = rs.getString(3);
                int IsLoginFirst = rs.getInt(4);
                LoaiPhanquyen pq = new LoaiPhanquyen(rs.getString(5));
                UsersLogin users = new UsersLogin();
                users.setId(ID);
                users.setManv(nv);
                users.setPassword(PASSWORD);
                users.setIsLoginFirst(IsLoginFirst);
                users.setMaLoaiPq(pq);
                this.listUSERS.add(users);
            }
        } catch (SQLException e) {
            this.listUSERS.clear();
            return this.listUSERS;
        } finally {
            conn.getClose();
        }
        return this.listUSERS;
    }

    public boolean authenticate(String username, String password) {
        DbConnection conn = new DbConnection();
        boolean isValidUser = false;
        try {
            String sql = "SELECT COUNT(*) FROM USERS_LOGIN WHERE MANV = ? AND PASSWORD = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                isValidUser = count == 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return isValidUser;
    }

    public int checkLoginInfo(String username, String password) {
        DbConnection conn = new DbConnection();
        int isLoginFirst = -1;
        try {
            String sql = "SELECT IsLoginFirst FROM USERS_LOGIN WHERE MANV = ? AND PASSWORD = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                isLoginFirst = rs.getInt("IsLoginFirst");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }
        return isLoginFirst;
    }

    public boolean updatePasswordAndResetIsLoginFirst(String username, String newPassword) {
        DbConnection conn = new DbConnection();
        boolean isSuccess = false;

        try {
            // Cập nhật mật khẩu và thiết lập IsLoginFirst về 0
            String sql = "UPDATE USERS_LOGIN SET PASSWORD = ?, IsLoginFirst = 0 WHERE MANV = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);

            int rowsAffected = pstmt.executeUpdate();
            isSuccess = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }

        return isSuccess;
    }

    public Nhanvien getEmployeeInfoByAccount(String account) {
        DbConnection conn = new DbConnection();
        Nhanvien employeeInfo = null;

        try {
            String sql = "SELECT NV.MANV, NV.TENNV, NV.NGAYSINH, NV.GIOITINH, NV.TRINHDOHOCVAN, NV.CHUCVU, NV.PICTURE, NV.CCCD, NV.NGAYVAOLAM, NV.HESOLUONG, NV.PHONE "
                    + "FROM NHANVIEN NV "
                    + "INNER JOIN USERS_LOGIN UL ON NV.MANV = UL.MANV "
                    + "WHERE UL.MANV = ?";
            PreparedStatement pstmt = conn.getConn().prepareStatement(sql);
            pstmt.setString(1, account);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String ma = rs.getString("MANV");
                String name = rs.getString("TENNV");
                Date birthDate = rs.getDate("NGAYSINH");
                String gender = rs.getString("GIOITINH");
                String educationLevel = rs.getString("TRINHDOHOCVAN");
                String position = rs.getString("CHUCVU");
                String picturePath = rs.getString("PICTURE");
                String cccd = rs.getString("CCCD");
                Date startDate = rs.getDate("NGAYVAOLAM");
                BigDecimal salaryCoefficient = rs.getBigDecimal("HESOLUONG");
                String phoneNumber = rs.getString("PHONE");

                // Tạo đối tượng Nhân viên từ dữ liệu lấy được từ cơ sở dữ liệu
                Nhanvien nv = new Nhanvien();
                nv.setManv(ma);
                nv.setTennv(name);
                nv.setNgaysinh(birthDate);
                nv.setGioitinh(gender);
                nv.setTrinhdohocvan(educationLevel);
                nv.setChucvu(position);
                nv.setPicture(picturePath);
                nv.setCccd(cccd);
                nv.setNgayvaolam(startDate);
                nv.setHesoluong(salaryCoefficient);
                nv.setPhone(phoneNumber);

                return nv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.getClose();
        }

        return employeeInfo;
    }

}
