package BHX_DAO;

import BHX_MODEL.Database.model.ChitietHoadon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ChitiethoadonDAO {

    ArrayList<ChitietHoadon> list;

    public ChitiethoadonDAO() {
    }

    public boolean insertData(ArrayList<ChitietHoadon> list) {
        DbConnection conn = new DbConnection();
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = conn.getConn();
            connection.setAutoCommit(false); // Tắt auto-commit để bắt đầu giao dịch

            String sql = "INSERT INTO CHITIET_HOADON(ID_HOADON, MAMH, SOLUONG) VALUES(?, ?, ?)";
            pstmt = connection.prepareStatement(sql);

            // Lặp qua danh sách và thêm dữ liệu vào câu lệnh SQL
            for (ChitietHoadon cthd : list) {
                pstmt.setString(1, cthd.getHoadon().getIdHoadon());
                pstmt.setString(2, cthd.getMatHang().getMamh());
                pstmt.setBigDecimal(3, cthd.getSoluong());
                pstmt.addBatch(); // Thêm câu lệnh vào batch
            }

            int[] results = pstmt.executeBatch(); // Thực hiện batch các câu lệnh

            // Kiểm tra kết quả của từng câu lệnh trong batch
            for (int result : results) {
                if (result <= 0) {
                    connection.rollback(); // Rollback nếu có lỗi
                    return false;
                }
            }

            connection.commit(); // Commit nếu không có lỗi
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback nếu có lỗi
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false; // Xảy ra lỗi, trả về false
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close(); // Đóng PreparedStatement
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.setAutoCommit(true); // Bật lại auto-commit
                    connection.close(); // Đóng kết nối
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
