package BHX_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class DbConnection {

    private Connection conn;
    private String url, user, password;
    private Exception message;
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Exception getMessage() {
        return message;
    }

    public void setMessage(Exception message) {
        this.message = message;
    }

    public DbConnection() {
        try {
            String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=QL_BANHANG_BHX;encrypt=true;trustServerCertificate=true;";
            String user = "sa";
            String password = "123";
            Class.forName(DbConnection.driver);
            this.conn = DriverManager.getConnection(connectionUrl, user, password);
        } catch (ClassNotFoundException e1) {
            this.message = e1;
        } catch (SQLTimeoutException e2) {
            this.message = e2;
        } catch (SQLException e3) {
            this.message = e3;
        }
    }

    public DbConnection(String url, String user, String password) {
        try {
            Class.forName(DbConnection.driver);
            this.conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e1) {
            this.message = e1;
        } catch (SQLTimeoutException e2) {
            this.message = e2;
        } catch (SQLException e3) {
            this.message = e3;
        }
    }

    public DbConnection(DbConnection conn) {
        try {
            this.conn = conn.getConn();
        } catch (Exception e) {
            this.message = e;
        }
    }

    public void getClose() {
        try {
            this.conn.close();
        } catch (SQLTimeoutException e1) {
            this.message = e1;
        } catch (SQLException e2) {
            this.message = e2;
        }
    }
}
